# quarkus-hello-app

Here's an updated version of the README with the `curl` testing instructions:

---

# Quarkus Hello App

This repository contains a simple **Quarkus-based application** that demonstrates a basic "Hello" service using a **POST** method.

## Features
- A simple REST endpoint that accepts a POST request.
- Demonstrates Quarkus framework for building Java microservices.

## Getting Started

### Prerequisites
Ensure you have the following installed:
- Java 11 or later
- Maven
- Docker (optional, for containerization)

### Running the Application
1. Clone the repository:
   ```bash
   git clone https://github.com/paulomenon/quarkus-hello-app.git
   cd quarkus-hello-app
   ```
2. Run the application using Maven:
   ```bash
   ./mvnw quarkus:dev
   ```
   The application will be available at [http://localhost:8080](http://localhost:8080).

3. Optionally, build a Docker image:
   ```bash
   ./mvnw clean package -Dquarkus.profile=prod
   docker build -f src/main/docker/Dockerfile.native -t quarkus-hello-app .
   ```

## Test with cURL
You can test the application using the following `curl` command:

```bash
curl -X POST http://localhost:8080/welcome \
-H "Content-Type: application/json" \
-d '{"name": "Quarkus Meetup", "location": "San Francisco"}'
```

## Endpoints
- **POST /welcome** - Accepts a POST request and returns a Welcome message.
- **GET /thanks** - Accepts a GET request and returns a Thank you to our amazing organiser: {app.sponsor}

## License
This project is licensed under the MIT License.

---

Feel free to adapt further!