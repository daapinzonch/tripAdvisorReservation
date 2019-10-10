FROM openjdk:8-jdk-alpine

ARG JAR=reservation-0.0.1-SNAPSHOT.jar
COPY target/$JAR /app.jar
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-jar","/app.jar"]
