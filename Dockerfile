FROM eclipse-temurin:17-jdk-alpine

# 1. Primero copia solo el mvnw y .mvn para cachear dependencias
COPY --chmod=755 mvnw .
COPY .mvn .mvn
COPY pom.xml .

# 2. Dale permisos explícitos (segunda capa de protección)
RUN chmod +x mvnw

# 3. Descarga dependencias (cachea este paso)
RUN ./mvnw dependency:go-offline

# 4. Ahora copia el resto del código
COPY src src

# 5. Construye la aplicación
RUN ./mvnw clean package

# 6. Comando de ejecución
CMD ["java", "-jar", "target/*.jar", "--spring.profiles.active=prod"]