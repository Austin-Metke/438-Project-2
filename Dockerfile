# Use Java 17 JDK as base image
FROM openjdk:17-jdk

# Set working directory inside the container
WORKDIR /app

# Copy the built jar into the container and rename it to app.jar
# Make sure the jar name matches the one in build/libs
COPY build/libs/*.jar app.jar

# Expose the default port your Spring Boot app runs on
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
