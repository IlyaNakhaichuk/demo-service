#
# Build stage
#
FROM maven:3.6.0-jdk-8-slim AS build
COPY load-service /home/app/

RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim AS make
ENV TZ=Europe/Minsk
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
COPY --from=build /home/app/target/graph-0.0.1-SNAPSHOT.jar /usr/local/lib/load-service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/load-service.jar"]

