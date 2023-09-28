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

...