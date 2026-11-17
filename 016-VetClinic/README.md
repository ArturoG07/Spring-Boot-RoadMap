# 016 – Veterinary Clinic

## Stack
- Java 25
- Spring Boot 4.x
- Maven
- MySQL 8.x
- JPA + Hibernate
- Postman (for testing the endpoints)

## Author
**ArturoG07** · [Spring Boot RoadMap](https://github.com/ArturoG07/Spring-Boot-RoadMap)

A veterinary clinic has a system with two classes: Pet and Owner. Each pet can have only one owner associated with it as the responsible party.

A functional analyst gathered the client's needs and the characteristics of the system currently in use, and determined that the classes should have the following structure:

- **Pet**, with the attributes:
    - id
    - name
    - species
    - breed
    - color
- **Owner**, with the attributes:
    - id
    - name
    - email
    - cell phone

Since the clinic will soon want to have a web application and a mobile application that can query the same backend, an API is required that is capable of:

1. **Performing CRUD operations for pets**
2. **Performing CRUD operations for owners**
3. **Getting a list of the following combined data for a pet and its owner:**
    - pet_name
    - species
    - breed
    - owner_name
## How to run
1. Create a MySQL database: `CREATE DATABASE vet_clinic;`
2. Configure `src/main/resources/application.properties` with your DB URL, user and password
3. Run `./mvnw spring-boot:run`
4. The API is available at `http://localhost:8080`
## Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | /owners | Create an owner |
| GET | /owners | List all owners |
| GET | /owners/{id} | Get an owner |
| PUT | /owners/{id} | Update an owner |
| DELETE | /owners/{id} | Delete an owner |
| POST | /pets | Create a pet (needs `ownerId`) |
| GET | /pets | List all pets |
| GET | /pets/{id} | Get a pet |
| PUT | /pets/{id} | Update a pet |
| DELETE | /pets/{id} | Delete a pet |
| GET | /pets/with-owner | Pet + owner combined list |