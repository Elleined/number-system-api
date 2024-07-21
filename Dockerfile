FROM alpine/java:21-jdk
MAINTAINER Elleined

ENV PORT=8072

ADD ./target/*.jar number-system-api.jar
EXPOSE 8072
CMD ["java", "-jar", "number-system-api.jar"]
