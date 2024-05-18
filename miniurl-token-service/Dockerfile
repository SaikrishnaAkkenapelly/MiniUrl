FROM amazoncorretto:21
WORKDIR /app
COPY target/MiniUrl-Token-Service-*.jar /app/MiniUrl-Token-Service.jar
EXPOSE 8080
CMD [ "java", "-jar","MiniUrl-Token-Service.jar" ]