# Spring Boot with JWT Authentication project

This project demonstrates how to implement a JWT Authentication functionality in a Spring Boot Application

## Overview

This project showcases the implementation of a JWT Authentication feature in a Spring Boot Application about of a login.

Technologies used:
- Spring Boot 3
- Spring Security 6
- Jason Web Token
- BCrypt
- MySQL Workbench 8
- Git
- Maven
- Postman

## Features
- User registration and login with JWT authentication
- Password encryption using BCrypt
- Role-based authorization with Spring Security
- Customized access denied handling
- Logout mechanism
- Refresh token

## Getting Started
To get started with this project, you will need to have the following installed on your local machine:

* JDK 17+
* Maven 3+


To build and run the project, follow these steps:

* Clone the repository: `git clone https://github.com/posandoval/login-spring-boot-jwt-security.git`
* Navigate to the project directory: cd spring-boot-security-jwt
* Add database "demologin" to MySQL Workbench8
* Build the project: mvn clean install
* Run the project: mvn spring-boot:run

-> The application will be available at http://localhost:8080