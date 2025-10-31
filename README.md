# 📝 To-Do List (Spring Boot REST API)

This is a **Spring Boot REST API** for a simple To-Do List application.
It allows users to perform basic **CRUD operations** — *Create, Read, Update,* and *Delete* tasks.

> ⚡ All data is stored **in-memory** (using a Java `ArrayList`) and will be lost when the application stops.

---

## 🚀 Features

* ✅ Create new tasks
* 📋 View all tasks
* 🔍 Get task details by ID
* ✏️ Update existing tasks
* ❌ Delete tasks
* ⚙️ Built with **Spring Boot** and **Java 17**

---

## 🧩 Tech Stack

* **Java 17**
* **Spring Boot 2.7.18**
* **Spring Web (REST APIs)**
* **Maven** for build and dependency management

---

## 📁 Project Structure

```
todolist/
├── src/
│   ├── main/
│   │   ├── java/com/example/todolist/
│   │   │   ├── Todo.java
│   │   │   └── TodoController.java
│   │   └── resources/
│   │       └── application.properties
├── pom.xml
└── README.md
```

---

## ⚙️ How to Run the Project

### 1. Clone the repository

```bash
git clone https://github.com/<your-username>/todolist.git
cd todolist
```

### 2. Build and run the application

```bash
mvn spring-boot:run
```

### 3. Access the API

Once started, the app runs on:
👉 `http://localhost:8080`

---

## 🧠 API Endpoints

| Method     | Endpoint          | Description             |
| ---------- | ----------------- | ----------------------- |
| **POST**   | `/api/todos`      | Create a new To-Do item |
| **GET**    | `/api/todos`      | Get all To-Do items     |
| **GET**    | `/api/todos/{id}` | Get a To-Do by ID       |
| **PUT**    | `/api/todos/{id}` | Update a To-Do item     |
| **DELETE** | `/api/todos/{id}` | Delete a To-Do by ID    |

---

## 📬 Example JSON

### Create a new To-Do

**Request:**

```json
POST /api/todos
{
  "title": "Learn Spring Boot",
  "description": "Build a simple REST API"
}
```

**Response:**

```json
{
  "id": 1,
  "title": "Learn Spring Boot",
  "description": "Build a simple REST API",
  "completed": false
}
```

---

## 🧹 Notes

* Data is stored temporarily in an in-memory list.
* When the application restarts, all tasks are cleared.
* Ideal for beginners to understand **Spring Boot REST API basics** without database setup.

---
