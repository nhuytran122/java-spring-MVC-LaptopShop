# Laptop Shop Web Application

## Overview

This is a **Laptop Shop Web Application** developed using **Java Spring MVC**, designed to provide a platform for users to browse, view, and purchase laptops online. The application includes essential features such as filtering products, viewing product details, shopping cart, user authentication, and order management. It also features an **Admin Panel** for managing products, users, and orders, with authentication and role-based authorization for different user types (Admin, User).

## Features

- **Product Catalog:** Display a list of available laptops with details such as name, brand (factory), target,details description, short description, price and image. Includes filtering options for better product search.
- **Product Details:** Users can view detailed information about each laptop.
- **Shopping Cart:** Allows users to add, update, and remove products from the cart, and proceed to checkout.
- **User Authentication & Authorization:** Users can register, login, and manage their accounts. Spring Security is used for user authentication and role-based access control (Admin, User).
- **Order Management:** Customers can place orders, and track order status.
- **Admin Panel:** Admins can manage products, view and manage orders, and control user access. Admins have elevated privileges compared to regular users.

## Technologies Used

- **Backend Framework:** Java Spring MVC
- **Database:** MySQL
- **View Layer:** JSP (JavaServer Pages) for dynamic rendering of pages.
- **Frontend:** HTML, CSS, JavaScript.
- **Authentication & Authorization:** Spring Security for user authentication and role-based authorization
- **Dependency Management:** Maven

## Getting Started

To run this project locally, follow these steps:

### Prerequisites

- Java 8 or higher
- MySQL Server
- Apache Maven
- IDE (Visual Studio Code, Eclipse, IntelliJ IDEA, etc.)

### Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/nhuytran122/java-spring-mvc-LaptopShop.git
   ```

2. **Set up the MySQL database:**

   Create a MySQL database named `laptopshop` and run the provided SQL script to set up the schema and sample data.

3. **Configure application.properties:**

   In `src/main/resources/application.properties`, configure your database connection settings:

   ```properties
   server.port=8081
   spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/laptopshop
   spring.datasource.username=root
   spring.datasource.password=your_password
   ```

4. **Build the project:**

   Use Maven to build the project:

   ```bash
   mvn clean install
   ```

5. **Run the Application:**

   After building the project, run the application by using your IDE or by running the following Maven command:

   ```bash
   mvn spring-boot:run
   ```

   Or, you can install the `Spring Boot Extension Pack` in Visual Studio Code (VS Code) to simplify development. The extension provides features like running the application directly from VS Code, debugging, and Spring-specific tools.

   **Steps to Install Spring Boot Extension Pack:**
      - Open Visual Studio Code.
      - Go to the Extensions Marketplace (Ctrl + Shift + X).
      - Search for Spring Boot Extension Pack.
      - Click Install.
      Once installed, open the project in VS Code, and you can run the application using the Spring Boot Dashboard in the side panel.

6. **Access the Application:**

   Open your browser and navigate to `http://localhost:8081` to view the application.

## Note

This source code is created as part of a learning project to understand and practice **Java Spring MVC** development. It is based on content from an educational course and is intended for **learning purposes only**. It may not follow all best practices for professional development.
