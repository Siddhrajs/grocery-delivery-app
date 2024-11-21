# Order Microservice PRD for Grocery Delivery App

## Overview

This Product Requirements Document (PRD) outlines the specifications for the **Order Microservice**, which will handle the processing of customer orders, managing the state of orders, and interfacing with other services such as **Payment Service**, **Delivery Service**, and **Catalogue Service**.

The Order Microservice will be a key component in the Grocery Delivery App's architecture, ensuring smooth order management and interaction with other services within the system.

---

## Key Features

1. **Order Creation**:
   - The service will accept order requests from the **Captain Middleware** and process them by validating the order details, creating a new order entry, and updating inventory levels.
   - It will ensure that the order details (user, product, payment method) are accurate and complete.

2. **Order Status Management**:
   - The service will maintain and update the order status through various stages such as "Placed", "Payment Pending", "Payment Successful", "Shipped", "Delivered", etc.
   - Status transitions will be updated in the system and can be tracked by users or admin.

3. **Integration with Payment Service**:
   - After an order is created, the **Payment Service** will be called to process payment and update the order status accordingly.
   - The Order Microservice will wait for the response from the Payment Service (e.g., payment success or failure) to update the order status.

4. **Integration with Delivery Service**:
   - Once payment is successful, the **Delivery Service** will be triggered to handle delivery logistics.
   - The order will be marked as "Shipped" when it leaves the warehouse, and it will be updated to "Delivered" when the user receives the order.

5. **Order Cancellation and Refund**:
   - The service will handle cancellations initiated by the user before the order is shipped.
   - It will process refunds if the order is canceled after payment, working with the **Payment Service** to reverse charges.

6. **Order History and Tracking**:
   - Users will be able to view the details of their past orders, including the status, items, total price, and delivery details.
   - Admins will be able to view the order history and manage orders in the backend.

7. **Inventory Management**:
   - The Order Service will interact with the **Catalogue Service** to ensure products are available before confirming an order.
   - It will also update product stock levels after order placement.

8. **Discount Application**:
   - The Order Service will support discount codes applied during checkout, interfacing with the **Discount and Pricing Engine**.
   - Discounts will be calculated and applied at the time of order creation.

9. **Shipping Address Management**:
   - The service will allow users to enter and update shipping addresses for their orders.
   - Addresses will be stored securely and linked to user profiles for future orders.

10. **API Exposure**:
    - The service will expose RESTful APIs to facilitate order management for frontend apps, including creating orders, fetching order details, updating statuses, and managing cancellations.

---

## Technology Stack

- **Node.js** or **Spring Boot**: For building the service and handling business logic.
- **Spring Data JPA** or **MongoDB**: For storing order data.
- **Redis**: For caching order details and frequently accessed data.
- **RabbitMQ** or **Kafka**: For asynchronous communication between services.
- **JWT**: For secure authentication and authorization of users.
- **REST API**: For communication with external services and frontend.

---

## Service API Specification

### 1. **POST /order**

- **Description**: Create a new order.
- **Request Body**:
  ```json
  {
    "user_id": "1234",
    "cart_items": [{"product_id": 1, "quantity": 2}, {"product_id": 2, "quantity": 1}],
    "payment_method": "credit_card",
    "shipping_address": "123 Main St, City, Country",
    "discount_code": "SAVE10"
  }
  ```
- **Response**:
  ```json
  {
    "order_id": "5678",
  "status": "Order Placed Successfully",
    "total_price": 10.99
  }
  ```
- **Status Codes**:
  - 200: OK
  - 400: Bad Request
  - 500: Internal Server Error

### 2. **GET /order/{order_id}**

- **Description**: Get the status and details of a specific order.
- **Response**:
  ```json
{
    "order_id": "5678",
    "status": "Shipped",
  "cart_items": [{"product_id": 1, "quantity": 2}, {"product_id": 2, "quantity": 1}],
  "total_price": 10.99,
  "payment_status": "Paid",
  "delivery_date": "2024-12-10",
    "shipping_address": "123 Main St, City, Country"
  } 
  ```
- **Status Codes**:
  - 200: OK
  - 404: Order not found

### 3. **PUT /order/{order_id}/cancel**

- **Description**: Cancel an order before it is shipped.
- **Response**:
  ```json
  {
  "order_id": "5678",
  "status": "Canceled",
  "refund_status": "Refund Initiated"
}
Status Codes:
  - 200: OK
  - 400: Bad Request (e.g., order already shipped)
  - 404: Order not found

### 4. **POST /order/{order_id}/payment**

- **Description**: Initiates payment for the order.
- **Request Body**:
  ```json   
  {
    "payment_method": "credit_card",
  "payment_details": {"card_number": "**** **** **** 1234", "expiry": "12/24", "cvv": "123"}
}
Response:
  ```json
  {
    "status": "Payment Successful",
    "order_id": "5678"
}
- **Status Codes**:
  - 200: OK
  - 400: Bad Request (e.g., invalid payment details)
  - 500: Internal Server Error

### 5. **GET /orders/user/{user_id}**

- **Description**: Retrieves a list of orders for a user.
Response:
  ```json
{
  "orders": [
    {
      "order_id": "5678",
      "status": "Shipped",
      "total_price": 10.99,
      "order_date": "2024-11-20",
      "payment_status": "Paid"
    },
    {
      "order_id": "5679",
      "status": "Pending",
      "total_price": 15.49,
      "order_date": "2024-11-21",
      "payment_status": "Pending"
    }
  ]
}
- **Status Codes**:
  - 200: OK
  - 404: No orders found

### Error Handling
Standardized Error Responses:

Every error response will follow a consistent structure:
```json
{
  "error": {
    "code": "error_code",
    "message": "Error message explaining the issue"
  }
}
```
- **Error Codes**:
  - 400: Bad Request (e.g., missing or invalid parameters).
  - 404: Not Found (e.g., requested order not found).
  - 500: Internal Server Error (e.g., backend service failure).

### Expected User Flow

- **Order Creation**:
  - A user initiates the order by adding items to the cart and proceeding to checkout.
  - The Order Service validates and processes the request, confirming product availability and applying any discounts.
- **Payment Processing**:
  - The Payment Service processes the payment, and the order status is updated accordingly.
  - If payment is successful, the order is marked as "Paid" and ready for delivery.
- **Order Status Updates**:
  - Once the order is confirmed, it will be updated to "Shipped" by the Delivery Service.
  - The user can track the order status via the frontend.
- **Order Cancellation**:
  - Users can cancel orders before they are shipped, triggering a refund process and updating the order status.

### Security Considerations

- **JWT Authentication**:
  - All API calls from the frontend and external services will require a valid JWT token.
- **Data Validation**:
  - All incoming data will be validated for correctness and security (e.g., payment details, product IDs).
- **Role-Based Access Control (RBAC)**:
  - Admin users will have access to all orders, while customers will only have access to their own orders.

### Conclusion

The Order Microservice will handle the complete lifecycle of an order, from creation to payment and delivery. It will integrate with other services such as Payment, Delivery, and Discount Engine to provide a seamless order management experience. By maintaining order status, history, and supporting cancellations, the Order Service will ensure that customers have a smooth and reliable experience with the Grocery Delivery App.
