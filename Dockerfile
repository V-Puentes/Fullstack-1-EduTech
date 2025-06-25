FROM eclipse-temurin:17-jdk-alpine
COPY . /app
WORKDIR /app
RUN ./mvnw clean package
CMD ["java", "-jar", "target/*.jar", "--spring.profiles.active=prod"]