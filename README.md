# Employee Management CRUD REST API

A backend REST API application developed using **Spring Boot** for managing employee records.  
The project demonstrates CRUD operations, database integration, migration management, validation, exception handling, logging, unit testing, and code coverage analysis.

---

# Internship Tasks

This project was developed as part of my internship assignment.

## Task 1
Develop a CRUD REST API for Employee Management using Spring Boot.

## Task 2
Integrate the application with MySQL using Spring Data JPA and Flyway Database Migration.  
Create the database schema using migration scripts and insert sample employee data.

## Task 3
Implement Unit Testing using JUnit 5 and Mockito, add application logging using SLF4J, and generate code coverage reports using JaCoCo.

---

# Requirements Completed

- Spring Boot REST API
- Spring Web
- Spring Data JPA
- MySQL Database
- Flyway Database Migration
- CRUD Operations
- DTO Implementation
- Bean Validation
- Exception Handling
- Proper HTTP Status Codes
- SLF4J Logging
- Unit Testing using JUnit 5
- Mockito Service Layer Testing
- Controller Layer Testing using MockMvc
- JaCoCo Code Coverage Report

---

# Project Overview

The **Employee Management CRUD REST API** is a backend application built using Spring Boot.

The application provides RESTful APIs to perform CRUD operations on employee records stored in a MySQL database.

The project follows a layered architecture:

- Controller Layer
- Service Layer
- Repository Layer
- Entity Layer
- DTO Layer
- Exception Handling Layer

This architecture improves maintainability, scalability, and separation of concerns.

---

# Technologies Used

| Technology | Version |
|------------|---------|
| Java | 21 |
| Spring Boot | 3.5.4 |
| Spring Web | - |
| Spring Data JPA | - |
| MySQL | - |
| Flyway | - |
| JUnit 5 | - |
| Mockito | - |
| JaCoCo | - |
| Maven | - |
| Git | - |
| GitHub | - |
| Postman | - |

---

# Features

- Employee CRUD REST APIs
- DTO-based architecture
- Bean Validation
- Global Exception Handling
- Repository Pattern
- Service Layer Implementation
- RESTful API Design
- MySQL Database Integration
- Flyway Database Migration
- Sample Data Initialization
- SLF4J Logging
- Unit Testing using JUnit 5
- Mockito-based Service Testing
- MockMvc Controller Testing
- JaCoCo Code Coverage Reports

---

# Project Structure

```
employee-management
│
├── src
│   │
│   ├── main
│   │   │
│   │   ├── java
│   │   │   └── net
│   │   │       └── javaguides
│   │   │           └── employeemanagement
│   │   │
│   │   │               ├── controller
│   │   │               │   └── EmployeeController.java
│   │   │               │
│   │   │               ├── dto
│   │   │               │   └── EmployeeDto.java
│   │   │               │
│   │   │               ├── entity
│   │   │               │   └── Employee.java
│   │   │               │
│   │   │               ├── exception
│   │   │               │   ├── ErrorDetails.java
│   │   │               │   ├── GlobalExceptionHandler.java
│   │   │               │   └── ResourceNotFoundException.java
│   │   │               │
│   │   │               ├── mapper
│   │   │               │   └── EmployeeMapper.java
│   │   │               │
│   │   │               ├── repository
│   │   │               │   └── EmployeeRepository.java
│   │   │               │
│   │   │               ├── service
│   │   │               │   ├── EmployeeService.java
│   │   │               │   └── impl
│   │   │               │       └── EmployeeServiceImpl.java
│   │   │               │
│   │   │               └── EmployeeManagementApplication.java
│   │   │
│   │   └── resources
│   │       │
│   │       ├── application.properties
│   │       │
│   │       └── db
│   │           └── migration
│   │               ├── V1__Create_Employee_Table.sql
│   │               └── V2__Insert_Sample_Data.sql
│   │
│   └── test
│       │
│       └── java
│           └── net
│               └── javaguides
│                   └── employeemanagement
│
│                       ├── controller
│                       │   └── EmployeeControllerTest.java
│                       │
│                       ├── service
│                       │   └── EmployeeServiceTest.java
│                       │
│                       └── EmployeeManagementApplicationTests.java
│
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .gitignore
├── README.md
└── Employee-Management-CRUD-API.postman_collection.json
```

