#Start with a base image containing Java runtime
FROM openjdk:11-jdk-slim as build

#Information around who maintains the image
MAINTAINER test.com

# Add the application's jar to the container
COPY target/search-0.0.1-SNAPSHOT.jar search.jar

#execute the application
ENTRYPOINT ["java","-jar","/search.jar"]