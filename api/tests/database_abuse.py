import requests
import json
from concurrent.futures import ThreadPoolExecutor, as_completed

# Function to make a POST request
def make_post_request(url, payload):
    try:
        response = requests.post(url, json=payload)
        return response.status_code, response.text
    except Exception as e:
        return None, str(e)

# Function to handle multiple requests
def send_requests(url, payload, num_requests, max_workers=10):
    results = []
    with ThreadPoolExecutor(max_workers=max_workers) as executor:
        futures = [executor.submit(make_post_request, url, payload) for _ in range(num_requests)]
        for future in as_completed(futures):
            result = future.result()
            results.append(result)
            if len(results) % 1000 == 0:  # Log progress every 1000 requests
                print(f"{len(results)} requests completed.")
    return results

# Example usage
if __name__ == "__main__":
    url = "http://localhost:8080/parties"  # Replace with your URL
    payload = {"name": "Foo Party"}  # Replace with your payload
    num_requests = 2_700_000
    max_workers = 100  # Adjust based on your system's capacity

    results = send_requests(url, payload, num_requests, max_workers=max_workers)

    # Optionally, handle results or errors
    successful_requests = sum(1 for status, _ in results if status == 200)
    print(f"Successfully completed {successful_requests} requests.")
