# Multi-stage build
FROM eclipse-temurin:17-jdk-focal AS builder

# Copy source code and build files
#COPY . /app
#WORKDIR /app

# Build the JAR file
#RUN ./mvnw clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:17-jdk-focal

# Copy the built JAR from builder stage
COPY --from=builder /app/target/projects-0.0.1-SNAPSHOT.jar app.jar

# Expose app port
EXPOSE 8080

# Defines command to execute
ENTRYPOINT ["java", "-jar", "app.jar"]