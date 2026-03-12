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