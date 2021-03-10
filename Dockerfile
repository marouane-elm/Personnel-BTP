FROM openjdk:8
ADD target/personnel-btp-microservice.jar personnel-btp-microservice.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "personnel-btp-microservice.jar"]
