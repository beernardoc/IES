# Lab 3 - Notes

Autor: Bernardo Pinto

NMEC: 105926


## 3.1 Accessing databases in SpringBoot

**Inicialmente foi criado um projeto SpringBoot com o Spring Initializr e foram importadas as seguintes dependências: Web, JPA, Thymeleaf, H2 e validation.**


- JPA: Java Persistence API, permite a persistência de dados em bases de dados relacionais, nesse caso, a base de dados H2.
- H2: Base de dados relacional em memória, que permite a persistência de dados.
- Thymeleaf: Template engine que permite a criação de páginas HTML dinâmicas.
- Validation: Permite a validação de dados.

### C) Walkthrough the available solution and answers these questions:

**1. The `"UserController"` class gets an instance of `“userRepository”` through its constructor; how is this new repository instantiated?**

Resumidamente,  o UserRepository é uma interface que define operações de persistência de dados e não precisa ser instanciada manualmente. Quando você precisa usá-lo em seu aplicativo, o Spring injetará automaticamente uma instância concreta desse repositório em componentes que dependem dele.


**2. List the methods invoked in the `“userRepository”` object by the `“UserController”`. Where are these methods defined?**


- `findAll()`: Retorna todos os usuários.
- `findById()`: Retorna o usuário com o id especificado.
- `save()`: Salva o usuário especificado.
- `delete()`: Deleta o usuário especificado.

Estes métodos são definidos na classe CrudRepository e que é implementada pela interface UserRepository do projeto.

**3. Where is the data being saved?**

Nesse caso a base de dados H2 está a ser usada para guardar os dados. Vale ressaltar que a base de dados está a ser usada em memória, ou seja, quando o programa é terminado os dados são perdidos.

**4. Where is the rule for the “not empty” email address defined?**

A regra para obrigatoriedade de preenchimento do email é definida na classe User, através da anotação `@NotBlank`:
 

```java
@NotBlank(message = "Email is mandatory")
private String email;
```
*Nota: A anotação `@NotBlank` só funciona com Strings, para outros tipos de dados deve ser usada a anotação `@NotNull`.*


## 3.2 Accessing databases in SpringBoot

**Primeiramente foi criado o Container Docker com a base de dados MySQL, através do comando:**

```bash
$ docker run --name mysql5 -e MYSQL_ROOT_PASSWORD=secret1 -e MYSQL_DATABASE=demo -e MYSQL_USER=demo -e MYSQL_PASSWORD=secret2 -p 33060:3306 -d mysql/mysql-server:8.0.34
```

**A base de dados pode ser acedida através do comando:**

```bash
$ docker exec -it mysql5 bash
```

**Em seguida foi criado um projeto SpringBoot com o Spring Initializr e foram importadas as seguintes dependências: Web, JPA, MySQL, DevTools e validation.**


**Então foi criada a entidade `Employee`, o controller `EmployeeController`, o repositório `EmployeeRepository` e 'EmployeeService' que implementa a interface `EmployeeServiceInterface` e permite a comunicação entre o controller e o repositório.**

**Já no ficheiro `application.properties` foram definidas as configurações da base de dados:**

```properties
# MySQL
spring.datasource.url=jdbc:mysql://127.0.0.1:33060/demo
spring.datasource.username=demo
spring.datasource.password=secret2
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
# Strategy to auto update the schemas (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto = update
``` 

### G) Para testar a aplicação utilizei o curl para fazer os pedidos HTTP, por exemplo:

**1. List all employees:**

```bash 
$ curl -X GET http://localhost:8080/api/employees
```

**2. Create a new employee:**

```bash
$ curl -X POST -H "Content-Type: application/json" -d '{"name": "Bernardo", "email": "bernardo@ua.pt"}' http://localhost:8080/api/employees

```

### H) Para inserir um novo método de pesquisa por email foi necessário:

**- Adicionar o método `findByEmail()` na interface `EmployeeRepository`:**

```java
List<Employee> findByEmail(String email);
```

**- Adicionar o método `findByEmail()` na interface `EmployeeService` e implementá-lo na classe `EmployeeServiceImpl`:**

```java
// EmployeeService.java
List<Employee> findByEmail(String email);

// EmployeeServiceImpl.java
public List<Employee> findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }
```

**- Adicionar o método `findByEmail()` no controller `EmployeeController`:**

```java
@GetMapping("/byemail")
    public ResponseEntity<List<Employee>> findByEmail(@RequestParam String email){
        List<Employee> employees = employeeService.findByEmail(email);
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }
```

*A rota `/byemail` foi escolhida para não entrar em conflito com a rota principal que está em uso no `getAllEmployees`.*

**Por fim foi possivel testar o novo método de pesquisa:**

```URL
http://localhost:8080/api/employees/byemail?email=bernardopinto@ua.pt
```

resultado:

```json
[{"id":52,"name":"Bernardo","email":"bernardopinto@ua.pt"}]
``` 


## 3.3 Wrapping-up and integrating concepts

**De forma semelhante ao exercício anterior foi criada uma pasta `entity` com a classe `Quote`, uma pasta `repository` com a interface `QuoteRepository`, uma pasta `service` com a interface `QuoteService` e a classe `QuoteServiceImpl` que implementa a interface `QuoteService`.**

**Já no ficheiro `application.properties` foram definidas as configurações da base de dados:**

**Dessa forma foi possível criar uma nova entidade `Quote` e persistir os dados no mysql.**

**`docker exec -it mysql5 bash` garante a interação com o container mysql e ajuda a verificar a persistência dos dados.**

***TODO: Dockerize da aplicação***


