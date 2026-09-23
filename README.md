# Spring Boot REST API 🚀

Enterprise-grade REST API built with **Java Spring Boot** and **MySQL** —
featuring JWT authentication, role-based access control, and full CRUD operations.

Built from real experience developing backend microservices at 
Prolifics Corporation for PPM, PEP, and VisaFlow applications.

## Features

- ✅ JWT-based authentication
- ✅ Role-based access control (RBAC) — ADMIN / MANAGER / USER
- ✅ Full CRUD REST endpoints
- ✅ MySQL database with JdbcTemplate
- ✅ Input validation and error handling
- ✅ Swagger API documentation
- ✅ CORS configuration
- ✅ Environment-based configuration

## API Endpoints

### Authentication
```
POST   /api/auth/login        — Login, returns JWT token
POST   /api/auth/register     — Register new user
```

### Projects
```
GET    /api/projects          — Get all projects (paginated)
GET    /api/projects/{id}     — Get project by ID
POST   /api/projects          — Create new project
PUT    /api/projects/{id}     — Update project
DELETE /api/projects/{id}     — Delete project
GET    /api/projects/search   — Search by name or status
```

## Tech Stack

| Layer | Technology |
|---|---|
| Framework | Java Spring Boot 3.x |
| Database | MySQL 8.0 |
| Auth | JWT (JSON Web Tokens) |
| ORM | JdbcTemplate |
| Docs | Swagger / OpenAPI |
| Build | Maven |

## Setup

```bash
git clone https://github.com/karuturiruchitha/spring-boot-rest-api
cd spring-boot-rest-api

# Configure database in application.properties
# Update DB credentials

mvn spring-boot:run
```

## Configuration

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/api_db
spring.datasource.username=root
spring.datasource.password=your_password
jwt.secret=your_jwt_secret_key
jwt.expiration=86400000
server.port=8080
```

## Sample Request

```bash
# Login
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"admin","password":"password123"}'

# Response
{
  "token": "eyJhbGciOiJIUzI1NiJ9...",
  "type": "Bearer",
  "username": "admin",
  "role": "ADMIN"
}

# Get all projects (with token)
curl -X GET http://localhost:8080/api/projects \
  -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9..."
```

## Author

**Ruchitha Karuturi** — Full Stack Developer  
[LinkedIn](https://linkedin.com/in/ruchitha-karuturi-51a49b24a) |
[GitHub](https://github.com/karuturiruchitha)
