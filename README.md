# 🏦 DDD + Orchestration-Based Banking System

This project demonstrates a simple banking system architecture using **Domain-Driven Design (DDD)** principles combined with an **Orchestration**-based service coordination approach. The system includes modular services for users, accounts, transactions, and notifications, along with scalable deployment and testing strategies.

---

## Introduction

This Bank Record System is a basic microservice developed using Java and Spring Boot. It handles user creation and retrieval using a clean architecture pattern. The project is structured based on Domain-Driven Design (DDD) principles to promote maintainability, scalability, and clarity.

## Why Domain-Driven Design (DDD)?

Domain-Driven Design (DDD) helps in separating business logic from infrastructure and presentation concerns. In this system:

- **Domain layer** contains core entities (`User`).
- **Repository layer** abstracts data access.
- **Service layer** holds business logic like user creation and retrieval.
- **Application layer** wires the system with Spring Boot configuration and runtime setup.

By applying DDD, this project becomes easier to test, modify, and scale.

## 🧩 Service Summary

### 🔷 DDD Layer
- **UserService**
  - Create & Get User
  - Unit tested
- **AccountService**
  - Create Account & View Balance
  - Unit tested

### 🔷 Orchestration Layer
- **TransactionService**
  - Transfer Money
  - Unit tested
- **NotificationService**
  - Send Email/SMS
  - Unit tested

---

## 🖼️ Diagrams

All diagrams are available under `/docs/diagrams`:

- ✅ DDD Component Diagram
- ✅ DDD Package Diagram
- ✅ Orchestration Component Diagram
- ✅ Orchestration Package Diagram
- ✅ Deployment Diagram
- ✅ Data Flow Diagram (DFD)

---

## 🧪 Testing Instructions

Unit tests are implemented using **Jest**. To run tests:

```bash
npm install
npm run test
```


## 🚀 Run Instructions
🐳 Using Docker (Recommended)
Build and run the app in a container:
```bash
docker build -t banking-app .
docker run -p 3000:3000 banking-app
```
