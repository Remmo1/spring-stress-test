#!/bin/bash

# clean if needed
kill $(lsof -t -i:8080)
kill $(lsof -t -i:8081)
kill $(lsof -t -i:8082)

# start microservices
cd bookstore && mvn spring-boot:run &
cd rating && mvn spring-boot:run &
cd validator && mvn spring-boot:run &

