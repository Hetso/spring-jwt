# SPRING JWT

## Description

This is a simple project for **Authentication** and **Authorization** with **Spring Boot**, **Spring Security** and **JWT (Json Web Token)**. 

This project use:

- Spring Boot
- Spring Security
- JWT
- Flyway
- MySQL/MariaDB
- Spring Data JPA
- Lombok
- Maven
- Open API and Swagger

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

- In project root, run `mvn spring-boot:run` in command line to run the application with maven

## 3 - API DOCUMENTATION

This docs use swagger-ui and open-api for generate documentation, can be access in `/swagger-ui.html` (visual) and `/api-docs` (json).

Can be changed and disabled/enabled in `application.yml` in `springdoc` properties.

## 4 - EXAMPLES

Open the API documentation for view endpoints and objects data.

This project has a ExampleController for examples endpoints.

Has 3 pre-created users with permissions in DB migrations (V2 and V6):

- Admin permission user:
    ```
    login: admin    
    password: admin
    ```

- Common permission user:
    ```
    login: user1
    password: user
    ```

- Manager permission user:
    ```
    login: user2
    password: user
    ```

### Execute examples

First get the token (JWT) in login and set request header: `Authorization` with the value `Bearer {token}` (replace `{token}`with your token obtained in login).

Has 4 endpoints to test authorization (view in API DOCUMENTATION):

- `/api/example/public`, can return ok without authentication, anyone can access this endpoint.
- `/api/example/authenticated`, can return ok only if is authenticated (has Authorization header with valid token), any permission can access this endpoint.
- `/api/example/manager`, can return ok only if is authenticated and user has `MANAGER` or `ADMIN` permission.
- `/api/example/admin`, can return ok only if is authenticated and user has `ADMIN` permission.