# Use a imagem base do OpenJDK 11
FROM openjdk:11

# Defina o diretório de trabalho como /app
WORKDIR /app

# Copie o arquivo JAR compilado para o diretório /app
COPY target/AnyCityForecast-1.0-SNAPSHOT.jar /app/AnyCityForecast-1.0-SNAPSHOT.jar

# Comando para executar o aplicativo Java
CMD ["java", "-jar", "AnyCityForecast-1.0-SNAPSHOT.jar"]
