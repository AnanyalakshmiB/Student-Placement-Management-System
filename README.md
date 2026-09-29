# Student Placement Management System

A Java-based console application developed to manage student placement activities such as student registration, company management, job management, job applications, eligibility checking, and placement reports.

##  Project Overview

The Student Placement Management System helps manage the complete placement process in a simple and organized way.

The application allows users to:

- Register students
- View all students
- Search students
- Update student details
- Delete students
- Add companies
- View companies
- Add job opportunities
- View available jobs
- Apply for jobs
- Check student eligibility based on CGPA
- Prevent duplicate applications
- Update application status
- View student applications
- Search jobs by title
- Search jobs by location
- View eligible jobs
- View placement dashboard

##  Technologies Used

- Java
- JDBC
- MySQL
- SQL
- Eclipse IDE
- Git
- GitHub

##  Project Architecture

The project follows a layered architecture:

```text
StudentPlacementManagementSystem
│
├── src
│   └── com.placement
│       │
│       ├── Main.java
│       │
│       ├── dao
│       │   ├── StudentDAO.java
│       │   ├── CompanyDAO.java
│       │   ├── JobDAO.java
│       │   ├── ApplicationDAO.java
│       │   └── ReportDAO.java
│       │
│       ├── model
│       │   ├── Student.java
│       │   ├── Company.java
│       │   ├── Job.java
│       │   └── Application.java
│       │
│       ├── service
│       │   ├── StudentService.java
│       │   ├── CompanyService.java
│       │   ├── JobService.java
│       │   └── ApplicationService.java
│       │
│       └── util
│           ├── DBConnection.java
│           └── ValidationUtil.java

⭐ This project was developed as a learning and portfolio project to practice Java, JDBC, SQL, MySQL, and software development concepts.
