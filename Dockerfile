# Runtime base image supporting ARM64 (Apple Silicon) & AMD64
FROM eclipse-temurin:21-jre-alpine

# Set working directory
WORKDIR /app

# Run as non-root user for security best practices
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copy built JAR from target directory
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Expose service port
EXPOSE 8081

# Configure JVM options & run application
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
