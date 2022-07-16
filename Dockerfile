FROM adoptopenjdk/openjdk11:ubi
COPY target/shahraz-1.0.jar shahraz.jar
ENTRYPOINT ["java", "-jar", "shahraz.jar"]