FROM openjdk:19-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/SpringAPI.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
