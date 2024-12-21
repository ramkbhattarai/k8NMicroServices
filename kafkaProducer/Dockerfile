FROM amazoncorretto:17

ENV SERVICE_NAME=kafkaProducer
# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot JAR file into the container
ADD ./target/${SERVICE_NAME}*.jar /app/${SERVICE_NAME}.jar

# Expose the default Spring Boot port
EXPOSE 8005

# Set the default command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/kafkaProducer.jar"]
