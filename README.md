# RegisterLoginJava

A simple **User Registration and Login System** developed in Java. This console-based application allows users to create accounts and log in using credentials stored in a local text file.

## Overview

RegisterLoginJava provides a menu-driven interface with two options: log in to an existing account or create a new account. During registration, users enter a username and password, confirm the password, and receive feedback if the username already exists.

The application stores account information in a comma-separated text file and reads that file when authenticating users.

## Features

- **Login:** Checks a username and password against stored account records.
- **Account registration:** Allows users to create new accounts.
- **Password confirmation:** Requests the password twice during registration.
- **Duplicate username detection:** Prevents registration when the username is already present.
- **Input validation:** Restricts usernames and passwords to alphanumeric characters.
- **Login feedback:** Displays success or an error message after authentication.
- **File handling:** Reads and appends account records to a local text file.
- **Exception handling:** Provides error messages when file access or other operations fail.

## Technologies Used

- Java
- `Scanner` for console input
- `BufferedReader` and `FileReader` for reading account records
- `FileWriter` for saving new accounts
- `IOException` handling for file operations

## Requirements

- Java Development Kit (JDK)
- A terminal or command prompt, or a Java-compatible IDE
- Permission to read and write the account database file

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/ichiroyamazaki/RegisterLoginJava.git
cd RegisterLoginJava
```

### 2. Configure the account database

The source currently uses this hardcoded Windows path:

```text
C:/Users/i/MichiroYamazaki/Documents/Database.txt
```

Create the `Database.txt` file at that location, or change the path in `TaskPerf.java` to a location on your computer.

The application stores account records in this format:

```text
username,password
```

Each account occupies one line. For example:

```text
player01,example123
student02,java2026
```

**Security warning:** These examples are illustrative only. The application stores passwords as plain text, so do not use real or reused passwords. This storage method is not appropriate for production authentication.

### 3. Compile the program

The source declares the `TaskPerf6` package. From the repository root, compile it with:

```bash
javac -d . TaskPerf.java
```

### 4. Run the program

```bash
java TaskPerf6.TaskPerf
```

You can also open the source in a Java IDE and run the `TaskPerf` class while preserving its package configuration.

## How to Use

### Create an account

1. Start the program.
2. Select option `2` to create an account.
3. Enter an alphanumeric username.
4. Enter an alphanumeric password.
5. Re-enter the password when prompted.
6. Follow the feedback displayed by the application.

If the username is already registered, the program displays a message indicating that the account exists.

### Log in

1. Start the program.
2. Select option `1`.
3. Enter your registered username.
4. Enter the corresponding password.
5. Review the authentication result.

The application reports successful login when the entered credentials match a stored record.

## Database Format

The application uses a local text file rather than a database server.

```text
username,password
```

The file is read during login and registration. New account records are appended to the file after successful registration.

Because the file uses commas to separate usernames and passwords, the current format is not suitable for arbitrary values containing commas.

## Current Limitations

- Passwords are stored in plain text rather than securely hashed.
- The database location is hardcoded to a Windows-specific path.
- The database file must be accessible for account operations to succeed.
- Usernames and passwords accept only alphanumeric characters.
- The application does not use a database management system.
- There is no password recovery, account deletion, or account management interface.
- Authentication is intended for a local programming exercise, not a production environment.
- Input validation and error handling could be strengthened.

## Recommended Security Improvements

- Hash passwords using a suitable password-hashing algorithm such as Argon2id, bcrypt, or PBKDF2.
- Replace the hardcoded file path with a configurable location.
- Use a structured storage format or database instead of manually parsing comma-separated records.
- Validate menu input and malformed account records more carefully.
- Avoid storing real credentials in the repository or example files.
- Add automated tests for registration, duplicate usernames, and login validation.

## Project Structure

```text
RegisterLoginJava/
├── TaskPerf.java
└── README.md
```

## Purpose

This project demonstrates fundamental Java programming concepts, including console input, conditional statements, loops, file handling, string comparison, input validation, and exception handling.

## Repository

[https://github.com/ichiroyamazaki/RegisterLoginJava](https://github.com/ichiroyamazaki/RegisterLoginJava)
