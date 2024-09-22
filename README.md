# Product Service - E-commerce Microservice

Note: Please refer all these repos for the complete project 
https://github.com/sahudev/scalerProjectUserService; 
https://github.com/sahudev/scalerProjectPaymentService; 
https://github.com/sahudev/scalerProjectProductService; 
https://github.com/sahudev/scalerProjectEmailService;

## Overview
This repository contains the **Product Service** for an e-commerce application, developed as part of a microservices-based architecture. The Product Service handles all product-related operations such as adding, updating, deleting, and retrieving product information.

It is built using **Spring Boot** for rapid development, scalability, and integration with other microservices in the application.

## Features
- Add new products with details like name, price, category, description, and stock quantity.
- Retrieve product information by ID, category, or name.
- Update product details (price, availability, description, etc.).
- Delete products from the catalog.
- List all products or filter by category.
  
## Technologies Used
- **Java 11**: Core language for the backend services.
- **Spring Boot**: Framework for building the microservice architecture.
- **Spring Data JPA**: To interact with the database using ORM (Object-Relational Mapping).
- **MySQL**: Database used for storing product information.
- **Docker**: For containerization and easy deployment.
- **AWS RDS**: Relational database hosted on AWS.
- **Redis (Elasticache)**: For caching frequently accessed product data to improve performance.

## Project Structure
The service follows a typical **Spring Boot MVC architecture** with the following layers:
- **Controller**: Handles API requests (HTTP methods like GET, POST, PUT, DELETE) and interacts with the service layer.
- **Service**: Contains business logic for managing product-related operations.
- **Repository**: Interfaces with the database to persist and retrieve product data.
- **Model**: Represents the `Product` entity that is mapped to the database.

## API Endpoints

### Product Endpoints:
1. **Get All Products**
   - `GET /products`
   - Retrieve all available products in the system.

2. **Get Product by ID**
   - `GET /products/{id}`
   - Retrieve a specific product by its ID.

3. **Add Product**
   - `POST /products`
   - Create a new product by providing details in the request body.

4. **Update Product**
   - `PUT /products/{id}`
   - Update details of an existing product using its ID.

5. **Delete Product**
   - `DELETE /products/{id}`
   - Remove a product from the catalog using its ID.

## Installation

### Prerequisites:
- **Java 11** or higher
- **Maven** for dependency management
- **MySQL** for the database (local or hosted)
- **Docker** (optional) for containerized deployment

### Steps to Set Up Locally:
1. **Clone the repository**:
   ```bash
   git clone https://github.com/sahudev/scalerProjectProductService
   ```

2. **Configure the Database**:
   - Update the `application.properties` file with your MySQL database connection details:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/products_db
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     ```

3. **Run the Application**:
   Navigate to the root folder and run:
   ```bash
   mvn spring-boot:run
   ```

4. **Access the API**:
   Once the application is running, access the APIs using a tool like **Postman** or **curl**:
   - Example to get all products:
     ```bash
     curl -X GET http://localhost:8080/products
     ```

### Docker Deployment:
You can use Docker to containerize the application for easy deployment. A `Dockerfile` is provided in the repository:
1. Build the Docker image:
   ```bash
   docker build -t product-service .
   ```

2. Run the container:
   ```bash
   docker run -p 8080:8080 product-service
   ```

## AWS Deployment
For cloud deployment, this service can be hosted using **AWS EC2** or **AWS Elastic Beanstalk**, and connected to **AWS RDS** for the database. Ensure that security groups, load balancing, and VPC configurations are properly set up for secure access and scalability.

## Contribution
Feel free to raise issues or create pull requests if you'd like to contribute. All contributions and improvements are welcome!
