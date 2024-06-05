# Use an image with JDK and Git pre-installed
FROM gradle:jdk17

# Set the working directory in the container
WORKDIR /app

# Install Git
RUN apt-get update && apt-get install -y git

# Clone the public repository
RUN git clone https://github.com/Departamento-de-Engenharia-Informatica/devops-23-24-JPE-PSM-1231848.git .

WORKDIR /app/CA2/Part1/gradle_basic_demo

RUN chmod +x gradlew

# Run Gradle build using the wrapper
RUN ./gradlew build

EXPOSE 59001

CMD ["./gradlew", "runServer"]