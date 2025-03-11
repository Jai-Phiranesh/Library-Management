# Library Management System

## Overview
The **Library Management System** is a Java application that allows administrators to manage books and customers to borrow, return, and search for books. The project utilizes Object-Oriented Programming (OOP) concepts such as:

- **Classes and Objects**
- **Method Overloading**
- **Inheritance**
- **Interfaces**
- **`instanceof` Operator**

## Features
### Admin Functionalities
- Add a new book
- Remove an existing book
- Search for a book by title or ISBN

### Customer Functionalities
- Borrow a book
- Return a borrowed book
- Search for a book

## Technologies Used
- **Language:** Java
- **Package:** `Library_Management`
- **OOP Principles:** Encapsulation, Inheritance, Polymorphism

## Code Structure
The main logic is implemented across multiple classes:
- `AdminActions`: Implements `AdminInterface` and allows admins to add, remove, and search books.
- `CustomerActions`: Implements `CustomerInterface` and handles book borrowing, returning, and searching.
- `LibraryPojo`: Stores book and account details.
- `Books`: Represents book objects.
- `Account`: Parent class for `Admin` and `Customer`.
- `Admin` & `Customer`: Extend `Account` to define user roles.

## How to Run
```bash
# Clone the repository
git clone https://github.com/yourusername/Library_Management.git

# Navigate to the project directory
cd Library_Management

# Compile all Java files
javac -d . *.java

# Run the application
java Library_Management.Main
```

## Example Output
```bash
1. Add Book
2. Remove Book
3. Search a Book
4. Exit

Enter choice: 1
Enter Book Title: The Great Gatsby
Enter Author Name: F. Scott Fitzgerald
Enter ISBN: 12345
Added Successfully
```

