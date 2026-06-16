# Student Management System

## Project Overview

The Student Management System is a console-based Java application developed using JDBC and MySQL. The system helps educational institutions manage students, courses, enrollments, attendance, fees, and reports efficiently.

The project follows a layered architecture consisting of Model, DAO, Service, and Main layers, ensuring proper separation of concerns and maintainability.

---

## Features

### Student Management

* Add Student
* View Student
* View All Students
* Update Student Details
* Delete Student

### Course Management

* Add Course
* View Course
* View All Courses
* Update Course
* Delete Course

### Enrollment Management

* Enroll Students into Courses
* View Enrollment Details
* View All Enrollments
* Delete Enrollment

### Attendance Management

* Mark Attendance
* View Attendance Records
* View Attendance by Student
* Attendance Reports

### Fee Management

* Add Fee Records
* View Fee Details
* Update Fee Information
* Delete Fee Records
* Make Fee Payments

### Reports Module

* Dashboard Report
* Total Students Report
* Total Courses Report
* Students Per Course Report
* Fee Defaulters Report
* Attendance Percentage Report
* Enrollment Report
* Attendance Report
* Fee Report

### Security

* Admin Login System
* Custom Exception Handling

---

## Technology Stack

* Java
* JDBC
* MySQL
* Object-Oriented Programming (OOP)
* SQL
* Eclipse IDE / IntelliJ IDEA

---

## Project Architecture

src/

├── model/

│   ├── Student.java

│   ├── Course.java

│   ├── Enrollment.java

│   ├── Attendance.java

│   ├── Fee.java

│   └── Admin.java

│

├── dao/

│   ├── StudentDAO.java

│   ├── CourseDAO.java

│   ├── EnrollmentDAO.java

│   ├── AttendanceDAO.java

│   ├── FeeDAO.java

│   ├── ReportDAO.java

│   └── AdminDAO.java

│

├── service/

│   ├── StudentService.java

│   ├── CourseService.java

│   ├── EnrollmentService.java

│   ├── AttendanceService.java

│   ├── FeeService.java

│   ├── ReportService.java

│   └── AdminService.java

│

├── exception/

│   └── StudentNotFoundException.java

│

├── utility/

│   └── DBConnection.java

│

└── main/

```
└── Main.java
```

---

## Database Tables

### Students

* student_id
* student_name
* age
* gender
* email
* mobile
* address

### Courses

* course_id
* course_name
* duration
* fees

### Enrollments

* enrollment_id
* student_id
* course_id

### Attendance

* attendance_id
* student_id
* attendance_date
* status

### Fees

* fee_id
* student_id
* total_fee
* paid_fee
* remaining_fee

### Admin

* admin_id
* username
* password

---

## Reports Implemented

1. Dashboard Report
2. Total Students
3. Total Courses
4. Students Per Course
5. Fee Defaulters
6. Attendance Percentage
7. Enrollment Report
8. Attendance Report
9. Fee Report

---

## Key Concepts Used

* JDBC Connectivity
* PreparedStatement
* MySQL Database Integration
* Foreign Key Constraints
* SQL Joins
* Aggregate Functions
* Exception Handling
* Layered Architecture
* Object-Oriented Programming

---

## How to Run

1. Install MySQL Server.
2. Create a database named:

student_management

3. Execute the SQL script to create all required tables.
4. Update database credentials in:

DBConnection.java

5. Import the project into Eclipse or IntelliJ IDEA.
6. Add MySQL Connector JAR to the project build path.
7. Run Main.java.

---

## Sample Login

Username: admin

Password: admin123

---

## Future Enhancements

* Password Encryption
* Search Module
* Export Reports to CSV/PDF
* GUI using Java Swing
* JavaFX Version
* Email Notifications
* Role-Based Authentication

---

## Author

Developed as a Java JDBC & MySQL Student Management System Project.
