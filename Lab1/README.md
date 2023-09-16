# Lab 1

Autor: Bernardo Pinto

NMEC: 105926

## 1.1 Configuração básica para desenvolvimento Java

**Atualizar a versão do Maven editando o .bashrc:**

- `MAVEN_HOME=...` (diretório da pasta do Maven-3.9.4)
- `PATH=$MAVEN_HOME/bin:$PATH`

**Comando para criar um projeto Maven na linha de comando:**

- `$ mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false`

Onde:

- **Archetype**: Um padrão ou modelo original do projeto.
- **GroupId**: Um nome único que identifica o projeto e pode representar a empresa ou instituição.
- **ArtifactId**: Nome do arquivo JAR.

## 1.2 Gerenciamento de build com a ferramenta Maven

Após a criação do projeto utilizando o comando:

- `$ mvn archetype:generate -DgroupId=pt.ua.deti -DartifactId=MyWeatherRadar -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false`

Onde:

- **GroupId**: pt.ua.deti
- **ArtifactId**: MyWeatherRadar

Importa-se os códigos disponibilizados pelo regente para o consumo da API e, em seguida, realiza as devidas alterações das dependências do Maven no POM.xml para o funcionamento correto da aplicação.

**API:** http://api.ipma.pt/

**Implementação inicial:** https://gist.github.com/icoPT/8b378e03244d07e11645a97fa1857d7c

Em seguida, compila e executa o projeto através da linha de comando:

- `$ mvn package`
- `$ mvn exec:java -Dexec.mainClass="pt.ua.deti.WeatherStarter"`

### K) Alterando a implementação para receber o código da cidade como um parâmetro na linha de comando e imprimir as informações da previsão de forma mais completa e amigável ao usuário.

- Exemplo: `mvn exec:java -Dexec.mainClass="pt.ua.deti.WeatherStarter" -Dexec.args="100"`

Isso permitirá que o usuário receba informações sobre a cidade com o código 100.

## 1.3 Gerenciamento de código-fonte usando Git

**Foi adicionado o projeto do Ex1.2 ao repositório do Git, através de um clone local e os comandos básicos do Git. Entre eles:**

- `git clone`
- `git pull`
- `git add`
- `git commit`
- `git push`
- ...

## 1.4 Introdução ao Docker

**Configurando o repositório do Docker:**

- `sudo apt-get update`
- `sudo apt-get install ca-certificates curl gnupg`
- `sudo install -m 0755 -d /etc/apt/keyrings`
- `curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /etc/apt/keyrings/docker.gpg`
- `sudo chmod a+r /etc/apt/keyrings/docker.gpg`

**Instalação do pacote:**

- `sudo apt-get install ./docker-desktop-4.23.0-amd64.deb`

**Iniciando o Docker Desktop:**

- `systemctl --user start docker-desktop`

**Instalando o Portainer CE com Docker e comandos importantes:**

- `docker volume create portainer_data`
- `docker run -d -p 8000:8000 -p 9443:9443 --name portainer --restart=always -v /var/run/docker.sock:/var/run/docker.sock -v portainer_data:/data portainer/portainer-ce:latest`
- `docker ps`



<pre>
CONTAINER ID   IMAGE                           COMMAND        CREATED          STATUS          PORTS                                                      NAMES
a698f35562d4   portainer/portainer-ce:latest   "/portainer"   19 minutes ago   Up 19 minutes   0.0.0.0:8000->8000/tcp, 0.0.0.0:9443->9443/tcp, 9000/tcp   portainer
</pre>




### Múltiplos serviços (Docker Compose)

Primeiro, foram implementados 4 arquivos:

- `app.py`
- `requirements.txt`
- `Dockerfile`
- `docker-compose.yaml`

Em seguida, foi adicionado ao `docker-compose.yaml` código para realizar o *bind mount*.

- *Bind mount*: Isso garante que o processo de reconstrução não seja necessário. Ou seja, quando o código-fonte for alterado, ele será imediatamente atualizado para o cliente.






