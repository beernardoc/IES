# Use a imagem base do OpenJDK 11 como imagem base
FROM openjdk:11-jre-slim

# Crie um diretório de trabalho no contêiner
WORKDIR /app

# Copie o JAR "fat" gerado pelo Maven (ajuste o nome do JAR conforme necessário)
COPY target/AnyCityForecast-1.0-SNAPSHOT.jar app.jar

# Comando para executar o aplicativo quando o contêiner for iniciado
ENTRYPOINT ["java", "-jar", "app.jar", "&"]
