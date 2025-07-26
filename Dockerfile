# 1) Build stage: compilar y empaquetar con Maven
FROM maven:3.8.7-eclipse-temurin-17 AS build

WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# 2) Runtime stage: ejecutar el JAR empaquetado
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app
COPY --from=build /app/target/healthtrack-app-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]