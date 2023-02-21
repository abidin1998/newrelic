# README

## Introduction
This program calculates the top 100 most repeated three-word sequences in a text. The text can be read from either one or multiple files or from standard input.

## Requirements
- Java 11 or higher

## How to run the program
You can run the program in two ways:
1. By providing file names as arguments:
   ``` 
   java CalculateMostRepeatedWords file1.txt file2.txt
   ```
2. By providing the text through standard input:
   ``` 
   java CalculateMostRepeatedWords
   ```
then you can provide the text you want to analyze, to end the program and provide the input 
you need to press "Ctrl+D" in Unix systems and "Ctrl+Z" in Windows

## How to build the docker image and run the app
Build docker image: 
``` 
docker build -t myimage .
``` 
Run the app:
``` 
docker run --rm -v $PWD:/app -w /app myimage java src/main/java/application/CalculateMostRepeatedWords.java src/main/resources/files/moby-dick.txt
``` 
## What would you do next, given more time
Given more time, the following improvements can be made:
1. The program can be built as a service in some backend framework like spring boot.
2. The program can be extended to calculate the most repeated n-word sequences, where n is a value provided by the user.
3. The program can be made more user-friendly by adding a graphical user interface.

## How to run the tests
First of all you need to have installed maven in your system, 
The tests can be executed with the next command
``` 
mvn test
``` 
## What are the steps needed to have this program (or any application) ready for production?
1. Build the application with some web framework like spring boot or struts to make it easier to maintain and deploy as a service 
2. Build the unit and integration tests to make sure everything is well tested and avoid break previews functions when we have to perform some changes or add new features to the codebase
3. Build a pipeline to run the tests and deploy the application automatically from the git repository to the cloud and make easier the continues deployment and adding new features
4. Make sure to implement a well tested security system to protect the application with authentication and authorization features.

## What would be the advantages or disadvantages of having a program like this running in a distributed system with a container-orchestration platform?
Advantages:
1. Scalability: A distributed system can handle a large number of users and data more efficiently than a single machine. This makes it easier to scale the application as the user base grows.

2. Fault tolerance: A distributed system can tolerate failures more effectively by distributing data and processing across multiple machines. If one machine fails, the others can continue to function without interruption.

3. High availability: A distributed system can ensure that the application is available to users at all times by replicating data and processing across multiple machines.

4. Geographic distribution: A distributed system can allow users to access the application from anywhere in the world, reducing latency and improving performance.

Disadvantages
1. Complexity: Developing and maintaining a distributed system can be complex, requiring expertise in areas such as networking, security, and fault tolerance.

2. Excessive communication : Communication between machines in a distributed system can introduce latency and additional requests, which can impact performance.

3. Synchronization issues: Coordinating the processing and data across multiple machines can be challenging, leading to synchronization issues.

## How would you scale this if you needed to support millions of requests simultaneously? (Imagine the program is complex enough to require it)
I would run the application in a distributed system with autoscaling microservices that would scale adding more machines to handle the demand through a load balancer.
Also i will add a caching layer to store the frequent responses and save some resources consumption.
The code can also be optimized to save some memory consumption.