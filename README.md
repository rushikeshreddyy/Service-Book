# Service Booking Backend Application

This project is a backend service built using **Java and Spring Boot** to support booking requests across multiple service providers.  
The goal of the application is to handle real-time booking requests efficiently while maintaining scalability and reliability under concurrent user load.

The system follows a reactive and event-driven approach to process requests asynchronously and improve overall system performance.

---

## Features

- Service booking with multiple providers
- First-come, first-serve provider assignment logic
- Reactive and non-blocking request handling using Spring WebFlux
- Event-driven communication using Apache Kafka
- Redis caching to reduce database load and improve response time
- RESTful APIs for client interaction
- Designed to support high concurrency and fault tolerance

---

## Tech Stack

- **Language:** Java  
- **Framework:** Spring Boot (WebFlux)  
- **Messaging:** Apache Kafka  
- **Caching:** Redis  
- **Database:** PostgreSQL  
- **Build Tool:** Maven  
- **Containerization:** Docker  

---

## System Overview

When a booking request is received, the application validates provider availability and assigns a provider based on a first-come, first-serve strategy.  
Booking events are published through Kafka to enable asynchronous processing, while Redis caching minimizes repeated database queries and improves latency.

The reactive architecture allows the system to efficiently manage multiple simultaneous requests without blocking threads.

---

## Future Improvements

- Develop a React-based frontend to provide an intuitive booking interface
- Implement authentication and role-based access control

## Running the Application

### Clone the repository
```bash
git clone https://github.com/your-username/service-booking-backend.git
cd service-booking-backend
