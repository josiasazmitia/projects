# Projects Application

A Spring Boot application with JWT authentication, PostgreSQL database, and Docker support.

## Features

- Spring Boot 3.5.4
- Spring Security with JWT authentication
- PostgreSQL database with Flyway migrations
- OpenAPI/Swagger documentation
- Docker containerization
- Lombok for reduced boilerplate

## Prerequisites

- Java 17
- Maven 3.6+
- Docker and Docker Compose
- PostgreSQL (if running locally without Docker)

## Setup Instructions

### 1. Clone the Repository

```bash
git clone <repository-url>
cd projects
```

### 2. Environment Configuration

The application is configured to connect to PostgreSQL. Update `src/main/resources/application.properties` if needed:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/myprojectdb
spring.datasource.username=myuser
spring.datasource.password=mypassword
```

### 3. Build the Application

```bash
# Using Maven wrapper (recommended)
./mvnw clean package

# Or using system Maven
mvn clean package
```

### 4. Running with Docker Compose

The easiest way to run the application with PostgreSQL:

```bash
docker-compose up -d
```

This will start:
- PostgreSQL database on port 5432
- The Spring Boot application on port 8080

### 5. Running Locally

If you prefer to run without Docker:

1. Start PostgreSQL and create the database:
```sql
CREATE DATABASE myprojectdb;
CREATE USER myuser WITH PASSWORD 'mypassword';
GRANT ALL PRIVILEGES ON DATABASE myprojectdb TO myuser;
```

2. Run the application:
```bash
./mvnw spring-boot:run
```

## Docker Commands

### Build Docker Image

```bash
docker build -t projects .
```

### Run Docker Container

```bash
# Run the application container (requires PostgreSQL running)
docker run -p 8080:8080 projects

# Run with environment variables
docker run -p 8080:8080 \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/myprojectdb \
  -e SPRING_DATASOURCE_USERNAME=myuser \
  -e SPRING_DATASOURCE_PASSWORD=mypassword \
  projects
```

### Docker Compose

```bash
# Start all services
docker-compose up -d

# Stop all services
docker-compose down

# View logs
docker-compose logs -f

# Rebuild and restart
docker-compose up -d --build
```

## API Documentation

Once the application is running, access the API documentation at:

- Swagger UI: http://localhost:8080/swagger-ui.html
- OpenAPI JSON: http://localhost:8080/v3/api-docs

## Development

### Running Tests

```bash
./mvnw test
```

### Code Style

The project uses Lombok to reduce boilerplate code. Make sure your IDE has Lombok plugin installed.

### Database Migrations

The project uses Flyway for database migrations. Migration files should be placed in `src/main/resources/db/migration/`.

## Troubleshooting

### Common Issues

1. **Port already in use**: Make sure port 8080 is not being used by another application
2. **Database connection failed**: Ensure PostgreSQL is running and credentials are correct
3. **Build fails**: Ensure Java 17 is installed and JAVA_HOME is set correctly

### Logs

Check application logs for detailed error information:

```bash
# Docker Compose logs
docker-compose logs app

# Docker container logs
docker logs <container-id>
```

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Run tests
5. Submit a pull request