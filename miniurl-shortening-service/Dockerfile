FROM amazoncorretto:21
WORKDIR /app
COPY target/MiniUrl-Shortening-Service-*.jar /app/MiniUrl-Shortening-Service.jar
EXPOSE 8080
CMD [ "java", "-jar","MiniUrl-Shortening-Service.jar" ]