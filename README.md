# 💬 Customer Feedback System

### 👨‍💻 Developed by: Prem R  
### 🧰 Tech Stack: Java | MySQL | JDBC | JUnit | Exception Handling | Logging

---

## 📘 Overview
The **Customer Feedback System** is a Java and MySQL-based application designed to collect, manage, and analyze customer feedback for different products.  
It performs all **CRUD operations** (Create, Read, Update, Delete) on customers, products, and feedback modules, ensuring smooth and efficient data handling.  
The project uses **exception handling**, **logging**, and **unit testing** to maintain reliability and prevent runtime issues.

---

## 🎯 Objectives
- To build a system that records and manages customer feedback efficiently.  
- To implement CRUD operations for customers, products, and feedback.  
- To use **MySQL** for secure data storage and retrieval.  
- To include **logging** and **exception handling** for better debugging and stability.  
- To validate system functions using **JUnit test cases**.

---

## ⚙ Features
- ➕ Add, ✏ Update, ❌ Delete, and 👁 View customers, products, and feedback  
- 🔗 Database connectivity using MySQL (JDBC)  
- 🧾 Exception handling for error management  
- 🧠 Logging to track operations  
- 🧪 JUnit test cases for CRUD operation validation  

---

## 🧩 ER Diagram
**Entities:**
- Customer(customer_id, name, email, phone, gender, created_at)
- Product(product_id, name, description, price, created_at)
- Feedback(feedback_id, message, rating, feedback_date, customer_id, product_id)

**Relationships:**
- One customer can give feedback for many products  
- One product can have multiple feedbacks from different customers

---

## 🧪 Test Case Summary
| Test Case | Description | Expected Result | Status |
|------------|-------------|-----------------|---------|
| Add Customer | Insert new customer data | Record inserted | ✅ Pass |
| Update Product | Modify existing product details | Record updated | ✅ Pass |
| Delete Feedback | Remove invalid feedback entry | Record deleted | ✅ Pass |
| View All | Fetch complete data from database | Records displayed | ✅ Pass |

---

## 🖥 Sample Console Output

**=== Welcome to Customer Feedback System ===**

[2025-11-03 10:25:45] [INFO] Database Connected Successfully!
[2025-11-03 10:25:46] [INFO] Customer Inserted Successfully!

Customer{id=1, name='Tonystark', email='tony@gmail.com', phone='7896541032', gender='Male', createdAt=2025-11-03 10:25:46.000}

💬 *This output confirms a successful database connection and insertion operation with timestamped logs.*  
💡 *LoggerUtil automatically generates log timestamps for tracking and debugging.*

---

## 🚀 Future Enhancements
- Implement an **Admin Dashboard** for report generation  
- Add **Sentiment Analysis** for customer feedback  
- Develop a **Web-based interface** using Spring Boot or JSP  

---

## 🏁 Conclusion
The **Customer Feedback System** efficiently manages customer and product data with feedback tracking using Java and MySQL.  
It ensures reliability through proper testing, exception handling, and logging, making it a robust foundation for future enhancements.

---

### 📚 Author
**Prem R**  
*Customer Feedback System | Java, MySQL, JUnit, Exception Handling*
