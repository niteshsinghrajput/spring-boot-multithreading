# spring-boot-multithreading
An example to demonstrate API development by using Spring Boot, JPA, H2 in memory db with multithreading

## Prerequisites

Before running this project, make sure you have the following prerequisites:

- Java 11 or higher installed

## Setup

1. Clone the repository:

   ```bash
   git clone git@github.com:niteshsinghrajput/spring-boot-multithreading.git

2. Navigate to the project directory:

    ```bash
    cd spring-boot-multithreading

3. Build the project

    ```bash
    ./gradlew clean build

4. Run the application

   ```bash
    java -jar .\build\libs\spring-boot-multithreading-0.0.1-SNAPSHOT.jar

## Usage
Once the application is running, you can access the API endpoints using a tool like Postman or cURL.

#### The API supports the following endpoints:

* GET `/users`: Get all users
    * Sample URL: `http://localhost:8080/users`
* POST `/users`: Create a new employee
    * Sample URL: `http://localhost:8080/users`
    * It will take a csv file with name, email, gender columns

## Configuration
The application configuration can be found in the application.properties file. You can modify the H2 DB connection details, such as the host, port, and database name, in this file.
   
