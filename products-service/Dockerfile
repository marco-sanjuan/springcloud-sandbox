FROM openjdk:11-jre-slim
MAINTAINER Marco San Juan
COPY target/*.jar app.jar
ENV ENV_EUREKA_URL="http://eureka-server:8761/eureka"
CMD ["java","-jar","/app.jar"]

# BUILD
# docker build -t products-service .

# RUN
# docker run -d --rm -P products-service
# --network="host" to allow container to connect to host ports as "localhost"

# RUN ON NET
# docker run -d --rm -P --network scs_net products-service