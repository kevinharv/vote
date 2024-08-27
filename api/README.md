# Voting Platform API

# To-Do
## Planned
- Fix geography model
    - States, counties, municipalities should have parents
- CRUD operations for applicable models
- Ballot builder
- Logging all operations
- Expose metrics
- Status endpoints
    - How many voters are registered? By geography?
    - How many elections are running? Scheduled?
    - How many votes have been cast? Total? For election X?
    - Who won election X?

## Bucket List
- Robust user authentication
    - Likely an OAuth/OIDC implementation
    - Might be separate service
- Position eligibility management
    - Only politicans within given geography
    - Assist with election building process
- Batch operations and/or caching for aggregations
    - Election results

## Not Happening