---

# Database Migration

Flyway is used for database version control.

Migration files:

## V1__Create_Employee_Table.sql

Creates the Employee table.

## V2__Insert_Sample_Data.sql

Inserts sample employee records into the database.

During application startup:

- Flyway checks migration versions.
- Executes pending migrations.
- Creates database schema.
- Inserts initial employee data.
- Maintains migration history in `flyway_schema_history`.

---

# Database Schema

## Employee Table

| Column | Data Type |
|--------|-----------|
| id | BIGINT |
| first_name | VARCHAR(255) |
| last_name | VARCHAR(255) |
| email | VARCHAR(255) |

---

# API Endpoints

| HTTP Method | Endpoint | Description |
|-------------|----------|-------------|
| POST | `/api/employees` | Create Employee |
| GET | `/api/employees` | Get All Employees |
| GET | `/api/employees/{id}` | Get Employee By ID |
| PUT | `/api/employees/{id}` | Update Employee |
| DELETE | `/api/employees/{id}` | Delete Employee |

---

# Sample API Request

## Create Employee

### POST
```
/api/employees
```

Request Body:

```json
{
    "firstName": "Sudeep",
    "lastName": "Reddy",
    "email": "sudeep@gmail.com"
}
```

Response:

```json
{
    "id": 1,
    "firstName": "Sudeep",
    "lastName": "Reddy",
    "email": "sudeep@gmail.com"
}
```

---

# cURL Commands

## Create Employee

```bash
curl -X POST http://localhost:8080/api/employees \
-H "Content-Type: application/json" \
-d "{\"firstName\":\"Sudeep\",\"lastName\":\"Reddy\",\"email\":\"sudeep@gmail.com\"}"
```

---

## Get All Employees

```bash
curl -X GET http://localhost:8080/api/employees
```

---

## Get Employee By ID

```bash
curl -X GET http://localhost:8080/api/employees/1
```

---

## Update Employee

```bash
curl -X PUT http://localhost:8080/api/employees/1 \
-H "Content-Type: application/json" \
-d "{\"firstName\":\"D M\",\"lastName\":\"Sudeep Reddy\",\"email\":\"dmsudeepreddy17@gmail.com\"}"
```

---

## Delete Employee

```bash
curl -X DELETE http://localhost:8080/api/employees/2
```

---

# HTTP Status Codes

| Status Code | Description |
|-------------|-------------|
| 200 OK | Successful request |
| 201 Created | Employee created successfully |
| 400 Bad Request | Invalid request data |
| 404 Not Found | Employee does not exist |

---

# Logging Implementation

Logging is implemented using **SLF4J**.

The application logs:

- Employee creation
- Employee retrieval
- Employee update
- Employee deletion
- Warning messages when employee records are not found

Logging improves debugging and application monitoring.

---

# Testing

The project contains automated tests for Controller and Service layers.

## Service Layer Testing

Test cases include:

- Create Employee
- Get Employee By ID
- Get All Employees
- Update Employee
- Delete Employee
- Employee Not Found Exception


## Controller Layer Testing

Tested APIs:

- POST `/api/employees`
- GET `/api/employees`
- GET `/api/employees/{id}`
- PUT `/api/employees/{id}`
- DELETE `/api/employees/{id}`


## Testing Tools

- JUnit 5
- Mockito
- Spring Boot Test
- MockMvc

All test cases pass successfully.

---

# Code Coverage Report

JaCoCo is integrated to measure unit test coverage.

## Coverage Summary

| Package | Coverage |
|---------|----------|
| Controller | 100% |
| DTO | 100% |
| Exception | 100% |
| Entity | 91% |
| Service Implementation | 90% |
| Application | 37% |

## Overall Coverage

**91% Instruction Coverage**

Generate the report using:

```bash
mvn clean test
```

Report location:

