FROM openjdk:11-jre-slim
MAINTAINER Marco San Juan
COPY target/*.jar app.jar
EXPOSE 8080
CMD ["java","-jar","/app.jar"]

# BUILD
# docker build -t zuul-server .

# RUN
# docker run -d --rm --name zuul-server -p 8888:8888 zuul-server

# RUN ON NET
# docker run -d --rm --name zuul-server -p 8888:8888 --network scs_net zuul-server
