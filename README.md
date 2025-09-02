# Rest Assured API Automation Project

## 📌 Project Overview
This project demonstrates API automation using **Rest Assured**, **TestNG**, and **Maven**.  
The implementation focuses on testing the `https://reqres.in/api/users` endpoint for user creation and retrieval.  

## 🛠️ Tools & Technologies
- **Java 17+**
- **Maven**
- **Rest Assured**
- **TestNG**
- **Extent Reports**

## 📂 Project Structure
```
src
 └── test
      ├── java
      │    ├── tests        # Contains API test classes
      │    └── utils        # Utilities (if needed)
      └── resources         # Configs / test data (future use)
```

## 🚀 How to Run

### 1. Clone the Project
```bash
git clone <repo-url>
cd <project-folder>
```

### 2. Run Tests with Maven
You must pass the API key at runtime as a system property.

```bash
mvn clean test -DapiKey=your_api_key_here
```

### 3. Example Test Execution
- **POST Request** to create a user:
  - Endpoint: `https://reqres.in/api/users`
  - Headers: `x-api-key` (provided via terminal)
  - Body:  
    ```json
    {
      "name": "morpheus",
      "job": "leader"
    }
    ```
  - Expected Response: `201 Created`

- **GET Request** to fetch users:
  - Endpoint: `https://reqres.in/api/users?page=2`
  - Expected Response: `200 OK`

## 📊 Reports
After execution, an **Extent Report** is generated under:
```
/test-output/ExtentReports/
```
Open `index.html` in a browser to view the detailed test report.

## ✅ Best Practices Followed
- No hardcoded values (API key passed via terminal).
- Reusable test structure.
- TestNG for test execution & assertions.
- Extent Reports for reporting.
