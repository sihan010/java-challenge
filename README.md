### How to use this spring-boot project

- Clone this repository
- CD into the project
- Install packages with `mvn package`
- Run `mvn spring-boot:run` for starting the application (or use your IDE)

Application (with the embedded H2 database) is ready to be used ! You can access the url below for testing it :

- Swagger UI : http://localhost:8080/swagger-ui.html
- H2 UI : http://localhost:8080/h2-console

> Don't forget to set the `JDBC URL` value as `jdbc:h2:mem:testdb` for H2 UI.

### What I did

- Improved Employee Controller, Service with Proper REST guideline (statuscode, header etc)
- Added validation
- Added JWT authentication with AuthController for login and Registration
- Added protection to Employee endpoints (GET endpoints are open)
- Added Caching for Employee Service (GET, PUT, DELETE)

### What I wish I could do

- Add Unit Test
- Make Swagger more robust

### How to smoke test

- Import `Java_Challange_AXA.postman_collection.json` to Postman
- Register -> Login (Get Token) -> Paste Token to Authorization Header to test other endpoints

#### My experience in Java

- I have limited experience in Java. I mostly worked with Java with android
- Now I switched to React native, so don't use java anymore, unless I have to write native modules (I try to choose Kotlin though)                               
- In my current company we use Kotlin and Vert.x to develop microservices
- I have quite good knowledge in Kotlin, but I'm somewhat beginner with Java and Spring Boot 
- Interested to learn and use reactive stack of spring boot with kotlin coroutines 
