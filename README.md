# Song Service

This project is a Spring Boot application that provides song information.

## Dependencies
Before running the Spring Boot project, please ensure that you have the following dependencies installed:

- `Java 17` The source code is written in Java 17, so make sure you have it installed and set up properly on your machine.
- `Maven 3.8+` The project uses Maven to manage dependencies and build the code. You will need to have Maven 3.6 or higher installed on your machine to build the project.
- `Docker` The project is designed to run in Docker containers. You will need to have Docker installed on your machine to create containers of the services described in the docker-compose.yml file.

Please make sure that all of these dependencies are installed and configured correctly before attempting to run the project.

## Running Project
### First time execution
- `docker network create resource-network`
- `docker-compose up -d`
- `mvn clean install`
### Running from Maven
- `mvn spring-boot:run -f bootstrap/pom.xml`
### Running from Dockerfile
- `docker build --no-cache -t song-service:latest .`
- `docker run -d --env-file .env --name song-service -p 8082:8082 --network resource-network song-service`

## Running Tests

`mvn clean test` - To run the unit tests

## Cleaning Project and Resources
`mvn clean -U` - Clean project files generated and update dependencies

`docker-compose down --volumes` - Delete all services related to the project

`docker network rm resource-network` - Delete docker network
