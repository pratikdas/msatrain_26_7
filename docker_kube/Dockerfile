FROM openjdk:8-jdk-alpine
MAINTAINER pratikd2000@gmail.com
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]