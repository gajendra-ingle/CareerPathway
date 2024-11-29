# CareerPathway

## About the Project
**CareerPathway** is a Spring Boot REST API designed to streamline the management of career development activities such as job postings, student registrations, applications, and interview scheduling. It empowers institutions to publish job opportunities and facilitates a seamless application process for students. The system enhances communication between students and employers, ensuring an efficient hiring process while maintaining an organized database.

## Objective
- **Automate** the career pathway process via a REST API to enable seamless integration with other institutional systems.
- **Ensure data accuracy** through job posting validation and student application management.
- **Enhance communication** between students and employers, optimizing the hiring workflow.
- **Improve error handling** using global exception handling and custom validation rules across all entities.

## Workflow
1. **Student Registration**  
   Students can register via the `Student` entity, gaining access to the system.
2. **Viewing Job Postings**  
   After logging in, students can browse available job postings.
3. **Applying for a Job**  
   Students submit job applications, which are initially marked as `APPLIED`.
4. **Approval of Job Application**  
   Admins or employers review applications and update the status to `APPROVED` if accepted.
5. **Scheduling Interviews**  
   Approved students can schedule interviews using the `Interview` entity linked to their application.

## Scope
This project focuses on developing a REST API to manage:
- Users
- Students
- Job Postings
- Job Applications
- Interviews

## Project Architecture
The project follows a **layered architecture pattern** with the following components:

### 1. Controller Layer
- Handles HTTP requests and responses.
- Validates request parameters and payloads to ensure data consistency.
- Uses custom validation annotations and error handling via a global exception handler.

### 2. Service Layer
- Contains business logic.
- Coordinates interactions between controllers and DAOs.
- Manages transactions and ensures data integrity.

### 3. DAO Layer
- Performs CRUD operations to interact with the database.
- Abstracts database management details for clear separation between logic and data.

### 4. Global Exception Handler
- Centralized exception handling that returns user-friendly error messages in a consistent format across the system.

### 5. Validation
- Custom validation for fields to maintain data integrity.
- Utilizes annotations like `@NotNull`, `@Size`, and `@Email` for input validation.


## Technology Stack
- **Backend Framework**: Spring Boot 2.7.17
- **Database**: MySQL
- **Database Framework**: Hibernate 5
- **Java**: JDK 17
- **Build Tool**: Maven
- **Development Environment**: Eclipse
- **API Testing Tool**: Postman


## Modules and API Endpoints

### 1. User Module
Manages user authentication and operations.

| Method | Endpoint                  | Description                  |
|--------|---------------------------|------------------------------|
| POST   | `/auth/login`              | Authenticates a user.        |
| POST   | `/user/create-user`         | Creates a new user.          |
| DELETE | `/user/delete-user/{username}` | Deletes a user by username.  |
| GET    | `/user/all-users`           | Retrieves all users.         |
| GET    | `/user/get-user/{username}` | Fetches a user by username.  |
| PUT    | `/user/update-user`         | Updates user details.        |



### 2. Student Module
Handles student registration and management.

| Method | Endpoint                  | Description                  |
|--------|---------------------------|------------------------------|
| POST   | `/students/register`       | Registers a new student.     |
| GET    | `/students/all-students`    | Retrieves all students.      |
| DELETE | `/students/delete-student/{id}` | Deletes a student by ID.    |
| PUT    | `/students/update-student`  | Updates student details.     |



### 3. Job Posting Module
Manages job postings.

| Method | Endpoint                   | Description                  |
|--------|----------------------------|------------------------------|
| POST   | `/job-postings/create-job`   | Creates a new job posting.   |
| GET    | `/job-postings/all-jobs`     | Retrieves all job postings.  |
| DELETE | `/job-postings/delete-job/{id}` | Deletes a job by ID.       |
| PUT    | `/job-postings/update-job`   | Updates job posting details. |


### 4. Job Application Module
Allows students to apply for jobs.

| Method | Endpoint                          | Description                            |
|--------|-----------------------------------|----------------------------------------|
| POST   | `/jobApplication/apply`           | Submits a job application.             |
| PUT    | `/jobApplication/update-status/{id}/{status}` | Updates the job application status. |



### 5. Interview Module
Manages interview scheduling and tracking.

| Method | Endpoint                          | Description                              |
|--------|-----------------------------------|------------------------------------------|
| POST   | `/interview/schedule`             | Schedules a new interview.               |
| GET    | `/interview/{id}`                 | Retrieves interview details by ID.       |
| PUT    | `/interview/update-status/{id}/{status}` | Updates the interview status.       |


