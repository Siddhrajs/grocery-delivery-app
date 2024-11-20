# Spring Boot and React Google OAuth2 Integration

This repository demonstrates a full-stack implementation of Google OAuth2 login using Spring Boot for the backend and React for the frontend. It is a starting point for building scalable, secure applications.

## Features

- **Backend**: Spring Boot OAuth2 login with Google.
- **Frontend**: React app with user-friendly authentication flow.
- **Security**: Secure OAuth2 implementation.
- Extendable to other OAuth2 providers.

## Prerequisites

- **Java 17** or later for backend.
- **Node.js and npm/yarn** for frontend.
- **MySQL** (or another database if required).
- Google OAuth2 credentials.

## Project Structure

- **backend/**: Spring Boot application.
- **frontend/**: React application.

## Setup Instructions

### Backend

1. Navigate to the backend directory:
   ```bash
   cd backend

2. Create a MySQL database:
    ```bash
    CREATE DATABASE oauth_demo;

3. Configure application.yaml with Google credentials and database details.
4. Build and run the backend:
    ```bash
    mvn clean install
    mvn spring-boot:run

### Frontend

1. Navigate to the frontend directory:
    ```bash
    cd frontend

2. Install dependencies:
    ```bash
    npm install

3. Start the React development server:
    ```bash
    npm start

## Usage
 - Access the React app at http://localhost:3000.
 - Authenticate using Google OAuth2.

## Contributing
 - Contributions are welcome! Open issues or submit pull requests to improve functionality.

## License
 - This project is licensed under the MIT License.
