Use student_management;

CREATE TABLE students(
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    student_name VARCHAR(100),
    age INT,
    gender VARCHAR(10),
    email VARCHAR(100),
    mobile VARCHAR(15),
    address TEXT
);

CREATE TABLE courses(
    course_id INT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(100),
    duration VARCHAR(50),
    fees DOUBLE
);

CREATE TABLE enrollments
(
    enrollment_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    course_id INT NOT NULL,

        FOREIGN KEY (student_id)
        REFERENCES students(student_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    FOREIGN KEY (course_id)
        REFERENCES courses(course_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE attendance
(
    attendance_id INT AUTO_INCREMENT PRIMARY KEY,

    student_id INT NOT NULL,

    attendance_date DATE NOT NULL,

    status VARCHAR(10) NOT NULL,

    FOREIGN KEY(student_id)
    REFERENCES students(student_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE fees
(
    fee_id INT AUTO_INCREMENT PRIMARY KEY,

    student_id INT NOT NULL,

    total_fee DOUBLE NOT NULL,

    paid_fee DOUBLE DEFAULT 0,

    remaining_fee DOUBLE NOT NULL,

    FOREIGN KEY(student_id)
    REFERENCES students(student_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
); 

CREATE TABLE admin
(
    admin_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE placements (
    placement_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    student_name VARCHAR(100),
    age INT,
    gender VARCHAR(10),
    email VARCHAR(100),
    mobile VARCHAR(15),
    address TEXT,
    company_name VARCHAR(100),
    job_role VARCHAR(100),
    package_amount DOUBLE,
    placement_date DATE
);