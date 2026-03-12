# MS-Tasks-Java 🚀

Este microservicio es el componente de gestión de negocio de un ecosistema distribuido. Ha sido diseñado bajo los principios de **Clean Architecture** para demostrar la interoperabilidad entre diferentes stacks tecnológicos.

## 🎯 El Desafío Técnico
El objetivo principal de este proyecto es demostrar cómo un servicio en **Java** puede confiar en la identidad gestionada por un servicio externo en **Python**, compartiendo una capa de seguridad basada en **JWT (JSON Web Tokens)** y una infraestructura común en **Docker**.

## 🛠️ Stack Tecnológico
* **Java 21** (LTS)
* **Spring Boot 3.4**
* **Spring Security** (Protección de rutas y filtros JWT)
* **Spring Data JPA** (Persistencia de datos)
* **PostgreSQL 15** (Corriendo en contenedor Docker)
* **Lombok** (Reducción de código boilerplate)
* **Maven** (Gestión de dependencias)



## 🏗️ Arquitectura de Integración
Este servicio no posee un módulo de registro de usuarios. En su lugar:
1. Recibe una solicitud con un `Authorization: Bearer <token>`.
2. Valida la firma del token usando una `SECRET_KEY` compartida con el microservicio `ms-auth` (Python).
3. Extrae el `user_id` del token para filtrar y guardar las tareas de forma aislada por usuario.


Parte de un ecosistema políglota:

🔐 ms-auth (Python/FastAPI) : git@github.com:LuisChacha/fastapi-clean-architecture-auth.git

✅ ms-tasks-java (Este repositorio)

---

## TESTS DESDE LA TERMINAL

### GET http://localhost:8080/api/v1/tasks/test

No olvidar cambiar el token(obtenido en el login del ms-auth de python) en los siguientes comandos:

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

