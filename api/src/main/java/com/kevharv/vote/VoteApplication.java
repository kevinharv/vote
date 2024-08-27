package com.kevharv.vote;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kevharv.vote.models.PoliticalParty;
import com.kevharv.vote.repositories.PoliticalPartyRepository;

@SpringBootApplication
public class VoteApplication {
	
	@Value("${debug.test-data.insert}")
	private boolean insertTestData;
	@Value("${debug.test-data.quantity}")
	private int testDataAmount;
	@Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
	private int batchSize;

	private static final Logger log = LoggerFactory.getLogger(VoteApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(VoteApplication.class, args);
	}

	@Bean
	public CommandLineRunner insertParties(PoliticalPartyRepository politicalPartyRepository) {
		return (args) -> {
			if (insertTestData) {
				

				List<PoliticalParty> parties = new ArrayList<PoliticalParty>(batchSize);
				for (int i = 0; i < batchSize; i++) {
					parties.add(new PoliticalParty("New Test Party" + i));
				}

				for (int i = 0; i < testDataAmount; i += batchSize) {
					// String name = "Test Party " + i;
					
					if (i % 1000 == 0) {
						log.info("Inserted test party " + i);
					}

					// PoliticalParty party = new PoliticalParty(name);
					// politicalPartyRepository.save(party);

					politicalPartyRepository.saveAll(parties);
					
				}
			}
		};
	}
}
