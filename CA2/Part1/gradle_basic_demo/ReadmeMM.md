# Class Assignment 2 Part1

## Getting Started

The first step is to clone this repository (https://bitbucket.org/pssmatos/gradle_basic_demo/) to your local machine as it will serve as the basis for the task.
The rest of the assignment can be done by opening a bash terminal and running the following commands:

1. Copy the application gradle_basic_demo into a new CA2/Part1 folder:

   cp -r . ../CA2/Part1
   cd ../CA2/Part1

3. Initialize the Git repository:

   git init


3. Add all files to the staging area:

   git add *


4. Commit the added files:

   git commit -m "Added application for Part 1 of CA2 assignment"

5. Push the commit to the remote repository:

   git push

### Experimenting with the application
####  Run the server and opening the client

For part, goal is to experiment with the application:

1. First run the server.

   ./gradlew build

This command invokes the Gradle wrapper (gradlew), which is a script used to execute Gradle builds.

java -cp build/libs/basic_demo-0.1.0.jar basic_demo.ChatServerApp 59001

This command runs the Java Virtual Machine (java) with the classpath (-cp) set to include the JAR file (basic_demo-0.1.0.jar) located in the build/libs directory. It then executes the ChatServerApp class from the basic_demo package, passing 59001 as a command-line argument.

2. After the server is running, run the client. To do do this open two bash windows, and write ./gradlew runClient to open two chat windows. You now can see two chat windows and you can begin conversation with yourself.


### Implementing Changes
#### Part 1: Adding the runServer task

For this first section, goal is to add a new task in the build.gradle file to start the server. The steps to do so are:

1. Open the build.gradle file  and navigate to the end of the file and add the new task:

task runServer(type:JavaExec, dependsOn: classes){
group = "DevOps"
description = "Launches a chat server on port 59001 "

    classpath = sourceSets.main.runtimeClasspath

    mainClass = 'basic_demo.ChatServerApp'

    args '59001'
}

     - The task is of type JavaExec, which means it will execute a Java class. It depends on the classes task, which means it will only run after the classes task is completed. The group and description are used to describe the task. The classpath is set to the runtime classpath of the main source set. The mainClass is set to the ChatServerApp class, and the args are set to 59001, which is the port the server will listen to.


#### Part 2: Adding the test class and unit test

For this part of the assignment, a new test class will be created and a unit test will be added. The steps to do so are:

1. Create a new test folder and a new test class:
   mkdir -p src/test/java/basic_demo

2. Open a test class called "AppTest" in the test folder:


3. Setup the test class:
   package basic_demo;


import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
}
```
4. Add the unit test:
@Test public void testAppHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }

5. Add the dependencies in the build.gradle file:

dependencies {
    // Use Apache Log4J for logging
    implementation group: 'org.apache.logging.log4j', name: 'log4j-api', version: '2.11.2'
    implementation group: 'org.apache.logging.log4j', name: 'log4j-core', version: '2.11.2'
    testImplementation 'junit:junit:4.12'
}
6. Compile the project in the terminal:
./gradlew build

#### Part 3: Adding the Copy task
The goal is to create a new task that will create a backup of the sources of the application and copy it into a 'backup' folder in the application root. The steps to do so are:

1. Open the build.gradle file and add the new task:

task backup(type: Copy){
    from 'src'
    into 'backup'
}

2. Compile the project in the terminal:

 ./gradlew backup 


3. Add and commit the changes:
 git add backup/    

git commit -m "add backup"    

4. Push the changes to the remote repository:

git push


#### Part 3: Adding the Zip task
The goal is to create a new task that will create a .Zip to be used to make an archive (i.e., zip file) of the sources of the application. The steps to do so are:

1. Open the build.gradle file and add the new task:

task zipper(type:Zip){
    archiveFileName = "archive.zip"
    destinationDirectory = file("./")

    from "src"
}

2. Compile the project in the terminal:
 ./gradlew zipper      

3. Add and commit the changes(the -a command adds the files to the staging area):

git add *  

4. Push the changes to the remote repository:
git push

5. Add a tag to mark the end of the first part of this assignment:
git tag ca2-part1    
git push --tag

