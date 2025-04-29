# Bank Record System

## Introduction

This Bank Record System is a basic microservice developed using Java and Spring Boot. It handles user creation and retrieval using a clean architecture pattern. The project is structured based on Domain-Driven Design (DDD) principles to promote maintainability, scalability, and clarity.

## Why Domain-Driven Design (DDD)?

Domain-Driven Design (DDD) helps in separating business logic from infrastructure and presentation concerns. In this system:

- **Domain layer** contains core entities (`User`).
- **Repository layer** abstracts data access.
- **Service layer** holds business logic like user creation and retrieval.
- **Application layer** wires the system with Spring Boot configuration and runtime setup.

By applying DDD, this project becomes easier to test, modify, and scale.
