# User Service (`user-service`)

Mock User Service for the Jenkins Microservices CI/CD Lab.

## Overview
Provides mock user management endpoints using Spring Boot 3 and Java 21, integrated with `common-library`.

## Endpoints
| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/users` | List all mock users |
| `GET` | `/api/users/{id}` | Get user by ID |
| `GET` | `/actuator/health` | Health check endpoint |

## Port
- Default Port: `8081`

## Run Locally
```bash
# Test & Package
mvn clean test
mvn clean package

# Run
java -jar target/user-service-1.0.0.jar
# or
mvn spring-boot:run
```

## Quick Verification
```bash
curl http://localhost:8081/api/users
curl http://localhost:8081/api/users/1
curl http://localhost:8081/actuator/health
```
