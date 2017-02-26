# spanningassignment

This Rest Based Services built using Spring Boot Application. I followed Spring MVC Pattern.

The main functionality that where built in these applications are:
1) Validate User
2) Check Balance based on User Validation.
3) Deposit
4) Withdraw

Tech stack Used:
1) Java8, Spring Boot, Spring JPA, H2 Database,JUnit, Mockito,RESTful Services.

This Application has been configured with H2 Database with is in memory Database primarly used for Development Purposes.Everytime the User runs this application a new Database transactions are created. This application is configured in such a way upon start of the application Tables and values are created and inserted. Please see those Files in Resources folder in Src/main.

Endpoints Examples:

method: Post
http://localhost:8080/atm-poc/userName/{usersindb}/withdraw
input: 
Userindb: user1
pin: 1234
amount: can be any

method: Post
http://localhost:8080/atm-poc/userName/{usersindb}/deposit

input: 
Userindb: user1
pin: 1234
amount: can be any



method: Post
http://localhost:8080/atm-poc/userName/{userindb}/balance

input: 
Userindb: user1
pin: 1234




