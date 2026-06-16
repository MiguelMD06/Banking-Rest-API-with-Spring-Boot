# Banking App REST API (Account Management API)

This is an API developed using **Spring Boot** to realize banking account management. It allows to make CRUD operations for Accounts. I applied a clean architecture split in layers (MVC + Service + Repository).

## 🛠️ Technologies and Tools
* **Java** 25
* **Spring Boot** 4.1.0
* **Spring Data JPA** (Data Persistence)
* **MySQL** (Database)
* **Maven** (Dependency Manager)
* **Lombok** (Reduce Boilerplate code)

## 🚀 Settings and Local deployment

### Prerequisites
* Have installed JDK 25 or greater.
* Have a MySql Server.

### Environment Variables
To ensure that the application connects to the database securely, you must configure the following environment variables on your system or in your IDE:
* `DATABASE_USERNAME`: Your DB user
* `DATABASE_PASSWORD`: Yur DB password

### Steps to deploy:
1. Clone this repository:
```bash
   git clone https://github.com/MiguelMD06/Banking-Rest-API-with-Spring-Boot.git
```
2. Find Project folder and start the Application with Maven, executing the following code if you use windows:
```bash
    ./mvnw spring-boot:run
```
## 📌 API Endpoints Documentation

The base URL for all account-related endpoints is: `/api/accounts`

### Summary of Endpoints

| Method | Endpoint | Description | Status Code (Success) |
| :--- | :--- | :--- | :--- |
| **POST** | `/api/accounts` | Create a new banking account | `21 Created` |
| **GET** | `/api/accounts/{id}` | Retrieve account details by ID | `200 OK` |
| **GET** | `/api/accounts` | Retrieve a list of all accounts | `200 OK` |
| **PUT** | `/api/accounts` | Update existing account details | `200 OK` |
| **DELETE** | `/api/accounts/{id}` | Delete an account by ID | `200 OK` |
| **PUT** | `/api/accounts/{id}/deposit` | Deposit funds into an account | `200 OK` |
| **PUT** | `/api/accounts/{id}/withdraw` | Withdraw funds from an account | `200 OK` |

---

### Endpoint Details & Payload Examples

#### 1. Create Account
* **HTTP Method:** `POST`
* **Path:** `/api/accounts`
* **Request Body (`JSON`):**
  ```json
  {
    "accountHolderName": "John Doe",
    "balance": 1500.50
  }

#### 2. Get Account by ID
* **HTTP Method:** `GET`
* **Path:** `/api/accounts/{id}`
* **Example Path:** `/api/accounts/1`
* **Response Body (`JSON`):**
  ```json
  {
    "id": 1,
    "accountHolderName": "John Doe",
    "balance" : 15000.50
  }

#### 3. Get All accounts
* **HTTP Method:** `GET`
* **Path:** `/api/accounts`
* **Response Body (`JSON`):**
  ```json
  [
  {
    "id": 1,
    "accountHolderName": "John Doe",
    "balance": 1500.50
  },
  {
    "id": 2,
    "accountHolderName": "Jane Smith",
    "balance": 3200.00
  }
  ]

#### 4. Update Account
* **HTTP Method:** `PUT`
* **Path:** `/api/accounts`
* **Request Body (`JSON`):**
  ```json
  {
    "id": 1,
    "accountHolderName": "John Doe Fletcher",
    "balance": 1500.50
  }
* **Response Body (`JSON`):**
  ```json
  {
    "id": 1,
    "accountHolderName": "John Doe Fletcher",
    "balance": 1500.50
  }

#### 5. Delete Account
* **HTTP Method:** `DELETE`
* **Path:** `/api/accounts/{id}`
* **Example Path:** `/api/accounts/2`
* **Response Body (`TEXT`):**
  ```json
  Account with id 2 has been deleted successfully
 
#### 6. Deposit to Account
* **HTTP Method:** `PUT`
* **Path:** `/api/accounts/{id}/deposit`
* **Example Path:** `/api/accounts/2/deposit`
* **Request Body (`JSON`):**
  ```json
  {
    "amount" : "250.00"
  }
* **Response Body (`JSON`):**
  ```json
  {
    "id" : 2,
    "accountHolderName": "John Doe",
    "balance": 1750.00
  }
 
#### 7. Withdraw from Account
* **HTTP Method:** `PUT`
* **Path:** `/api/accounts/{id}/withdraw`
* **Example Path:** `/api/accounts/2/withdraw`
* **Request Body (`JSON`):**
  ```json
  {
    "amount" : "250.00"
  }
* **Response Body (`JSON`):**
  ```json
  {
    "id" : 2,
    "accountHolderName": "John Doe",
    "balance": 1250.00
  }
 
