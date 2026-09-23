# API Endpoints Reference

## Base URL
`http://localhost:8080/api`

## Authentication

### POST /auth/login
Login and receive JWT token.

**Request:**
```json
{
  "username": "admin",
  "password": "password123"
}
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9...",
  "type": "Bearer",
  "username": "admin",
  "role": "ADMIN"
}
```

---

## Projects

### GET /projects?page=0&size=10
Get paginated list of all projects.

**Response:**
```json
{
  "data": [...],
  "page": 0,
  "size": 10,
  "count": 47
}
```

### GET /projects/{id}
Get single project by ID.

### POST /projects
Create new project.

**Request:**
```json
{
  "name": "Project Alpha",
  "description": "Enterprise migration project",
  "status": "ACTIVE",
  "clientName": "Acme Corp",
  "budget": 500000,
  "gmPercent": 34.5
}
```

### PUT /projects/{id}
Update existing project.

### DELETE /projects/{id}
Delete project by ID.

### GET /projects/search?keyword=alpha
Search projects by name or status.

---

## Error Responses

```json
{
  "error": "Project not found with id: 99"
}
```

## HTTP Status Codes

| Code | Meaning |
|---|---|
| 200 | Success |
| 201 | Created |
| 400 | Bad Request |
| 404 | Not Found |
| 500 | Server Error |
