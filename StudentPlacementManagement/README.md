# Student Placement Management System

## Project Description

The Student Placement Management System is a Java-based console application developed to manage student placement activities.

The system allows students, companies, jobs, and job applications to be managed using Java and MySQL.

## Technologies Used

* Java
* MySQL
* JDBC
* Eclipse IDE
* SQL

## Main Features

1. Register Student
2. View All Students
3. Search Student
4. Update Student
5. Delete Student
6. Add Company
7. View All Companies
8. Add Job
9. View All Jobs
10. Apply for Job
11. View All Applications
12. Update Application Status
13. View Placement Dashboard
14. View Student Applications
15. View Eligible Jobs
16. Search Jobs
17. Search Jobs by Location

## Project Structure

```text
com.placement
│
├── Main.java
│
├── dao
│   ├── StudentDAO.java
│   ├── CompanyDAO.java
│   ├── JobDAO.java
│   ├── ApplicationDAO.java
│   └── ReportDAO.java
│
├── model
│   ├── Student.java
│   ├── Company.java
│   ├── Job.java
│   └── Application.java
│
├── service
│   ├── StudentService.java
│   ├── CompanyService.java
│   ├── JobService.java
│   └── ApplicationService.java
│
└── util
    ├── DBConnection.java
    └── ValidationUtil.java
```

## Database

The application uses MySQL to store:

* Student information
* Company information
* Job information
* Job applications
* Application status

## Key Concepts Used

* Object-Oriented Programming
* Classes and Objects
* Encapsulation
* JDBC
* CRUD operations
* PreparedStatement
* SQL JOIN
* Input validation
* Exception handling
* Service and DAO layers

## Application Flow

Student → Search Jobs → Check Eligibility → Apply → Application Status → Placement Dashboard
