FROM openjdk:17.0.1-jdk-slim-buster

WORKDIR /app
COPY bootstrap/target/bootstrap-1.0.0.jar song-service.jar
EXPOSE 8082

CMD ["java", "-jar", "-Dspring.profiles.active=prod", "song-service.jar"]
