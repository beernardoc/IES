# Lab 3 - Notes

Autor: Bernardo Pinto

NMEC: 105926


## 3.1 Accessing databases in SpringBoot

### Inicialmente foi criado um projeto SpringBoot com o Spring Initializr e foram importadas as seguintes dependências: Web, JPA, Thymeleaf, H2 e validation.


- JPA: Java Persistence API, permite a persistência de dados em bases de dados relacionais, nesse caso, a base de dados H2.
- H2: Base de dados relacional em memória, que permite a persistência de dados.
- Thymeleaf: Template engine que permite a criação de páginas HTML dinâmicas.
- Validation: Permite a validação de dados.

### C) Walkthrough the available solution and answers these questions:**

#### 1.The `"UserController"` class gets an instance of `“userRepository”` through its constructor; how is this new repository instantiated?

Resumidamente,  o UserRepository é uma interface que define operações de persistência de dados e não precisa ser instanciada manualmente. Quando você precisa usá-lo em seu aplicativo, o Spring injetará automaticamente uma instância concreta desse repositório em componentes que dependem dele.


#### 2. List the methods invoked in the `“userRepository”` object by the `“UserController”`. Where are these methods defined?


- `findAll()`: Retorna todos os usuários.
- `findById()`: Retorna o usuário com o id especificado.
- `save()`: Salva o usuário especificado.
- `delete()`: Deleta o usuário especificado.

Estes métodos são definidos na classe CrudRepository e que é implementada pela interface UserRepository do projeto.

#### 3.Where is the data being saved?

Nesse caso a base de dados H2 está a ser usada para guardar os dados. Vale ressaltar que a base de dados está a ser usada em memória, ou seja, quando o programa é terminado os dados são perdidos.

#### 4. Where is the rule for the “not empty” email address defined?

A regra para obrigatoriedade de preenchimento do email é definida na classe User, através da anotação `@NotBlank`:
 

```java
@NotBlank(message = "Email is mandatory")
private String email;
```
*Nota: A anotação `@NotBlank` só funciona com Strings, para outros tipos de dados deve ser usada a anotação `@NotNull`.*


## 3.2 Accessing databases in SpringBoot