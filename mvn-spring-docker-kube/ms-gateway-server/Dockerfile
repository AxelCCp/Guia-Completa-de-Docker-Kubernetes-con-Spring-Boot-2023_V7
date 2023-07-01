FROM openjdk:17-jdk-alpine as builder
WORKDIR /app/ms-gateway-server
COPY ./pom.xml /app
COPY ./ms-gateway-server/.mvn ./.mvn
COPY ./ms-gateway-server/mvnw .
COPY ./ms-gateway-server/pom.xml .
RUN ./mvnw clean package -Dmaven.test.skip  -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
COPY ./ms-gateway-server/src ./src
RUN ./mvnw clean package -DskipTests
FROM openjdk:17-jdk-alpine
WORKDIR /app
RUN mkdir ./logs
COPY --from=builder /app/ms-gateway-server/target/ms-gateway-server-0.0.1-SNAPSHOT.jar .
EXPOSE 8090
CMD ["java", "-jar", "ms-gateway-server-0.0.1-SNAPSHOT.jar"]