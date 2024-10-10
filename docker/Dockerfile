FROM openjdk:17-alpine AS builder
WORKDIR /app
COPY portfolio-0.0.1-SNAPSHOT.jar portfolio.jar
ENTRYPOINT [ "java", "-jar", "portfolio.jar" ]