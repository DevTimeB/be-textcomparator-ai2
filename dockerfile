# Use a base image with OpenJDK 17
FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/be-textcomparator-ai2-0.0.1-SNAPSHOT.jar app.jar
# Run the application when the container starts
ENTRYPOINT ["java", "-jar", "/app.jar"]