
# Course Management System (Java Swing + JDBC)

A simple desktop application built using Java Swing and JDBC that allows users to manage courses with basic CRUD operations.
 Features

* Add course
* View courses
* Update course
* Delete course
* Simple GUI using Java Swing

Tech Stack

* Java (Swing for GUI)
* JDBC (Database connectivity)
* MySQL (Database)
* Eclipse IDE

 Project Structure

CourseApp/

├── src/
│   ├── db/
│   ├── model/
│   ├── dao/
│   ├── ui/
│   └── Main.java


 Database Setup

Create the database and table using the following SQL:
sql
CREATE DATABASE course_db;

USE course_db;

CREATE TABLE courses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    instructor VARCHAR(100),
    duration INT
);


 Setup Instructions

1. Clone the repository:
git clone https://github.com/hspooja05/Course_UI.git


2. Open the project in Eclipse.

3. Add MySQL Connector JAR to the project.

4. Update database credentials in DBConnection.java.

5. Run Main.java.


Notes

* Ensure MySQL is running before starting the application.
* Verify database username and password in DBConnection.java.


Author
Pooja H S
