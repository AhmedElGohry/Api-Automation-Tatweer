# Rest Assured Project - ReqRes API Testing

## Overview
This project was created to explore and test the public **ReqRes API** using Rest Assured, Cucumber, TestNG, and Extent Reports.  
The goal was to implement API tests for different scenarios such as user creation and retrieving user data.

---

## Trials and Findings

### 1. Base Setup
- Configured the base URI as: `https://reqres.in/api`.
- Verified GET endpoints (such as `/users`) work successfully **without authentication**.
- Responses returned user data correctly when testing with query parameters (e.g., `delay`).

---

### 2. POST Request - User Creation
- Attempted to send a POST request with body:
  ```json
  {
    "name": "morpheus",
    "job": "leader"
  }
  ```
  using endpoint: `https://reqres.in/api/users`.

- **Issue Encountered**:  
  The response consistently returned:
  ```json
  {
    "error": "Missing API key"
  }
  ```

- After checking the official Swagger documentation (`https://reqres.in/api-docs/`):
  - No endpoint named **`/api/users` for create user** was found in the provided Swagger UI.
  - Documentation mainly includes **list users, single user, register, login, and delayed response**.
  - The "Create User" example shown in some tutorials **does not appear in the Swagger documentation**.

---

### 3. Register/Login Endpoints
- Tried the following endpoints:
  - `POST /register`
  - `POST /login`
- Both require email and password fields as input.
- With invalid or missing inputs, API responded with appropriate error messages.

---

## Conclusion
- **GET requests** (like `/users` and `/users?delay=3`) are working fine without requiring authentication.
- **POST requests for register/login** require specific fields (`email`, `password`).
- **Create User endpoint is not available in the official Swagger documentation**, which is why POST requests to `/api/users` failed with *"Missing API key"*.

---

## Next Steps
1. Continue validating available endpoints (`/users`, `/register`, `/login`).
2. Adjust the test scenarios to match **only supported endpoints** listed in the official documentation.
3. Ensure test data is parameterized and not hard-coded.

---