```
target/site/jacoco/index.html
```

---

# Application Startup Flow

When the application starts:

1. Spring Boot initializes the application.
2. Flyway validates migration scripts.
3. Database tables are created.
4. Sample employee data is inserted.
5. JPA connects with MySQL database.
6. REST APIs become available.

---

# Future Improvements

- Spring Security with JWT Authentication
- Swagger/OpenAPI Documentation
- Docker Containerization
- Pagination and Sorting
- Integration Testing
- GitHub Actions CI/CD Pipeline
- Role-Based Authorization
- Docker Compose
- Kubernetes Deployment

---

# ScreenShots

-Eclipse Project Structure

<img width="381" height="760" alt="Screenshot 2026-07-16 111353" src="https://github.com/user-attachments/assets/0629f0e9-8462-4260-bfac-b2ae8fa85cd7" />

-Flyway Migration Files

<img width="1600" height="900" alt="Screenshot 2026-07-16 111715" src="https://github.com/user-attachments/assets/3c0c6f24-6b4b-4445-ae6c-7f2e332a4c5d" />
<img width="1600" height="900" alt="Screenshot 2026-07-16 111740" src="https://github.com/user-attachments/assets/b091d1d8-6d97-4156-ae73-12a8959f057d" />


- MySQL Database Tables

<img width="1600" height="900" alt="Screenshot 2026-07-16 114828" src="https://github.com/user-attachments/assets/9ac55972-c9bb-4354-9fa9-e130480c3c01" />
<img width="1600" height="900" alt="Screenshot 2026-07-16 114743" src="https://github.com/user-attachments/assets/fe8d61d3-a1fe-4b6e-89f7-da333b5244ec" />

- Postman CRUD Operations

<img width="1600" height="900" alt="Screenshot 2026-07-16 112249" src="https://github.com/user-attachments/assets/7091a971-8855-409d-9a59-b55521e053c6" />
<img width="1600" height="900" alt="Screenshot 2026-07-16 112218" src="https://github.com/user-attachments/assets/262b48ec-3f56-4e2c-b0eb-cd1c1ac52b83" />
<img width="1600" height="900" alt="Screenshot 2026-07-16 112149" src="https://github.com/user-attachments/assets/d63941bc-8450-4707-9b9a-64731c7d1d79" />
<img width="1600" height="900" alt="Screenshot 2026-07-16 111952" src="https://github.com/user-attachments/assets/caa26688-4126-4590-bdbc-eed15ba485fb" />
<img width="1600" height="900" alt="Screenshot 2026-07-16 111824" src="https://github.com/user-attachments/assets/3a833233-0b7b-420a-8e64-75a903c93ff5" />

-Task 3 snaps

<img width="1224" height="483" alt="Screenshot 2026-07-16 172057" src="https://github.com/user-attachments/assets/7ffd8b42-ca9e-4400-baa9-41ed1d32649f" />
<img width="1595" height="295" alt="Screenshot 2026-07-16 171857" src="https://github.com/user-attachments/assets/69d24172-0127-4f6b-a09c-b0a2174a9e31" />
<img width="1146" height="34" alt="Screenshot 2026-07-16 134943" src="https://github.com/user-attachments/assets/56f59721-df81-4961-820a-986ab211e57d" />
<img width="1173" height="334" alt="Screenshot 2026-07-16 134808" src="https://github.com/user-attachments/assets/e3ecf5ee-46d2-4893-b4e9-9b6c298b2144" />
<img width="1189" height="579" alt="Screenshot 2026-07-16 134530" src="https://github.com/user-attachments/assets/6b75e828-d648-490f-9a30-40f4a71e39cb" />


- GitHub Repository

<img width="1600" height="900" alt="Screenshot 2026-07-16 115140" src="https://github.com/user-attachments/assets/7e145da5-bd22-43c9-b329-dc95ebeb463c" />


---
---

# Author

**D M Sudeep**

B.Tech - Computer Science and Engineering  
Presidency University, Bengaluru

GitHub:  
https://github.com/DMSudeep17Reddy

---
