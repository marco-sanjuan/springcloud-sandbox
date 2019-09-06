FROM openjdk:11-jre-slim
MAINTAINER Marco San Juan
COPY target/*.jar app.jar
ENV ENV_EUREKA_URL="http://eureka-server:8761/eureka" \
    ENV_CONFIG_URL="http://config-server:8888"
EXPOSE 8005
CMD ["java","-jar","/app.jar"]

# BUILD
# docker build -t stock-service .

# RUN
# docker run -d --rm -P stock-service
# --network="host" to allow container to connect to host ports as "localhost"

# RUN ON NET
# docker run -d --rm -P --network scs_net stock-service