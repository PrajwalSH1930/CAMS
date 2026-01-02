# 🎓 College Admission Management System (CAMS)

## 🧠 Project Overview

The **College Admission Management System (CAMS)** is a full-stack web application built using a **Spring Boot Microservices backend** and a **React (Vite) frontend**.  
It digitizes the college admission process by allowing students to apply online and administrators to manage courses and applications efficiently.

The system is designed with scalability and modularity in mind using **Spring Cloud, Eureka Service Discovery, and API Gateway**.

---

## 🏗️ System Architecture

### 🔹 Architecture Style
- Microservices-based backend
- Centralized API Gateway
- Service Discovery using Eureka
- React SPA frontend consuming REST APIs

```

Client (React)
|
API Gateway
|
-

|        |        |
Student  Course
Service  Service
|
Discovery Server

```

---

## 📂 Complete Project Structure

```

FINAL_PROJECT/
│
├── BACKEND/
│   ├── api-gateway/
│   ├── discoveryServer/
│   ├── student-service/
│   └── course-service/
│
├── FRONTEND/
│   ├── public/
│   ├── src/
│   ├── index.html
│   ├── package.json
│   ├── vite.config.js
│   └── eslint.config.js
│
└── README.md

````

---

## 🧩 Backend – Microservices Details

### 1️⃣ Discovery Server (`discoveryServer`)
- Built using **Netflix Eureka**
- Registers all microservices
- Enables dynamic service discovery

---

### 2️⃣ API Gateway (`api-gateway`)
- Built using **Spring Cloud Gateway**
- Acts as a single entry point for frontend requests
- Routes requests to backend microservices
- Handles CORS configuration

---

### 3️⃣ Student Service (`student-service`)
- Handles all student-related operations

**Responsibilities**
- Student registration
- Admission application handling
- Student data management

---

### 4️⃣ Course Service (`course-service`)
- Manages course and department data

**Responsibilities**
- Course listing
- Course creation and retrieval
- Course-related business logic

---

## 🗄️ Database Setup (MySQL)

Before running the backend services, ensure **MySQL** is installed and running.

### 🔹 Create Databases

Login to MySQL and execute the following commands:

```sql
CREATE DATABASE coursedb;
CREATE DATABASE studentdb;
````

### 🔹 Database Usage

| Microservice    | Database    |
| --------------- | ----------- |
| Course Service  | `coursedb`  |
| Student Service | `studentdb` |

> ⚠️ Make sure the database credentials (username, password, port) in each microservice’s `application.properties` match your local MySQL configuration.

---

## 🎨 Frontend – React (Vite)

The frontend is a **React Single Page Application** built using **Vite**, providing fast development and optimized builds.

---

## 🧱 Frontend Folder Structure

```
FRONTEND/
│
├── public/
│   └── vite.svg
│
├── src/
│   ├── assets/
│   ├── components/
│   │   ├── Students/
│   │   │   └── AdmissionApplication.jsx
│   │   └── Title/
│   │   |   ├── Title.jsx
│   │   |   └── Title.css
|   |   |__ ...
│   │
│   ├── pages/
│   │   ├── Home.jsx
│   │   ├── StudentDashboard.jsx
│   │   ├── AdminDashboard.jsx
│   │   └── HomePage/
│   │       └── HomePage.jsx
│   │
│   ├── App.jsx
│   ├── main.jsx
│   └── index.css
│
├── index.html
├── package.json
├── vite.config.js
└── eslint.config.js
```

---

## 🚀 How to Run the Project

### 🔧 Prerequisites

* Java 17+
* Maven
* Node.js (v18+)
* MySQL

---

## ▶️ Backend Startup Order (IMPORTANT)

### 1️⃣ Start Discovery Server

```bash
cd BACKEND/discoveryServer
mvn spring-boot:run
```

### 2️⃣ Start API Gateway

```bash
cd BACKEND/api-gateway
mvn spring-boot:run
```

### 3️⃣ Start Student Service

```bash
cd BACKEND/student-service
mvn spring-boot:run
```

### 4️⃣ Start Course Service

```bash
cd BACKEND/course-service
mvn spring-boot:run
```

---

## ▶️ Frontend Startup

```bash
cd FRONTEND
npm install
npm run dev
```

Frontend runs on:

```
http://localhost:5173
```

---

## 🔄 Application Flow

1. User interacts with React frontend
2. Requests are routed through API Gateway
3. API Gateway forwards requests to microservices
4. Services communicate using Eureka Discovery
5. Responses are sent back to the frontend

---

## 🧪 Testing

* Backend: Spring Boot Test
* API Testing: Postman
* Frontend: Manual UI testing

---

⭐ If you find this project useful, don’t forget to star the repository!
