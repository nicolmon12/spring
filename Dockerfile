# ================================
# Etapa 1: Construcción del JAR
# ================================
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copiar pom.xml primero para aprovechar caché de dependencias
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar el código fuente y compilar
COPY src ./src
RUN mvn clean package -DskipTests

# ================================
# Etapa 2: Imagen final de ejecución
# ================================
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copiar el JAR generado
COPY --from=build /app/target/*.jar app.jar

# Puerto que usa Render (se pasa como variable PORT)
EXPOSE 10000

# Ejecutar la aplicación tomando el puerto de Render
ENTRYPOINT ["java", "-jar", "-Dserver.port=${PORT:-10000}", "app.jar"]
