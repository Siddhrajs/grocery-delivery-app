
# Product Requirements Document (PRD) for User Service

---

## 1. Overview
The **User Service** is a core microservice in the grocery delivery platform, responsible for managing user accounts, profiles, addresses, preferences, and roles. It provides APIs to enable interaction with other services like Authentication, Order, and Delivery.

---

## 2. Objectives
- Enable seamless user registration, profile management, and data retrieval.
- Support address management for deliveries.
- Store user preferences for personalized experiences.
- Manage user roles for access control.

---

## 3. Features and Functionalities

### 3.1 Core Features
1. **User Management**
   - Create, read, update, and delete (CRUD) user accounts.
   - Store user profile details (e.g., name, email, phone).
   - Securely manage passwords using hashed storage.

2. **Address Management**
   - Allow users to manage multiple addresses (add, edit, delete).
   - Mark an address as the default.

3. **User Preferences**
   - Save and retrieve user-specific preferences (e.g., notifications, themes).
   - Provide key-value pair support for flexible preference management.

4. **Role Management**
   - Assign roles to users (e.g., Admin, Customer).
   - Retrieve roles for access control.

---

## 4. Database Schema
+------------------------+               +------------------------+
|       Users            |               |       Roles            |
+------------------------+               +------------------------+
| user_id (PK)          |                | role_id (PK)           |
| email (unique)        |                | role_name              |
| phone_number (unique) |                | created_at             |
| password_hash         |      1         | updated_at             |
| first_name            |--------------> | user_id (FK)           |
| last_name             |                +------------------------+
| date_of_birth         |
| profile_picture       |                   +------------------------+
| created_at            |        1          |      Preferences       |
| updated_at            |------------------>+------------------------+
+------------------------+                  | preference_id (PK)     |
           |                                | user_id (FK)           |
           |                                | preference_key         |
           |                                | preference_value       |
           |                                | created_at             |
           |                                | updated_at             |
           v                                +------------------------+
+------------------------+
|  Addresses             |
+------------------------+
| address_id (PK)       |
| user_id (FK)          |
| address_line_1        |
| address_line_2        |
| city                  |
| state                 |
| postal_code           |
| country               |
| is_default (boolean)  |
| created_at            |
| updated_at            |
+------------------------+
---

## 5. API Endpoints

### 5.1 User Endpoints
| HTTP Method | Endpoint             | Description                      |
|-------------|----------------------|----------------------------------|
| POST        | `/users`             | Register a new user             |
| GET         | `/users/{id}`        | Retrieve user details           |
| PUT         | `/users/{id}`        | Update user details             |
| DELETE      | `/users/{id}`        | Delete a user                   |

### 5.2 Address Endpoints
| HTTP Method | Endpoint                  | Description                      |
|-------------|---------------------------|----------------------------------|
| POST        | `/users/{id}/addresses`   | Add a new address               |
| GET         | `/users/{id}/addresses`   | Retrieve all addresses for user |
| PUT         | `/users/{id}/addresses/{address_id}` | Update address        |
| DELETE      | `/users/{id}/addresses/{address_id}` | Delete address        |

### 5.3 Preference Endpoints
| HTTP Method | Endpoint                          | Description                      |
|-------------|-----------------------------------|----------------------------------|
| POST        | `/users/{id}/preferences`         | Add a new preference            |
| GET         | `/users/{id}/preferences`         | Retrieve preferences            |
| PUT         | `/users/{id}/preferences/{key}`   | Update preference               |
| DELETE      | `/users/{id}/preferences/{key}`   | Delete preference               |

### 5.4 Role Endpoints
| HTTP Method | Endpoint                   | Description                      |
|-------------|----------------------------|----------------------------------|
| POST        | `/users/{id}/roles`        | Assign a role                   |
| GET         | `/users/{id}/roles`        | Retrieve roles for user         |
| DELETE      | `/users/{id}/roles/{role}` | Remove a role                   |

---

## 6. Security
1. **Authentication**: All endpoints require a valid JWT token issued by the Authentication Service.
2. **Authorization**: Role-based access control for sensitive operations (e.g., assigning roles).

---

## 7. Non-Functional Requirements
1. **Scalability**: Support millions of users and concurrent requests.
2. **Performance**: Response time should be under 200ms for most API calls.
3. **Data Consistency**: Ensure strong consistency for user data across services.
4. **Availability**: 99.9% uptime SLA.
5. **Compliance**: Adhere to GDPR and local data privacy laws.

---

## 8. Dependencies
- **Authentication Service**: For login and token validation.
- **Order Service**: To fetch orders associated with a user.
- **Delivery Service**: To link addresses for deliveries.

---

## 9. Milestones
| Milestone                 | Deliverable                   | Timeline |
|---------------------------|-------------------------------|----------|
| User CRUD API             | Basic user management         | Week 1   |
| Address Management API    | Address-related operations    | Week 2   |
| Preference Management API | User preferences              | Week 3   |
| Role Management API       | Role-based access control     | Week 4   |

---

## 10. Risks
1. **Data Breach**: Ensure encrypted data storage and secure transmission.
2. **High Load**: Implement rate limiting and caching strategies.
3. **Integration Issues**: API compatibility with other services.

---

This PRD provides a comprehensive outline for the development of the User Service, ensuring alignment with business goals and technical requirements.