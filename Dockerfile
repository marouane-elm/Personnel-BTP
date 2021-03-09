FROM openjdk
ADD target/btp-personnal.jar btp-personnal.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "btp-personnal.jar"]
