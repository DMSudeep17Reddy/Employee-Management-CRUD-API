# Employee Management CRUD REST API
---

## Internship Tasks

This project was developed as part of my internship assignment.

### Task 1
Develop a CRUD REST API for Employee Management using Spring Boot.

### Task 2
Integrate the application with a MySQL database using Spring Data JPA and Flyway Database Migration. Create database schema through migration scripts and seed sample employee data.

---
---

### Requirements Completed

- Spring Web
- Spring Data JPA
- MySQL Database Integration
- Flyway Database Migration
- CRUD Operations (Create, Read, Update, Delete)
- DTO Implementation
- Jakarta Bean Validation
- Sample Data Seeding
- Proper HTTP Status Codes

---
  
---

# Project Overview

The Employee Management CRUD REST API is a backend application built using Spring Boot. It provides RESTful APIs to manage employee records stored in a MySQL database. The application follows a layered architecture using Controller, Service, Repository, DTO, and Entity classes.

---

---

# Database Migration

Flyway is used for database version control.

Migration Files:

- V1__Create_Employee_Table.sql
  - Creates the Employee table.

- V2__Insert_Sample_Data.sql
  - Inserts sample employee records into the database.

Flyway automatically executes pending migrations during application startup and maintains the migration history in the `flyway_schema_history` table.

---

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
- Flyway Database Versioning
- Automatic Database Migration
- Sample Data Initialization
  
---

# Project Structure

```
employee-management
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── net
│   │   │       └── javaguides
│   │   │           └── employeemanagement
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
│   │       ├── application.properties
│   │       │
│   │       └── db
│   │           └── migration
│   │               ├── V1__Create_Employee_Table.sql
│   │               └── V2__Insert_Sample_Data.sql
│   │
│   └── test
│       └── java
│
├── target
│
├── Employee-Management-CRUD-API.postman_collection.json
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
└── .gitignore

```

---

# Database Schema

Employee Table

| Column | Type |
|---------|------|
| id | BIGINT |
| first_name | VARCHAR(255) |
| last_name | VARCHAR(255) |
| email | VARCHAR(255) |

---

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

---

# Application Startup

When the application starts:

- Flyway validates migration scripts.
- Creates the database schema if it does not exist.
- Executes pending migrations.
- Seeds sample employee data.
- Starts the Spring Boot application.

---

# Testing

The API was successfully tested using Postman.

The following operations were verified:

- Create Employee
- Retrieve Employee(s)
- Update Employee
- Delete Employee

---

---

# Future Improvements

- Spring Security with JWT Authentication
- Pagination and Sorting
- Swagger/OpenAPI Documentation
- Docker Support
- Unit and Integration Testing
- Role-Based Authentication
- Audit Logging
- Database Relationships
- CI/CD Pipeline

---

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

- GitHub Repository

<img width="1600" height="900" alt="Screenshot 2026-07-16 115140" src="https://github.com/user-attachments/assets/7e145da5-bd22-43c9-b329-dc95ebeb463c" />

---

# Author

**D M Sudeep**

B.Tech - Computer Science and Engineering

Presidency University, Bengaluru

GitHub: https://github.com/DMSudeep17Reddy
