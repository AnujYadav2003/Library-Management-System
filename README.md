# Library Management System

## Overview

The Library Management System is a web application designed to manage the operations of a library. It allows users to perform various actions based on their roles (Admin and User). The system is built using Spring Boot for the backend and MySQL as the database.

## Features

### Admin Features
- **Add a Book**: Admin can add new books to the catalog.
- **Update a Book**: Admin can update the details of existing books.
- **Delete a Book**: Admin can remove books from the catalog.
- **Manage Book Quantity**: Admin can update the quantity of books available in the catalog.
- **Manage Book Checkout**: Admin can manage the checkout process for books issued to users.
- **Manage Book Issues**: Admin can manage the issuance of books to users, including tracking the quantity of books issued.
- **Overall Catalog Management**: Admin has full control over the entire book catalog.

### User Features
- **Get All Books**: Users can view all available books in the library.
- **Get Book by ID**: Users can retrieve details of a specific book using its ID.
- **Search Books**: Users can search for books by title, author, or genre.
- **Get Books by Publication Year**: Users can retrieve books published in a specific year.
- **Get Books by Year Range**: Users can get a list of books published within a specified range of years.
- **Group Books by Genre**: Users can view books grouped by their genre.
- **Update User Information**: Users can update their personal information.
- **Issue a Book**: Users can issue books for reading purposes.
- **Get Books by Author**: Users can filter books based on the author's name.
- **CRUD Operations on Books**: Users can perform basic CRUD operations on books.

## Technologies Used
- **Backend**: Spring Boot
- **Database**: MySQL
- **Frontend**: (Optional: Specify if you have a frontend framework)
- **Build Tool**: Maven/Gradle (Specify which one you used)

## Getting Started
