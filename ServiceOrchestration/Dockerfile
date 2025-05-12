# Build Stage
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests


# Run Stage
# Using a multi-arch image for compatibility with Apple M1
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy compiled jar
COPY target/TransactionServiceApp-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]