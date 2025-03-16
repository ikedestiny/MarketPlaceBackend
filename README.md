<!-- ⚠️ This README has been generated from the file(s) "blueprint.md" ⚠️-->
[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#marketplace-backend---spring-boot-rest-api)

# ➤ Marketplace Backend - Spring Boot REST API

This is a Spring Boot-based REST API designed for a marketplace application. It provides endpoints for managing users, businesses, goods, and authentication. The API is secured using JWT (JSON Web Tokens) and role-based access control.


[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#table-of-contents)

## ➤ Table of Contents
- [Models](#models)
- [Endpoints](#endpoints)
    - [Authentication](#authentication)
    - [Admin](#admin)
    - [Business Owner](#business-owner)
    - [Client](#client)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
    - [Running the Application](#running-the-application)
- [Security](#security)
- [Contributing](#contributing)



[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#models)

## ➤ Models

### MPUser
Represents a user in the system.
- **id**: Unique identifier for the user (auto-generated).
- **username**: Unique username for the user (required).
- **email**: User's email address (must be valid).
- **password**: User's password (required).
- **role**: User's role (`ADMIN`, `CLIENT`, `BUSINESS_OWNER`, `SERVICE_PROVIDER`).
- **service**: Associated service (if the user is a service provider).
- **business**: Associated business (if the user is a business owner).

### Business
Represents a business in the marketplace.
- **id**: Unique identifier for the business (auto-generated).
- **name**: Name of the business (required, unique).
- **address**: Address of the business.
- **description**: Description of the business.
- **goods**: Set of goods associated with the business.
- **owner**: Owner of the business (linked to `MPUser`).

### Goods
Represents goods sold by a business.
- **id**: Unique identifier for the goods (auto-generated).
- **business**: The business that owns the goods (linked to `Business`).
- **quantity**: Quantity of goods available.
- **name**: Name of the goods (required).
- **unit_price**: Price per unit of the goods (required).

### UserRole
Enum representing user roles:
- `ADMIN`
- `CLIENT`
- `BUSINESS_OWNER`
- `SERVICE_PROVIDER`


[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#endpoints)

## ➤ Endpoints

### Authentication

#### Register a New User
- **Endpoint**: `/authenticate/register`
- **Method**: `POST`
- **Description**: Registers a new user.
- **Request Body**:
  ```json
  {
    "username": "user123",
    "email": "user@example.com",
    "password": "password123",
    "role": "CLIENT"
  } 
  ```
  ### MPUser
Represents a user in the system.
- **id**: Unique identifier for the user (auto-generated).
- **username**: Unique username for the user (required).
- **email**: User's email address (must be valid).
- **password**: User's password (required).
- **role**: User's role (`ADMIN`, `CLIENT`, `BUSINESS_OWNER`, `SERVICE_PROVIDER`).
- **service**: Associated service (if the user is a service provider).
- **business**: Associated business (if the user is a business owner).

---

### Login
Authenticates a user and returns a JWT token.
- **Endpoint**: `/authenticate/login`
- **Method**: `POST`

#### Request Body
```json
{
  "username": "user123",
  "password": "password123"
}
```

#### Response
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

---

### Get All Users (Admin Only)
Retrieves a list of all users.
- **Endpoint**: `/admin/all_users`
- **Method**: `GET`

#### Response
```json
[
  {
    "id": 1,
    "username": "user123",
    "email": "user@example.com",
    "role": "CLIENT"
  }
]
```

---

### Delete User by ID (Admin Only)
Deletes a user by their ID.
- **Endpoint**: `/admin/delete_user?user_id=1`
- **Method**: `DELETE`

#### Response
```json
"User deleted successfully"
```

---

### Start a New Business (Business Owner Only)
Creates a new business.
- **Endpoint**: `/business/start_new_business`
- **Method**: `POST`

#### Request Body
```json
{
  "name": "My Business",
  "id": 1
}
```

#### Response
```json
"Business successfully created"
```

---

### Increase Stock Quantity (Business Owner Only)
Increases the quantity of a specific goods item.
- **Endpoint**: `/business/increase_stock`
- **Method**: `POST`

#### Request Body
```json
{
  "stockId": 1,
  "quantity": 10
}
```

#### Response
```json
"Successfully increased qty of GoodsName by 10"
```

---

### Add New Goods Collection (Business Owner Only)
Adds a new collection of goods to a business.
- **Endpoint**: `/business/add_new_goods_collection`
- **Method**: `POST`

#### Request Body
```json
{
  "businessId": 1,
  "name": "New Goods",
  "unit_price": 100,
  "quantity": 50
}
```

#### Response
```json
"Goods successfully added"
```

---

### Buy Goods (Client Only)
Allows a client to purchase goods.
- **Endpoint**: `/client/buy_goods`
- **Method**: `POST`

#### Request Body
```json
{
  "goodsId": 1,
  "quantity": 5
}
```

#### Response
```json
"Goods purchased successfully"
```

---

### Add New Service (Service Provider Only)
Adds a new service provided by a service provider.
- **Endpoint**: `/service/add_service`
- **Method**: `POST`

#### Request Body
```json
{
  "name": "Cleaning Service",
  "description": "Professional cleaning services",
  "price": 50
}
```

#### Response
```json
{
  "id": 1,
  "name": "Cleaning Service",
  "description": "Professional cleaning services",
  "price": 50
}
```

---

### Get All Services
Retrieves a list of all services.
- **Endpoint**: `/service/all_services`
- **Method**: `GET`

#### Response
```json
[
  {
    "id": 1,
    "name": "Cleaning Service",
    "description": "Professional cleaning services",
    "price": 50
  }
]
```

---


[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#getting-started)

## ➤ Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.x
- MySQL or any other relational database

### Installation
**Clone the repository:**
```bash
git clone https://github.com/yourusername/marketplace-backend.git
```

**Navigate to the project directory:**
```bash
cd marketplace-backend
```

**Build the project using Maven:**
```bash
mvn clean install
```

---


[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#running-the-application)

## ➤ Running the Application
1. Update the `application.properties` file with your database credentials.
2. Run the Spring Boot application:
```bash
mvn spring-boot:run
```
3. The API will be available at `http://localhost:8080`.

---


[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#security)

## ➤ Security
The API uses JWT for authentication and role-based access control. The following roles are supported:
- **ADMIN**: Full access to all endpoints.
- **CLIENT**: Access to client-specific endpoints.
- **BUSINESS_OWNER**: Access to business-related endpoints.
- **SERVICE_PROVIDER**: Access to service-related endpoints.

---


[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#contributing)

## ➤ Contributing
Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch:
```bash
git checkout -b feature/YourFeatureName
```
3. Commit your changes:
```bash
git commit -m "Add some feature"
```
4. Push to the branch:
```bash
git push origin feature/YourFeatureName
```
5. Open a pull request.

---