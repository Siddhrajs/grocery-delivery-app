
# Captain Middleware PRD for Grocery Delivery App

## Overview

This Product Requirements Document (PRD) outlines the specifications for the **Captain Middleware**, which serves as both the **API Gateway** and **Page Layout Middleware** for the Grocery Delivery App. It will handle routing between the frontend and backend services, dynamically serving page layout information as well as managing API requests.

The Captain Middleware will provide a flexible architecture for the frontend to consume structured JSON data for dynamic page rendering and interact with various backend services.

---

## Key Features

1. **API Gateway**:
   - The Captain Middleware will act as the API Gateway, routing all frontend requests to the appropriate backend services (User Service, Order Service, Cart Service, etc.).
   - It will aggregate responses from various services and send the data back to the frontend in a structured JSON format.

2. **Dynamic Layout Rendering**:
   - The Captain Middleware will be responsible for generating dynamic layouts based on predefined structures and page configurations.
   - It will return a JSON response specifying which components (e.g., Navbar, Homepage, Footer) should be rendered on the frontend.
   - The layout data will be hierarchical, with child components included in parent components.

3. **Routing and Request Management**:
   - The middleware will manage the routing of requests between the frontend and microservices, ensuring that requests are forwarded to the correct backend services and responses are correctly processed and forwarded.
   - It will support both **RESTful** and **GraphQL** API calls, depending on the service requirements.

4. **Authorization and Authentication**:
   - The middleware will handle authentication by verifying JWT tokens provided by the frontend.
   - It will authenticate user requests and ensure secure access to the backend services.
   - Role-based access control (RBAC) will be implemented to ensure that users only have access to permitted resources.

5. **Caching**:
   - To optimize performance, Captain will implement caching mechanisms for frequently requested data (e.g., product lists, user info, etc.).
   - Cache expiration policies will be defined to ensure data is kept up to date without impacting performance.

6. **Error Handling**:
   - The middleware will provide consistent error handling for all requests, including handling timeouts, invalid data, and failed requests from backend services.
   - Friendly error messages will be returned to the frontend to ensure a smooth user experience.

7. **Extensibility**:
   - The middleware will be designed to be extensible, allowing for future integrations with mobile apps, third-party services, and additional backend services.

8. **Logging and Monitoring**:
   - The Captain Middleware will include logging for all incoming and outgoing requests.
   - Monitoring tools will be implemented to track performance metrics and alert on potential issues.

9. **Page Layout Data**:
   - The Captain Middleware will return structured JSON data for frontend rendering, including the components and sections to be displayed.
   - Each page will have its own layout configuration, which can be extended as new features are added.

---

## Technology Stack

- **Node.js** or **Spring Boot**: For building the middleware server, handling routing and API calls.
- **Express.js** or **Spring MVC**: For handling HTTP requests and routing.
- **JWT**: For authentication and session management.
- **Redis**: For caching frequently requested data.
- **Logging**: Using **Winston** or **Log4j** for logging requests and errors.
- **Monitoring**: Using tools like **Prometheus** and **Grafana** for performance monitoring.

---

## Middleware API Specification

### 1. **GET /layout/{page_name}**

- **Description**: Fetches the layout configuration for a given page (e.g., homepage, product page).
- **Response**: 
  ```json
  {
    "layout": ["navbar", "homepage", "footer"],
    "homepage": ["section1", "section2", "section3"],
    "navbar": {"items": ["home", "products", "cart"]},
    "footer": {"items": ["privacy-policy", "terms-of-service"]}
  }
  ```
- **Status Codes**:
  - 200: OK
  - 404: Page not found

### 2. **POST /authenticate**

- **Description**: Authenticates a user by verifying the JWT token and returns user data.
- **Request Body**: 
  ```json
  {
    "token": "jwt_token_here"
  }
  ```
- **Response**: 
  ```json
  {
    "user_id": "1234",
    "email": "user@example.com",
    "first_name": "John",
    "last_name": "Doe"
  }
  ```
- **Status Codes**:
  - 200: OK
  - 401: Unauthorized

### 3. **GET /products**

- **Description**: Retrieves a list of products from the **Catalogue Service** and returns it to the frontend.
- **Response**:
  ```json
  {
    "products": [
      {"id": 1, "name": "Apple", "price": 2.99, "image": "apple.jpg"},
      {"id": 2, "name": "Banana", "price": 1.49, "image": "banana.jpg"}
    ]
  }
  ```
- **Status Codes**:
  - 200: OK
  - 500: Internal Server Error

### 4. **POST /order**

- **Description**: Submits an order to the **Order Service**.
- **Request Body**:
  ```json
  {
    "user_id": "1234",
    "cart_items": [{"product_id": 1, "quantity": 2}, {"product_id": 2, "quantity": 1}],
    "payment_method": "credit_card"
  }
  ```
- **Response**:
  ```json
  {
    "order_id": "5678",
    "status": "Order Placed Successfully"
  }
  ```
- **Status Codes**:
  - 200: OK
  - 400: Bad Request
  - 500: Internal Server Error

### 5. **GET /order/{order_id}**

- **Description**: Retrieves the status of an order.
- **Response**:
  ```json
  {
    "order_id": "5678",
    "status": "Shipped",
    "delivery_date": "2024-12-10"
  }
  ```
- **Status Codes**:
  - 200: OK
  - 404: Order not found

---

## Error Handling

- **Standardized Error Responses**: 
  - Every error response will follow a consistent structure:
    ```json
    {
      "error": {
        "code": "error_code",
        "message": "Error message explaining the issue"
      }
    }
    ```

- **Error Codes**:
  - **400**: Bad Request (e.g., missing or invalid parameters).
  - **401**: Unauthorized (e.g., invalid or expired JWT token).
  - **404**: Not Found (e.g., requested resource not found).
  - **500**: Internal Server Error (e.g., backend service failure).

---

## Expected User Flow

1. **Frontend Request**:
   - The frontend will first request the page layout for the homepage or any other page via the `GET /layout/{page_name}` endpoint.

2. **API Gateway Routes**:
   - Based on the user's interactions, the Captain Middleware will route requests to appropriate backend services (e.g., Product data, Order service, etc.).

3. **Response Handling**:
   - The Captain Middleware will process responses from various backend services and return aggregated data in JSON format to the frontend.

4. **Dynamic Page Rendering**:
   - The frontend will use the JSON data received to dynamically render the page layout, products, user data, etc.

---

## Security Considerations

- **JWT Authentication**: 
  - All API calls from the frontend will require a valid JWT token, which will be verified by the middleware.

- **Role-Based Access Control (RBAC)**: 
  - The middleware will implement RBAC to ensure users have the right level of access to services (e.g., admin vs. regular user).

- **Data Validation**: 
  - The middleware will validate incoming data to ensure it adheres to expected formats, preventing malicious input.

---

## Conclusion

The **Captain Middleware** will be the backbone of the Grocery Delivery App, acting as the API Gateway and handling dynamic page rendering. By using structured JSON responses and providing routing between the frontend and backend services, it ensures a seamless and efficient user experience. The middleware will handle authentication, authorization, error management, and caching to optimize performance and security.