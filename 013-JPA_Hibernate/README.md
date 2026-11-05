# 013 JPA Hibernate

This project demonstrates the use of JPA and Hibernate in a Spring Boot application. It includes the necessary dependencies and configuration to start developing CRUD operations on a MySQL database.

## Stack
- Java 25
- Spring Boot 4.x
- Maven
- MySQL 8.x

## Author
**ArturoG07** · [Spring Boot RoadMap](https://github.com/ArturoG07/Spring-Boot-RoadMap)

## Steps

### 1. Spring Initializr dependencies
- **Lombok**: Reduces boilerplate code by generating getters, setters, constructors, etc.
- **Spring Boot DevTools**: Automatic restarts and LiveReload during development.
- **Spring Web**: Build web applications and REST APIs with Spring MVC (includes embedded Tomcat).
- **Spring Data JPA**: Persist data in SQL databases using JPA and Hibernate.
- **MySQL Driver**: Connects the application to a MySQL database.

### 2. Database creation
Run the following script in MySQL:

```sql
CREATE DATABASE IF NOT EXISTS jpa_test;
CREATE USER IF NOT EXISTS 'admin'@'localhost' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON jpa_test.* TO 'admin'@'localhost';
FLUSH PRIVILEGES;
```

### 3. Configuration of `application.properties`
> Note: the port is `3307` because of the local MySQL setup. The default MySQL port is `3306`.

```properties
spring.application.name=JPA_Hibernate
spring.datasource.url=jdbc:mysql://localhost:3307/jpa_test?sslMode=DISABLED&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=admin
spring.datasource.password=admin
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4. Checking the database connection
- Run the application and check the console for connection errors.
- If it starts correctly, Hibernate will create the tables automatically (`ddl-auto=update`). You can check them in phpMyAdmin.

### 5. Creating the entity class
- Create a class `Person` in the `model` package.
- Use `@Entity` to map it to a table, `@Id` for the primary key and `@GeneratedValue` to auto-generate the id.
- Use Lombok's `@Getter` and `@Setter` to avoid writing them by hand.

### 6. Creating the repository interface
- Create an interface `PersonRepository` in the `repository` package.
- Extend `JpaRepository<Person, Long>` (entity type and primary key type).

### 7. Creating the service class
- Create a class `PersonService` in the `service` package.
- It will contain the CRUD methods using `PersonRepository`.