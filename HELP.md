# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/4.0.3/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/4.0.3/maven-plugin/build-image.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/4.0.3/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Validation](https://docs.spring.io/spring-boot/4.0.3/reference/io/validation.html)
* [Spring Web](https://docs.spring.io/spring-boot/4.0.3/reference/web/servlet.html)

### Guides

The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the
parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

## TESTS DESDE LA TERMINAL

### GET http://localhost:8080/api/v1/tasks/test

No olvidar cambiar el token(obtenido en el login del ms-auth de python) en el siguiente comando:

```bash
curl -X GET http://localhost:8080/api/v1/tasks/test -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3NzMyODU0MjEsInN1YiI6IjEifQ.SjfNvbl8eJ7YP53aaUpLtoKBL0NPNw-XhKAuknouHI4"
```

Output:

Microservicio de Tareas (Java) respondiendo correctamente 🚀


### POST http://localhost:8080/api/v1/tasks/

```bash
curl -X POST http://localhost:8080/api/v1/tasks/ \
-H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3NzMyODk0OTIsInN1YiI6IjEifQ.HkKvaqCby6dmilo8BBb7IiXtMlPOCBO1E5Vam4om18E" \
-H "Content-Type: application/json" \
-d '{"title": "Tarea desde terminal3", "description": "Probando arquitectura políglota3"}'

```
### GET http://localhost:8080/api/v1/tasks/

```
curl -X GET http://localhost:8080/api/v1/tasks/ \
     -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3NzMyODk0OTIsInN1YiI6IjEifQ.HkKvaqCby6dmilo8BBb7IiXtMlPOCBO1E5Vam4om18E" \
     -H "Content-Type: application/json"
```

# Microservicio de Tareas (Java Spring Boot) 🚀

Este microservicio forma parte de un ecosistema políglota, diseñado para gestionar tareas (To-Do) utilizando **Clean Architecture**.

## 🏗️ Características Técnicas
- **Lenguaje:** Java 21
- **Framework:** Spring Boot 3.4.x
- **Seguridad:** Spring Security + JWT (Validación cruzada con Python)
- **Persistencia:** Spring Data JPA con PostgreSQL
- **Arquitectura:** Clean Architecture (Controller, Service, Repository)

## 🔐 Integración Políglota (Python + Java)
Este servicio está diseñado para trabajar en conjunto con un **Microservicio de Autenticación en Python (FastAPI)**.
- No gestiona usuarios directamente.
- Valida tokens JWT firmados por el servicio de Python mediante una `SECRET_KEY` compartida.
- Extrae el `user_id` del payload del token para garantizar la integridad de los datos.

## 🚀 Instalación Rápida
1. **Configurar el entorno:**
   Asegúrate de tener corriendo el contenedor de PostgreSQL del proyecto `ms-auth`.

2. **Variables de Entorno:**
   Configura tu `application.properties` con la misma `SECRET_KEY` utilizada en el microservicio de Python.

3. **Ejecución:**
   ```bash
   ./mvnw spring-boot:run

## 🛠️ API Endpoints
GET /api/v1/tasks/test - Público: Verifica la salud del servicio.

GET /api/v1/tasks/ - Privado: Lista las tareas del usuario autenticado.

POST /api/v1/tasks/ - Privado: Crea una nueva tarea asociada al ID del usuario en el token.