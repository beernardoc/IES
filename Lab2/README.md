# Lab 2 - Notes

Autor: Bernardo Pinto

NMEC: 105926


## 2.1 Server-side programming with servlets

- Inicialmente foram adicionados ao POM.xml as dependências jetty-server e jetty-servlet

```xml

<dependency>
                <groupId>org.eclipse.jetty</groupId>
                <artifactId>jetty-server</artifactId>
                <version>9.2.15.v20160210</version>
</dependency>
<dependency>
                <groupId>org.eclipse.jetty</groupId>
                <artifactId>jetty-servlet</artifactId>
                <version>9.2.15.v20160210</version>
 </dependency>

```

- A) Foram implementados os exemplos #3.4 e #3.5 do https://examples.javacodegeeks.com/java-development/enterprise-java/jetty/embedded-jetty-server-example/

- B) Em seguida foram feitas as alterações necessárias para que o programa aceitasse uma mensagem a partir da URL, que caso não fosse passada, retornaria uma mensagem padrão "New Hello Simple Servlet"

```url
http://127.0.0.1:8680 (retorna "New Hello Simple Servlet")

http://127.0.0.1:8680/?msg="IES 2023" (retorna "IES 2023")
```


## 2.2 Server-side programming and application servers (Tomcat)

- Inicialmente foi criado um projeto JakartEE com o nome "Lab2_2" e adicionado ao POM.xml as dependências do Tomcat
- Em seguida foi feita a compilação e build do projeto, para que dessa forma fosse criado o ficheiro `JakartaWebStarter-1.0-SNAPSHOT.war` que será utilizado para o deploy no Tomcat.
- Posteriormente, foi implementado o ficheiro [docker-compose](Ex2_2/JakartaWebStarter/docker-compose.yml) que permite a criação de um container com o Tomcat e o deploy do ficheiro .war criado anteriormente. Vale ressaltar que a "image" do tomcat foi retirada do dockerhub e especificada no arquivo.
- Por fim, o container foi executado e foi possível aceder ao servidor através do link http://localhost:8080/JakartaWebStarter-1.0-SNAPSHOT/


## 2.3 Introduction to web apps with a full-featured framework (Spring Boot)

### a) Spring Initializr: 

- Para começar o desenvolvimento do projeto, foi utilizada a interface do IntelliJ para criar um projeto com o Spring Initializr e o Maven, que permite a criação de um projeto com as dependências que o utilizador desejar. Neste caso, foram adicionadas as dependências para o desenvolvimento Web.
- Em seguida, foi feita a compilação e build do projeto, para que dessa forma, fosse criado o arquivo necessário para executar o comando `./mvnw spring-boot:run` e iniciar o servidor, acessível através do link [http://localhost:8080/](http://localhost:8080/) (white label error).

### b) Simple Application with Spring Boot

O desenvolvimento do exercício 2.3b foi feito com base no tutorial disponibilizado neste [artigo](https://spring.io/guides/gs/serving-web-content/).

- Foi utilizado o Spring Initializr para criar um projeto Maven com as dependências necessárias, incluindo a dependência para desenvolvimento Web, o Thymeleaf e o DevTools.
- Em seguida, foi desenvolvido o Controller [GreetingController](Ex2_3/2_3B/serving-web-content/src/main/java/com/example/servingwebcontent/GreetingController.java). No controller, foi implementada a anotação `@GetMapping("/greeting")` para o método `greeting()`, permitindo que o método processe as solicitações HTTP GET para a rota especificada.
- Além disso, no método `greeting()`, foi implementada a anotação `@RequestParam(name="name", required=false, defaultValue="World")`, que permite a inserção de um parâmetro na URL, assumindo o valor padrão "World" caso não seja inserido.
- Posteriormente, foi desenvolvido o arquivo [greeting.html](Ex2_3/2_3B/serving-web-content/src/main/resources/templates/greeting.html), que permite a visualização do resultado do método `greeting()` no navegador, através do Thymeleaf.
- Então foi feita a compilação e build do projeto para criar o arquivo necessário para executar o comando `./mvnw spring-boot:run` e iniciar o servidor.

Exemplos de URLs:

- [http://localhost:8080/greeting](http://localhost:8080/greeting) (retorna "Hello World").
- [http://localhost:8080/greeting?name=IES](http://localhost:8080/greeting?name=IES) (retorna "Hello IES").

#### Página Inicial (Home Page):

- Por fim, o artigo pede que seja desenvolvida uma página inicial que seja capaz de redirecionar para a rota `/greeting`. Para isso, foi desenvolvido o arquivo `index.html`:

```html
<!DOCTYPE HTML>
<html>
<head>
    <title>Getting Started: Serving Web Content</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<p>Get your greeting <a href="/greeting">here</a></p>
</body>
</html>
```

**Nota:** Adiona-se o arquivo `index.html` na rota `static` para que o Spring Boot encontre o arquivo e utilize como página inicial.

### C) JSON result

...