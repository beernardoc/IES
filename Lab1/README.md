

# Lab 1

Autor: Bernardo Pinto

NMEC: 105926

##  1.1 Basic setup for Java development

**Atualizar versao do maven editando o .bashrc:**

- MAVEN_HOME=... (diretorio da pasta do maven-3.9.4)
- PATH=$MAVEN_HOME/bin:$PATH

**Código para criar um projeto maven na linha de comando:**

- $ mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

Onde:

**Archetype**: Um padrão ou modelo original do projeto

**GroupId**: Um nome unico que identifica o projeto, pode representar a empresa ou instituição

**ArtifactId**: Nome do ficheiro JAR



## 1.2 Build management with the Maven tool

Após a criação do Projeto utilizando o comando:

- $ mvn archetype:generate -DgroupId=pt.ua.deti -DartifactId=MyWeatherRadar-
DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

Onde: 

**GroupId**: pt.ua.deti

**ArtifactId**: MyWeatherRadar


Importa-se os códigos disponibilizados pelo regente para o consumo da API  e, em seguida, realiza as devidas alterações das dependencias do maven no POM.xml para o funcionamento correto da aplicação

**API:** http://api.ipma.pt/

**Implementação inicial:** https://gist.github.com/icoPT/8b378e03244d07e11645a97fa1857d7c

Em seguida compila e executa o projeto através da linha de comando:

- $ mvn package**

- mvn exec:java -Dexec.mainClass="pt.ua.deti.WeatherStarter"

*K)* Em seguida o código foi alterado para aceitar, através do arg da linha de comando, o ID da cidade desejada pelo cliente.

- ex) mvn exec:java -Dexec.mainClass="pt.ua.deti.WeatherStarter" -Dexec.args="100"

O utilizador quer que o programe retorne a informação referente a cidade 100.



## 1.3  Source code management using Git

Foi adicionado o projeto do Ex1.2 ao repositório do git, através de um clone local e os comandos básicos de git. Entre eles:

- git clone
- git pull
- git add
- git commit
- git push
- ...


## 1.4 Introduction to Docker

**set up the Docker repository:**

- sudo apt-get update
- sudo apt-get install ca-certificates curl gnupg
- sudo install -m 0755 -d /etc/apt/keyrings
- curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /etc/apt/keyrings/docker.gpg
- sudo chmod a+r /etc/apt/keyrings/docker.gpg

**Instalação do package:**

- sudo apt-get install ./docker-desktop-4.23.0-amd64.deb

**Abrindo Docker Desktop:**

- systemctl --user start docker-desktop

**Instalar Portainer CE com Docker e comandos importantes**

- docker volume create portainer_data
- docker run -d -p 8000:8000 -p 9443:9443 --name portainer --restart=always -v /var/run/docker.sock:/var/run/docker.sock -v portainer_data:/data portainer/portainer-ce:latest
- docker ps:

<pre>
CONTAINER ID   IMAGE                           COMMAND        CREATED          STATUS          PORTS                                                      NAMES
a698f35562d4   portainer/portainer-ce:latest   "/portainer"   19 minutes ago   Up 19 minutes   0.0.0.0:8000->8000/tcp, 0.0.0.0:9443->9443/tcp, 9000/tcp   portainer
</pre>





