FROM openjdk:17-alpine

RUN mkdir /app
VOLUME /app

ADD build/libs/*.jar /app/ecom-backend-api.jar

CMD java -jar /app/ecom-backend-api.jar --spring.profiles.active=${PROFILE}

