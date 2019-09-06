FROM openjdk:11-jre-slim
MAINTAINER Marco San Juan
COPY target/*.jar app.jar
EXPOSE 8761
CMD ["java","-jar","/app.jar"]

# BUILD
# docker build -t eureka-server .

# RUN
# docker run -d --rm --name eureka-server -p 8761:8761 eureka-server

# RUN ON NET
# docker run -d --rm --name eureka-server -p 8761:8761 --network scs_net eureka-server

