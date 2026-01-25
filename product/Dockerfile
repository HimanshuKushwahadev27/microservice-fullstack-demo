# Use official OpenJDK distribution
FROM eclipse-temurin:21-jdk

# Set working directory inside container
WORKDIR /app

# Copy the built Spring Boot jar into container
COPY target/*.jar app.jar

# Expose the internal application port
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java","-jar","app.jar"]