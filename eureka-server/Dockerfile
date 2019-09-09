FROM openjdk:11-jre-slim
MAINTAINER Marco San Juan
#curl necessary to perform healthcheck on docker-compose
RUN apt-get update && apt-get install -y curl
COPY target/*.jar app.jar
EXPOSE 8761
CMD ["java","-jar","/app.jar"]

# BUILD
# docker build -t eureka-server .

# RUN
# docker run -d --rm --name eureka-server -p 8761:8761 eureka-server

# RUN ON NET
# docker run -d --rm --name eureka-server -p 8761:8761 --network scs_net eureka-server

