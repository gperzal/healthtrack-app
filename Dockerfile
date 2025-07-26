FROM maven:3.8.7-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
# Aquí copiamos el JAR “shaded” que genera el Shade Plugin:
COPY --from=build /app/target/healthtrack-app-1.0-SNAPSHOT-shaded.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
