# Usando uma imagem leve do OpenJDK
FROM openjdk:17-jdk-slim

# Configura o diretório de trabalho
WORKDIR /app

# Copia o arquivo JAR da sua API para o contêiner
COPY target/*.jar app.jar

# Define um usuário não-root para maior segurança
RUN useradd -m kciao
USER kciao

# Exponha a porta onde a API estará rodando (exemplo: 8080)
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]
