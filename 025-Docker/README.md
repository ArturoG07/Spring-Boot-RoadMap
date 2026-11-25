# 025 – Docker
REST API to manage products, customers and sales of a bazaar, run with Docker Compose together with its MySQL database.

## Stack
- Java 25
- Spring Boot 4.x
- Maven
- Spring Data JPA
- MySQL 8
- Docker / Docker Compose
- Postman

## Run with Docker
Only Docker is required (no Java, Maven or MySQL).

```bash
git clone https://github.com/ArturoG07/Spring-Boot-RoadMap.git
cd Spring-Boot-RoadMap/025-Docker/FinalProyect
docker compose up --build
```

The API will be available at `http://localhost:8080`.

To stop it:

```bash
docker compose down        # keeps the data
docker compose down -v     # also deletes the database
```
## Postman
Import `Spring-Boot-RoadMap/025-Docker/FinalProyect/bazaar.postman_collection.json` to test the endpoints.

## Author
**ArturoG07** · [Spring Boot RoadMap](https://github.com/ArturoG07/Spring-Boot-RoadMap)