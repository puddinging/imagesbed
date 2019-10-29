FROM openjdk:8-jre
MAINTAINER jiefengfire@163.com

ENV APP_VERSION 0.0.1-SNAPSHOT

RUN mkdir /app

COPY imagesbed-$APP_VERSION.jar /app/app.jar
ENTRYPOINT ["java","-jar", "/app/app.jar"]

EXPOSE 8080