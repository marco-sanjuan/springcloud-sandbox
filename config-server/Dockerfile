FROM openjdk:11-jre-slim
MAINTAINER Marco San Juan
#curl necessary to perform healthcheck on docker-compose
RUN apt-get update && apt-get install -y curl
COPY target/*.jar app.jar
EXPOSE 8888
CMD ["java","-jar","/app.jar"]

# BUILD
# docker build -t config-server .

# RUN
# docker run -d --rm --name config-server -p 8888:8888 config-server

# RUN ON NET
# docker run -d --rm --name config-server -p 8888:8888 --network scs_net config-server
