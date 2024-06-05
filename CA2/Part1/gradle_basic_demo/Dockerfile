# Use an official OpenJDK 21 image as the base image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the host into the container
COPY build/libs/basic_demo-0.1.0.jar /app/demo.jar

# Expose the port the chat server will run on
EXPOSE 59001

# Set the default command to run the chat server
CMD ["java", "-jar", "/app/demo.jar"]