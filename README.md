![Logo Spring Boot](https://img.icons8.com/?size=80&id=A3Ulk2RcONKs&format=png)

#  Spring Boot URL Shortener

A URL shortener service built with Spring Boot, JPA, and MySQL. It allows users to convert long URLs into shorter, shareable links and redirects them accordingly.

## 🚀 Features

- Generate a short link from a long URL
- Temporary expiration of shortened URLs (default: 1 minute)
- Redirect to original URL via short code
- Returns HTTP `404` if the short URL is not found, or HTTP `410` if it has expired.
- Swagger UI integration for API documentation

## 📦 Technologies Used

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL (via Docker)
- Swagger (Springdoc OpenAPI)

## 🛠️ Setup Instructions

### Prerequisites

- Java 17+
- Docker and Docker Compose
- Maven

### Clone and Run

- git clone https://github.com/willianpicao/willianpicao-springboot-url-shortener.git
- cd willianpicao-springboot-url-shortener
- Go to the docker folder and start the containers
- docker-compose up -d
- Go back to the project root to run the Spring Boot app
- Run the Spring Boot application
- .\mvnw.cmd spring-boot:run

The app will start on: http://localhost:8080

# 📚 API Endpoints
## POST /shorten-url
Shortens a URL.

Request Body
```bash
{
  "url": "https://example.com/some/very/long/path"
}
```
Response
```bash
http://localhost:8080/DXB6V
```
## GET /{shortCode}
Redirects to the original URL.

If expired or not found, returns HTTP 404

# 📖 Swagger Documentation
Once the application is running, access:

```bash
http://localhost:8080/swagger-ui.html
```
