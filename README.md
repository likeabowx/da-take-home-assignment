## DoctorAnywhere - Interns Take Home Assignment

This is a simple RESTful API built using Java and Spring Boot. The data are stored in a MySQL Database.

The API supports CRUD on Task objects with the following properties:
```
id: Long
title: String (required)
description: String
completed: Boolean
```

The following endpoints are supported:
1. `POST /tasks`: Create a new task with fields specified in request body
2. `GET /tasks`: Get a list of all tasks
3. `GET /tasks/{id}`: Get a single task by ID 
4. `PUT /tasks/{id}`: Update a task by ID with fields specified in request body
5. `DELETE /tasks/{id}`: Delete a task by ID (Admin only)


Sample requests can be found in this [Postman collection](https://api.postman.com/collections/20956562-1067eff2-b472-41f8-9340-82adefcfd9cc?access_key=PMAT-01H02Z0RN5X7W19HTD2WKHQACJ).

### Instructions to run
1. Ensure [Java](https://www.oracle.com/java/technologies/downloads/) and [Maven](https://maven.apache.org/download.cgi) are installed
2. Clone the repository
3. `cd` to the root folder of the repository and run `./mvnw spring-boot:run`
4. The API should be listening on `http://localhost:8080`
5. Using Postman, make a `POST` request to `http://localhost:8080/login` with the credentials below in Basic Auth to generate a JWT token (valid for 30 minutes)
6. Copy the JWT token from the response body into Bearer Token field (or replace the JWT variable if using the Postman collection provided)
7. Make requests to the API at `http://localhost:8080/api`

There are two different roles for this API:
```markdown
// User Role (not allowed to DELETE)
username: user
password: password

// Admin Role
username: admin
password: password
```

### Assumptions
The following assumptions are made regarding the implementation of this API:
- The `id` attribute is auto assigned upon creation, and cannot be edited.
- The `title` is required, `description` is optional, and `completed` default to false.
- For update, it is allowed to specify certain attributes only, keeping the old values of unspecified attributes.
- It is allowed to create different tasks with the same `title` and/or `description`.
