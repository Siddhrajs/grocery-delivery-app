# Frontend PRD for Grocery Delivery App

## Overview

This Product Requirements Document (PRD) outlines the specifications for the **Frontend** of the Grocery Delivery App, which will be built using **React** and **Tailwind CSS**. The frontend will dynamically render pages by consuming the JSON responses from the **Captain Middleware** (API Gateway). It will also make additional API calls for various user actions, such as placing orders, updating the cart, and more.

---

## Key Features

1. **Dynamic Layout Rendering**:
   - The frontend will receive structured JSON data from the Captain Middleware, which defines the layout and content for each page.
   - Components like **Navbar**, **Homepage**, **Footer**, etc., will be rendered dynamically based on the layout data provided in the JSON.

2. **Responsive Design**:
   - The application will be responsive and optimized for web and mobile devices using **Tailwind CSS**.
   - UI elements will adapt to different screen sizes (desktops, tablets, and mobiles).

3. **Real-time Data**:
   - Frontend will make API calls to backend services (e.g., Order Service, User Service, etc.) for real-time data such as products, cart updates, and order status.
   - Use **Axios** or **Fetch API** for asynchronous API calls to backend services.

4. **User Authentication**:
   - The frontend will include login, registration, and session management.
   - Use JWT tokens for authenticating users and managing sessions.

5. **Product Listing**:
   - The frontend will display products dynamically fetched from the **Catalogue Service**.
   - Each product will include details like name, price, image, and availability.

6. **Shopping Cart**:
   - Users can add products to the cart, view the cart, and update quantities.
   - Cart data will be managed via API calls to the **Cart Service**.

7. **Checkout & Payment**:
   - The frontend will allow users to review their orders and proceed to checkout.
   - The **Payment Service** will handle payment integration (e.g., Stripe, PayPal).

8. **Order History**:
   - Users will be able to view their past orders and track their delivery status.

9. **Discounts and Offers**:
   - The frontend will display applicable discounts and offers from the **Discount and Pricing Engine**.

10. **Error Handling & Loading States**:
    - The application will show loading indicators and handle API call errors gracefully.

---

## Technology Stack

- **React**: Used for building the user interface (UI) and managing the application state.
- **Tailwind CSS**: For utility-first CSS framework to style components and ensure responsiveness.
- **Axios/Fetch API**: For making asynchronous requests to backend services.
- **React Router**: For handling client-side routing and navigation between pages.
- **JWT**: For user authentication and maintaining secure sessions.
- **Redux/Context API**: For managing the application’s global state, especially cart and user data.

---

## Page Layout Example

The page layout will be based on the JSON structure received from Captain Middleware. Here is an example of how the page will be rendered:

### Example JSON from Captain Middleware:
```json
{
  "layout": ["navbar", "homepage", "footer"],
  "navbar": {
    "items": ["home", "products", "offers", "cart"]
  },
  "homepage": [
    "banner",
    "section1",
    "section2"
  ],
  "section1": {
    "type": "product-list",
    "products": [
      {"id": 1, "name": "Apple", "price": "2.99", "image": "apple.jpg"},
      {"id": 2, "name": "Banana", "price": "1.49", "image": "banana.jpg"}
    ]
  },
  "footer": {
    "items": ["privacy-policy", "terms-of-service", "contact-us"]
  }
}
```

### Frontend Components:

- **Navbar**: Rendered based on the items in the navbar section.
  ```jsx
  <nav>
    <ul>
      {layout.navbar.items.map(item => (
        <li key={item}>{item}</li>
      ))}
    </ul>
  </nav>
  ```

- **Homepage Sections**: Each section will be dynamically loaded based on the JSON data.
  ```jsx
  <div>
    {layout.homepage.map(section => (
      <Section key={section} section={layout[section]} />
    ))}
  </div>
  ```

- **Product List**: Render products dynamically within a section.
  ```jsx
  <div className="product-list">
    {section1.products.map(product => (
      <ProductCard key={product.id} product={product} />
    ))}
  </div>
  ```

- **Footer**: Render footer items.
  ```jsx
  <footer>
    <ul>
      {layout.footer.items.map(item => (
        <li key={item}>{item}</li>
      ))}
    </ul>
  </footer>
  ```

---

## API Calls

- **User Authentication (Login/Logout/Signup)**:
  - POST request to `/auth/login` for user login.
  - POST request to `/auth/signup` for user registration.
  - Use JWT tokens for managing user sessions.

- **Product Data (Catalogue Service)**:
  - GET request to `/catalogue/products` for fetching the product list.

- **Cart Management (Cart Service)**:
  - POST request to `/cart/add` for adding items to the cart.
  - GET request to `/cart` to retrieve the current cart state.

- **Order Placement (Order Service)**:
  - POST request to `/order` to place an order.

- **Payment (Payment Service)**:
  - POST request to `/payment` for initiating the payment process.

---

## UI/UX Design

The user interface will be styled using **Tailwind CSS** to ensure responsiveness and a clean, modern design.

### Sample UI Elements:
- **Navbar**: A navigation bar that displays links like "Home", "Products", "Cart", and "Offers".
- **Product List**: Displaying products in a grid layout, each with an image, name, price, and an "Add to Cart" button.
- **Product Details**: A detailed product page that shows more information about the product and allows users to add it to the cart.
- **Shopping Cart**: A cart page where users can view items, adjust quantities, and proceed to checkout.

---

## Expected User Flow

1. **Homepage**:
   - Users land on the homepage, which is rendered dynamically using Captain Middleware.
   - The page will load various sections (banner, product list, etc.).

2. **Product Browsing**:
   - Users can browse products by navigating through the homepage or catalog pages.

3. **Adding to Cart**:
   - Users can add products to their cart using the "Add to Cart" button on each product card.

4. **Checkout**:
   - Users can view their cart and proceed to checkout, which integrates with the **Payment Service**.

5. **Order Confirmation**:
   - Once payment is successful, the user is shown an order confirmation page.

---

## Error Handling

1. **Loading States**:
   - Show loading spinners or skeleton loaders while the data is being fetched.

2. **Error States**:
   - Display friendly error messages for failed API calls or data fetching errors.

3. **Fallback UI**:
   - In case of an issue (e.g., no products available), provide fallback content such as "No products available" or "Something went wrong".

---

## Testing

1. **Unit Tests**:
   - Write unit tests for React components using **Jest** and **React Testing Library**.

2. **Integration Tests**:
   - Ensure that the frontend correctly integrates with backend APIs using **Axios** mocks or **MSW** (Mock Service Worker).

3. **End-to-End Tests**:
   - Perform end-to-end testing using **Cypress** or **Playwright** to test user flows like registration, adding products to the cart, and completing a purchase.

---

## Conclusion

The **Grocery Delivery App Frontend** will be built using **React** and **Tailwind CSS**, consuming JSON responses from the **Captain Middleware** to dynamically render pages and provide a seamless user experience. It will interact with various backend services through API calls to manage user authentication, products, cart, and orders. The application will be fully responsive, offering a smooth experience across both web and mobile platforms.