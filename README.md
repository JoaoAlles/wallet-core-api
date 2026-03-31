# Wallet Core API 🚀

Financial management API for personal wallet control, built with **Java 21** and **Spring Boot 3**. This project was designed to showcase robust backend development skills, focusing on financial rules, security, and performance.

## 🛠 Technologies
- **Java 21** (LTS)
- **Spring Boot 3**
- **Spring Security** with **JWT** (JSON Web Tokens)
- **Spring Data JPA** with **Hibernate**
- **PostgreSQL**
- **Lombok** (Boilerplate reduction)
- **Maven** (Dependency management)

## 🧠 Key Features & Architecture
- **Financial Core Logic**: Precise calculations using `BigDecimal` to avoid binary rounding errors in currency operations.
- **Robust Security**: Stateless authentication using JWT and BCrypt password hashing.
- **Optimized Data Layer**: Custom JPQL queries for high-performance financial reporting (Total Expenses).
- **Clean Architecture**: Organized into `controller`, `service`, `repository`, `entity`, and `dto` layers for high maintainability.
- **Global Exception Handling**: Professional error management returning standardized JSON responses for better API UX.
- **Pagination**: Efficient transaction history listing using Spring Data `Pageable`.

## 📌 API Endpoints (Quick Reference)

| Method | Endpoint | Description | Auth |
| :--- | :--- | :--- | :--- |
| **POST** | `/api/users` | Register a new user (Auto-hashing password) | Public |
| **POST** | `/api/auth/login` | Authenticate and receive a JWT Token | Public |
| **POST** | `/api/transactions` | Create a new transaction (Income/Expense) | Private |
| **GET** | `/api/transactions` | List paginated transaction history | Private |
| **GET** | `/api/transactions/total-expenses/{userId}` | Get total expenses for a specific user | Private |

## ⚙️ How to Run
1. Clone the repository.
2. Configure your PostgreSQL database in `src/main/resources/application.properties`.
3. Run `./mvnw spring-boot:run` (or use your IDE).
4. The API will be available at `http://localhost:8080`.
