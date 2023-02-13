# Xpand Challange
## Overview

Xpand Challange provides the following functionalities:
- Management of movies;
- Management of actors.

## Technologies
- Java 11
- Spring Boot 2.6.7
- H2 Database (Embedded in memory)
- Maven

## Documentation
- [Postman Collection](\scripts\api\Xpand Challenge.postman_collection.json)

# Development Environment
##  Prerequisites
- Install [Java 11](https://adoptium.net/temurin/releases/?version=11)
- Install [Maven](https://www.baeldung.com/install-maven-on-windows-linux-mac)

## Compiling
- Command Line
    - On the root of the project run "mvn clean install"

- IntelliJ IDEA
    - Run Maven target "build" on project root

## Optional
- Install [Postman](https://www.postman.com/downloads/)
    - Import \scripts\api\Xpand Challenge.postman_collection.json
    - Import environment \scripts\api\movie environment.postman_environment.json