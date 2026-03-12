# Use official Java image
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Build the project
RUN ./mvnw clean package -DskipTests

# Run the jar
CMD ["java", "-jar", "target/client-0.0.1-SNAPSHOT.jar"]