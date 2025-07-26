# 1) Build stage
FROM maven:3.8.7-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# 2) Runtime stage
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# Copiamos el fat-jar generado por Shade
COPY --from=build /app/target/healthtrack-app-1.0-SNAPSHOT-shaded.jar app.jar

EXPOSE 8080
# Ejecutamos el jar directamente
ENTRYPOINT ["java", "-jar", "app.jar"]
