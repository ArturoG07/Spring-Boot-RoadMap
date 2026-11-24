# 024 - Final Integrative Project

## Stack
- Java 25
- Spring Boot 4.x
- Maven
- Thymeleaf

## Author
**ArturoG07** · [Spring Boot RoadMap](https://github.com/ArturoG07/Spring-Boot-RoadMap)

## Objective

The objective of this final integrative project is to validate the practical and technical knowledge related to API development in the Java programming language using Spring Boot, for the course "API Development in Java with Spring Boot" at TodoCode Academy.

## Scenario

A bazaar (variety store) has greatly increased its sales. Given this, and since it has become almost impossible to record the sales and manage the stock of its products manually, it needs an application that allows it to carry out these tasks.

The owner of the bazaar states that all the operations of the application must be available to two different types of HTTP clients:

- A web application, whose frontend will be developed by a programmer friend (it is not part of our task as backend developers).
- A mobile application that will be implemented in the future.

Each of these apps represents the devices that she and her employees currently use. In short: one computer and several cell phones.

Given this particular situation, and since she needs to use the same backend for both options, she requests the development of an API.

## Modeling

Based on the survey carried out by a functional analyst, it was determined that the following classes will be necessary:

- Product
- Sale
- Customer

Each sale has a list of products and one and only one associated customer. In addition, each class must have the following attributes:

### Product

- `Long productCode`
- `String name`
- `String brand`
- `Double cost`
- `Double availableQuantity`

### Sale

- `Long saleCode`
- `LocalDate saleDate`
- `Double total`
- `List<Product> productList`
- `Customer customer`

### Customer

- `Long customerCode`
- `String firstName`
- `String lastName`
- `String nationalId`

## Requirements

Based on the survey carried out regarding the modeling, the bazaar owner specified the following requirements.

The API must follow RESTful conventions: URLs identify resources (nouns, in plural), and the action to perform is determined by the HTTP method.

### 1. Full CRUD for products

- **HTTP methods:** GET, POST, PUT, DELETE
- **Endpoints:**
  - Create: `POST localhost:8080/products`
  - Full list of products: `GET localhost:8080/products`
  - Get a specific product: `GET localhost:8080/products/{productCode}`
  - Edit: `PUT localhost:8080/products/{productCode}`
  - Delete: `DELETE localhost:8080/products/{productCode}`

### 2. Full CRUD for customers

- **HTTP methods:** GET, POST, PUT, DELETE
- **Endpoints:**
  - Create: `POST localhost:8080/customers`
  - Full list of customers: `GET localhost:8080/customers`
  - Get a specific customer: `GET localhost:8080/customers/{customerCode}`
  - Edit: `PUT localhost:8080/customers/{customerCode}`
  - Delete: `DELETE localhost:8080/customers/{customerCode}`

### 3. Full CRUD for sales

- **HTTP methods:** GET, POST, PUT, DELETE
- **Endpoints:**
  - Create: `POST localhost:8080/sales`
  - Full list of completed sales: `GET localhost:8080/sales`
  - Get a specific sale: `GET localhost:8080/sales/{saleCode}`
  - Edit: `PUT localhost:8080/sales/{saleCode}`
  - Delete: `DELETE localhost:8080/sales/{saleCode}`

> **Note:** For this requirement, it is not necessary to update a product's stock (deduct it) when a sale is made, nor to check whether it has enough quantity available to sell. However, implementing this functionality will be considered a "plus" or extra (for the bonus in item 8).

### 4. Get all products whose `availableQuantity` is less than 5

- **HTTP methods:** GET
- **Endpoint:** `GET localhost:8080/products/low-stock`

### 5. Get the list of products of a given sale

- **HTTP methods:** GET
- **Endpoint:** `GET localhost:8080/sales/{saleCode}/products`

### 6. Get the total amount and the total number of sales for a given day

- **HTTP methods:** GET
- **Endpoint:** `GET localhost:8080/sales/summary?date={saleDate}`
- **Example:** `GET localhost:8080/sales/summary?date=2026-11-23`

### 7. Get the `saleCode`, the total, the number of products, the customer's first name and last name for the sale with the highest amount of all

- **HTTP methods:** GET
- **Endpoint:** `GET localhost:8080/sales/highest`

> Keep the **DTO pattern** in mind for this scenario.

### 8. BONUS (OPTIONAL)

- Any proposed endpoint, improvement, added class, etc. that is proposed and implemented is considered a bonus.
- This section is optional and aims to let creativity run free when proposing what other needs/requirements might exist in this scenario.
- If you carry out this item, specify in a document the new requirement(s) proposed and their corresponding technical specifications (HTTP method, endpoint, etc.). Use this statement's requirements as a template example for the specification.