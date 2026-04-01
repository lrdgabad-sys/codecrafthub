# CodeCraftHub

A simple personalized learning platform built with **Java Spring Boot** that allows developers to track courses they want to learn.

CodeCraftHub stores course data in a **JSON file** instead of a database, making it beginner‑friendly and easy to understand.

---

# Project Overview

CodeCraftHub is a REST API that allows developers to:

* Add courses to learn
* Track learning progress
* Set target completion dates
* Update course status
* Delete completed or unwanted courses

This project focuses on learning:

* Spring Boot REST APIs
* CRUD operations
* JSON file storage
* Clean architecture
* Error handling

---

# Features

* REST API with CRUD operations
* JSON file persistence (No database required)
* Auto‑generated course IDs
* Status tracking
* Target completion dates
* Created timestamp
* Error handling
* Automatic `courses.json` creation

---

# Project Structure

```
src
 └── main
     ├── java
     │   └── com.codecrafthub
     │       ├── controller
     │       │    └── CourseController.java
     │       ├── service
     │       │    └── CourseService.java
     │       ├── model
     │       │    └── Course.java
     │       └── CodeCraftHubApplication.java
     │
     └── resources
         └── application.properties
```

---

# Installation Instructions

## Prerequisites

Make sure you have installed:

* Java 17 or Java 21
* Maven
* IntelliJ IDEA (recommended)

Check Java version:

```
java -version
```

Check Maven:

```
mvn -version
```

---

# Clone the Project

```
git clone https://github.com/your-username/codecrafthub.git
```

Navigate to project folder:

```
cd codecrafthub
```

---

# Run the Application

## Using Maven

```
mvn spring-boot:run
```

You should see:

```
Tomcat started on port 8080
Started CodeCraftHubApplication
```

Application will be available at:

```
http://localhost:8080
```

---

# API Endpoints

Base URL:

```
http://localhost:8080/api/courses
```

---

# Add Course

POST `/api/courses`

Request Body

```json
{
  "name": "Spring Boot",
  "description": "Learn Spring Boot",
  "targetDate": "2026-06-01",
  "status": "Not Started"
}
```

---

# Get All Courses

GET `/api/courses`

Example Response

```json
[
  {
    "id": 1,
    "name": "Spring Boot",
    "description": "Learn Spring Boot",
    "targetDate": "2026-06-01",
    "status": "Not Started",
    "createdAt": "2026-04-01T10:15:30"
  }
]
```

---

# Get Course By ID

GET `/api/courses/{id}`

Example

```
GET /api/courses/1
```

---

# Update Course

PUT `/api/courses/{id}`

Request Body

```json
{
  "name": "Spring Boot",
  "description": "Updated Description",
  "targetDate": "2026-07-01",
  "status": "In Progress"
}
```

---

# Delete Course

DELETE `/api/courses/{id}`

Example

```
DELETE /api/courses/1
```

---

# Sample curl Commands

## Add Course

```
curl -X POST http://localhost:8080/api/courses \
-H "Content-Type: application/json" \
-d '{
"name":"Java Fundamentals",
"description":"Learn Java",
"targetDate":"2026-12-01",
"status":"Not Started"
}'
```

---

# Get All Courses

```
curl http://localhost:8080/api/courses
```

---

# Get Course

```
curl http://localhost:8080/api/courses/1
```

---

# Update Course

```
curl -X PUT http://localhost:8080/api/courses/1 \
-H "Content-Type: application/json" \
-d '{
"name":"Java Fundamentals",
"description":"Updated",
"targetDate":"2026-12-01",
"status":"In Progress"
}'
```

---

# Delete Course

```
curl -X DELETE http://localhost:8080/api/courses/1
```

---

# Course Model

Each course contains:

| Field       | Description            |
| ----------- | ---------------------- |
| id          | Auto generated         |
| name        | Course name            |
| description | Course description     |
| targetDate  | Target completion date |
| status      | Learning status        |
| createdAt   | Creation timestamp     |

---

# Status Values

Allowed values:

* Not Started
* In Progress
* Completed

---

# courses.json Example

```
[
  {
    "id": 1,
    "name": "Spring Boot",
    "description": "Learn Spring Boot",
    "targetDate": "2026-06-01",
    "status": "Not Started",
    "createdAt": "2026-04-01T10:15:30"
  }
]
```

---

# Troubleshooting

## Whitelabel Error Page (404)

Possible causes:

* Controller not detected
* Wrong URL
* Package structure incorrect

Fix:

Ensure controller is inside:

```
com.codecrafthub.controller
```

---

# Port Already In Use

Error:

```
Port 8080 already in use
```

Fix:

Change port in `application.properties`

```
server.port=8081
```

---

# Maven Dependency Errors

Run:

```
mvn clean install
```

Reload Maven in IntelliJ.

---

# JSON File Not Created

Check project root directory for:

```
courses.json
```

The file is created automatically on first request.

---

# Future Improvements

* Add Swagger documentation
* Add authentication
* Add database support
* Add UI frontend
* Add course categories

---

# Author

CodeCraftHub

Spring Boot Learning Project

---

# License

This project is open source and available for learning purposes.
