Currency rates app Spring Boot app

Starts server at port 8080 with a single endpoint `/ratesForMonth` returning currency rates for last 30 days.

Subsequent calls to endpoint will provide data from cache without needlessly polling external sources. 

**Requirements**: jdk11+


