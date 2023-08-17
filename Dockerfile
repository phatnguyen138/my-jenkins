FROM eclipse-temurin:17-jdk-alpine

ENV hello_name="Phat Nguyen"

ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]