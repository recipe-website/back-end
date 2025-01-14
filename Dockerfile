FROM maven:3.9-eclipse-temurin-22-alpine AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:resolve-plugins

COPY src/main src/main

RUN mvn package -DskipTests

FROM eclipse-temurin:22-jre-alpine

WORKDIR /app

COPY --from=build /app/target/recipewebsite-0.0.1-SNAPSHOT.jar .

RUN apk add curl

EXPOSE 8080

CMD ["java", "-jar", "recipewebsite-0.0.1-SNAPSHOT.jar"]