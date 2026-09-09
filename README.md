
# Campus Food Pre-Order System

## 📌 Project Overview

Campus Food Pre-Order System is a web-based application developed to make food ordering easier and faster for students on campus.

The system allows students to view the available food menu, place food orders, make payments, track order status, and view their previous orders.

It also provides a daily sales report to help manage campus food orders efficiently.

---

## 🎯 Objectives

- Reduce waiting time at the campus canteen.
- Provide an easy online food ordering system.
- Manage food orders digitally.
- Maintain student, order, and payment records.
- Provide order status tracking.
- Generate daily sales reports.

---

## 🚀 Features

- Student Login
- View Food Menu
- Select Food Items
- Place Food Orders
- Calculate Total Amount
- Payment Processing
- Payment Status
- Order Status Tracking
- Order History
- Daily Sales Report

---

## 🛠️ Technologies Used

### Frontend
- HTML
- CSS
- JSP

### Backend
- Java
- Java Servlets
- JDBC

### Database
- MySQL

### Server
- Apache Tomcat

### Build Tool
- Maven

### IDE
- Eclipse

---

## 🏗️ Project Architecture

The project follows a simple layered architecture:

```text
User
  ↓
HTML / JSP / CSS
  ↓
Java Servlets
  ↓
DAO Layer
  ↓
JDBC
  ↓
MySQL Databasecampus-food-preorder-system
│
├── src
│   └── main
│       ├── java
│       │   └── com.codegnan.app
│       │       ├── dao
│       │       ├── model
│       │       ├── servlet
│       │       └── util
│       │
│       └── webapp
│           ├── index.html
│           ├── login.jsp
│           ├── menu.jsp
│           ├── placeOrder.jsp
│           ├── payment.jsp
│           ├── orderStatus.jsp
│           ├── orderHistory.jsp
│           ├── salesReport.jsp
│           └── WEB-INF
│               └── web.xml
│
├── pom.xml
└── README.md
Login
  ↓
View Menu
  ↓
Select Food
  ↓
Place Order
  ↓
Calculate Total
  ↓
Payment
  ↓
Order Confirmation
  ↓
Track Order
  ↓
View Order History
