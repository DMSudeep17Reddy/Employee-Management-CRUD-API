# Employee Management CRUD REST API

## Internship Task

This project was developed as part of my internship assignment.

**Task:** Create a CRUD REST API for an Employee resource using Spring Boot.

### Requirements Completed

- Spring Web
- Spring Data JPA
- CRUD Operations (Create, Read, Update, Delete)
- DTO Implementation
- Basic Validation using Jakarta Validation
- Proper HTTP Status Codes

---

# Project Overview

The Employee Management CRUD REST API is a backend application built using Spring Boot. It provides RESTful APIs to manage employee records stored in a MySQL database. The application follows a layered architecture using Controller, Service, Repository, DTO, and Entity classes.

---

# Technologies Used

- Java 21
- Spring Boot 3.5.4
- Spring Web
- Spring Data JPA
- MySQL
- Flyway Database Migration
- Maven
- Postman
- Git & GitHub

---

# Features

- Create a new Employee
- Retrieve all Employees
- Retrieve Employee by ID
- Update Employee details
- Delete Employee
- Input Validation
- DTO-based architecture
- Exception Handling
- RESTful API design

---

# Project Structure

```
employee-management-crud-api
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── net/javaguides/employeemanagement
│   │   │       ├── controller
│   │   │       ├── dto
│   │   │       ├── entity
│   │   │       ├── exception
│   │   │       ├── repository
│   │   │       ├── service
│   │   │       └── EmployeeManagementApplication.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── db/migration
│   └── test
│
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

---

# API Endpoints

| HTTP Method | Endpoint | Description |
|-------------|----------|-------------|
| POST | `/api/employees` | Create a new Employee |
| GET | `/api/employees` | Retrieve all Employees |
| GET | `/api/employees/{id}` | Retrieve Employee by ID |
| PUT | `/api/employees/{id}` | Update Employee |
| DELETE | `/api/employees/{id}` | Delete Employee |

---

# Sample Request

### Create Employee

**POST** `/api/employees`

```json
{
  "firstName": "Sudeep",
  "lastName": "Reddy",
  "email": "sudeep@gmail.com"
}
```

---

# Sample Response

```json
{
  "id": 1,
  "firstName": "Sudeep",
  "lastName": "Reddy",
  "email": "sudeep@gmail.com"
}
```

---

# Sample cURL Commands

## Create Employee

```bash
curl -X POST http://localhost:8080/api/employees \
-H "Content-Type: application/json" \
-d "{\"firstName\":\"Sudeep\",\"lastName\":\"Reddy\",\"email\":\"sudeep@gmail.com\"}"
```

## Get All Employees

```bash
curl -X GET http://localhost:8080/api/employees
```

## Get Employee by ID

```bash
curl -X GET http://localhost:8080/api/employees/1
```

## Update Employee

```bash
curl -X PUT http://localhost:8080/api/employees/1 \
-H "Content-Type: application/json" \
-d "{\"firstName\":\"D M\",\"lastName\":\"Sudeep Reddy\",\"email\":\"dmsudeepreddy17@gmail.com\"}"
```

## Delete Employee

```bash
curl -X DELETE http://localhost:8080/api/employees/2
```

---

# HTTP Status Codes

| Status Code | Description |
|-------------|-------------|
| 200 OK | Request successful |
| 201 Created | Employee created successfully |
| 400 Bad Request | Invalid request data |
| 404 Not Found | Employee not found |

---

# Testing

The API was successfully tested using Postman.

The following operations were verified:

- Create Employee
- Retrieve Employee(s)
- Update Employee
- Delete Employee

---

# Future Improvements

- Spring Security with JWT Authentication
- Pagination and Sorting
- Swagger/OpenAPI Documentation
- Docker Support
- Unit and Integration Testing

---

# Author

**D M Sudeep**

B.Tech - Computer Science and Engineering

Presidency University, Bengaluru

GitHub: https://github.com/DMSudeep17Reddy
