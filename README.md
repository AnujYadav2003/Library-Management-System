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



# Library Management System API Documentation

## UserController
### REST API for User Controller

- **PUT** `/api/users/update/{userId}`
  - Update user information.

- **PUT** `/api/users/update/role/{role}/{userId}`
  - Update the role of a user.

- **POST** `/api/users/register`
  - Register a new user.

- **GET** `/api/users/getUser ById/{userId}`
  - Retrieve user information by user ID.

- **GET** `/api/users/getAllUsers`
  - Retrieve a list of all users.

- **DELETE** `/api/users/deleteUser ById/{userId}`
  - Delete a user by user ID.

---

## BookCheckOutController
### REST API for BookCheckOut Controller

- **PUT** `/api/checkOut/returnBook/userId/{userId}/bookId/{bookId}`
  - Return a book by user ID and book ID.

- **POST** `/api/checkOut/issue/userId/{userId}/bookId/{bookId}/reqQuantity/{requestedQuantity}`
  - Issue a book to a user with the requested quantity.

- **GET** `/api/checkOut/issuedBooks/user/{userId}`
  - Retrieve all books issued to a specific user.

- **GET** `/api/checkOut/isIssuedBook/{bookId}`
  - Check if a specific book is issued.

- **GET** `/api/checkOut/getAllIssuedBook`
  - Retrieve a list of all issued books.

---

## BookController
### REST API for Book Controller

- **PUT** `/api/books/updateBookById/bookId/{bookId}/userId/{userId}`
  - Update book information by book ID and user ID.

- **POST** `/api/books/create/{userId}`
  - Create a new book entry.

- **GET** `/api/books/searchBookByTitle/{title}`
  - Search for books by title.

- **GET** `/api/books/searchBookByGenre/{genre}`
  - Search for books by genre.

- **GET** `/api/books/searchBookByAuthor/{author}`
  - Search for books by author.

- **GET** `/api/books/groupBooksByGenre`
  - Group books by genre.

- **GET** `/api/books/getBooksPublishedIn/{year}`
  - Retrieve books published in a specific year.

- **GET** `/api/books/getBooksPublished/{year1}/to/{year2}`
  - Retrieve books published within a specified range of years.

- **GET** `/api/books/getBooksById/{bookId}`
  - Retrieve book information by book ID.

- **GET** `/api/books/getAllBooks`
  - Retrieve a list of all books.

- **DELETE** `/api/books/deleteBookById/bookId/{bookId}/userId/{userId}`
  - Delete a book by book ID and user ID.

---

## CatalogController
### REST API for Catalog Controller

- **PUT** `/api/catalog/reduceQuantity/bookId/{bookId}/quantity/{quantity}/userId/{userId}`
  - Reduce the quantity of a book in the catalog.

- **POST** `/api/catalog/add/userId/{userId}`
  - Add a new catalog entry.

- **GET** `/api/catalog/getCatalogById/{catalogId}`
  - Retrieve catalog information by catalog ID.

- **GET** `/api/catalog/getAll`
  - Retrieve a list of all catalog entries.

---
