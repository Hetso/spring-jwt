# SPRING JWT

## Description

This is a simple project for **Authentication** and **Authorization** with **Spring Boot**, **Spring security** and **JWT (Json Web Token)**. 

This project use:

- Spring Boot
- Spring Security
- JWT
- Flyway
- MySQL/MariaDB
- Spring Data JPA
- Lombok
- Maven

## 1 - Install

Install Maven and Java.

Copy the file `application-example.yml` and paste to a new file with the name `application.yml`

In `application.yml` change:

##### For database config, locate in file: 
  
```
# VARIABLES
database:
    url: jdbc:mysql://localhost:3306/spring_jwt?createDatabaseIfNotExist=true
    user: user
    password: password
```

- In url change to your mysql/mariadb url, the default database name example is `spring_jwt` (this url is the default)
- Change user value to your mysql/mariadb user
- Change password value to your mysql/mariadb password

This database variables will be apply in `spring.datasource` and `spring.flyway` properties.

##### For JWT config, locate in file: 

```
security:
# JWT
    jwt:
    token:
        secret: secret
        expiration: 3600000
```

- Change the secret value (this is used for generate your JWT and validate, choose a hard value)
- Change the expiration value of the token in millisecond


## 2 - RUN

- In project root, run `mvn clean install` in command line to install dependencies and generate JAR file

- In project root, run `mvn spring-boot:run` in command line to run the application with maven;
