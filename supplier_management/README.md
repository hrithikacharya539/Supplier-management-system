# Supplier Management System

A Spring Boot application for managing suppliers, products, and orders in a supplier management system.

## API Endpoints

### Suppliers

#### 1. Add Supplier
- **Method**: POST
- **Endpoint**: `/suppliers`
- **Description**: Adds a new supplier to the system.
- **Request Body**:
  ```json
  {
    "supplierName": "ABC Supplies",
    "email": "contact@abc.com",
    "phone": "+1234567890",
    "address": "123 Main St, City, Country",
    "registrationDate": "2023-01-15",
    "status": "Active"
  }
  ```
- **Response**:
  ```json
  {
    "supplierId": 1,
    "supplierName": "ABC Supplies",
    "email": "contact@abc.com",
    "phone": "+1234567890",
    "address": "123 Main St, City, Country",
    "registrationDate": "2023-01-15",
    "status": "Active"
  }
  ```

#### 2. Get All Suppliers
- **Method**: GET
- **Endpoint**: `/suppliers`
- **Description**: Retrieves a list of all suppliers.
- **Request Body**: None
- **Response**:
  ```json
  [
    {
      "supplierId": 1,
      "supplierName": "ABC Supplies",
      "email": "contact@abc.com",
      "phone": "+1234567890",
      "address": "123 Main St, City, Country",
      "registrationDate": "2023-01-15",
      "status": "Active"
    }
  ]
  ```

#### 3. Get Supplier by ID
- **Method**: GET
- **Endpoint**: `/suppliers/{id}`
- **Description**: Retrieves a supplier by their ID.
- **Path Parameter**: `id` (integer)
- **Request Body**: None
- **Response**:
  ```json
  {
    "supplierId": 1,
    "supplierName": "ABC Supplies",
    "email": "contact@abc.com",
    "phone": "+1234567890",
    "address": "123 Main St, City, Country",
    "registrationDate": "2023-01-15",
    "status": "Active"
  }
  ```

#### 4. Delete Supplier
- **Method**: DELETE
- **Endpoint**: `/suppliers/{id}`
- **Description**: Deletes a supplier by their ID.
- **Path Parameter**: `id` (integer)
- **Request Body**: None
- **Response**: "Supplier with ID 1 deleted."

### Products

#### 1. Add Product
- **Method**: POST
- **Endpoint**: `/products`
- **Description**: Adds a new product to the system.
- **Request Body**:
  ```json
  {
    "productName": "Laptop",
    "category": "Electronics",
    "price": 999.99,
    "stockQuantity": 50,
    "supplier": {
      "supplierId": 1
    }
  }
  ```
- **Response**:
  ```json
  {
    "productId": 1,
    "productName": "Laptop",
    "category": "Electronics",
    "price": 999.99,
    "stockQuantity": 50,
    "supplier": {
      "supplierId": 1,
      "supplierName": "ABC Supplies"
    }
  }
  ```

#### 2. Get All Products
- **Method**: GET
- **Endpoint**: `/products`
- **Description**: Retrieves a list of all products.
- **Request Body**: None
- **Response**:
  ```json
  [
    {
      "productId": 1,
      "productName": "Laptop",
      "category": "Electronics",
      "price": 999.99,
      "stockQuantity": 50,
      "supplier": {
        "supplierId": 1,
        "supplierName": "ABC Supplies"
      }
    }
  ]
  ```

#### 3. Get Product by ID
- **Method**: GET
- **Endpoint**: `/products/{id}`
- **Description**: Retrieves a product by its ID.
- **Path Parameter**: `id` (long)
- **Request Body**: None
- **Response**:
  ```json
  {
    "productId": 1,
    "productName": "Laptop",
    "category": "Electronics",
    "price": 999.99,
    "stockQuantity": 50,
    "supplier": {
      "supplierId": 1,
      "supplierName": "ABC Supplies"
    }
  }
  ```

#### 4. Update Product
- **Method**: PUT
- **Endpoint**: `/products`
- **Description**: Updates an existing product.
- **Request Body**:
  ```json
  {
    "productId": 1,
    "productName": "Gaming Laptop",
    "category": "Electronics",
    "price": 1199.99,
    "stockQuantity": 30,
    "supplier": {
      "supplierId": 1
    }
  }
  ```
- **Response**:
  ```json
  {
    "productId": 1,
    "productName": "Gaming Laptop",
    "category": "Electronics",
    "price": 1199.99,
    "stockQuantity": 30,
    "supplier": {
      "supplierId": 1,
      "supplierName": "ABC Supplies"
    }
  }
  ```

#### 5. Delete Product
- **Method**: DELETE
- **Endpoint**: `/products/{id}`
- **Description**: Deletes a product by its ID.
- **Path Parameter**: `id` (long)
- **Request Body**: None
- **Response**: "Product deleted successfully."

### Orders

#### 1. Place Order
- **Method**: POST
- **Endpoint**: `/orders`
- **Description**: Places a new order.
- **Request Body**:
  ```json
  {
    "supplier": {
      "supplierId": 1
    },
    "orderDate": "2023-05-20",
    "totalAmount": 1999.98,
    "orderStatus": "Pending"
  }
  ```
- **Response**:
  ```json
  {
    "orderId": 1,
    "supplier": {
      "supplierId": 1,
      "supplierName": "ABC Supplies"
    },
    "orderDate": "2023-05-20",
    "totalAmount": 1999.98,
    "orderStatus": "Pending"
  }
  ```

#### 2. Get All Orders
- **Method**: GET
- **Endpoint**: `/orders`
- **Description**: Retrieves a list of all orders.
- **Request Body**: None
- **Response**:
  ```json
  [
    {
      "orderId": 1,
      "supplier": {
        "supplierId": 1,
        "supplierName": "ABC Supplies"
      },
      "orderDate": "2023-05-20",
      "totalAmount": 1999.98,
      "orderStatus": "Pending"
    }
  ]
  ```

#### 3. Get Order by ID
- **Method**: GET
- **Endpoint**: `/orders/{id}`
- **Description**: Retrieves an order by its ID.
- **Path Parameter**: `id` (long)
- **Request Body**: None
- **Response**:
  ```json
  {
    "orderId": 1,
    "supplier": {
      "supplierId": 1,
      "supplierName": "ABC Supplies"
    },
    "orderDate": "2023-05-20",
    "totalAmount": 1999.98,
    "orderStatus": "Pending"
  }
  ```

#### 4. Update Order Status
- **Method**: PUT
- **Endpoint**: `/orders/{id}/status`
- **Description**: Updates the status of an order.
- **Path Parameter**: `id` (long)
- **Query Parameter**: `status` (string, e.g., "Shipped")
- **Request Body**: None
- **Response**:
  ```json
  {
    "orderId": 1,
    "supplier": {
      "supplierId": 1,
      "supplierName": "ABC Supplies"
    },
    "orderDate": "2023-05-20",
    "totalAmount": 1999.98,
    "orderStatus": "Shipped"
  }
  ```

#### 5. Delete Order
- **Method**: DELETE
- **Endpoint**: `/orders/{id}`
- **Description**: Deletes an order by its ID.
- **Path Parameter**: `id` (long)
- **Request Body**: None
- **Response**: "Order deleted successfully."