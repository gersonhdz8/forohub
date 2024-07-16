
# Proyecto de API REST con Spring Boot (ForoHub)

## Descripción

Este proyecto es una API RESTful construida con Spring Boot que incluye autenticación y autorización utilizando JWT (JSON Web Tokens). Las funcionalidades principales incluyen:

- Listar tópicos
- Login de usuario
- Borrar tópico
- Actualizar tópico por ID
- Migraciones de base de datos con Flyway
- Base de datos en MySQL
- Uso de JPA (Java Persistence API) para acceso a datos
- Filtros de seguridad con Spring Security

## Tecnologías Utilizadas

- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- Spring Data JPA
- Flyway
- MySQL
- Maven

## Requisitos Previos

- JDK 11 o superior
- Maven
- MySQL

### Endpoints Disponibles
#### Autenticación
**POST** /login: Autentica un usuario y devuelve un token JWT.
#### Tópicos
**GET** /topics: Lista todos los tópicos (requiere autenticación).

**POST** /topics: Registra un nuevo topico en la base de datos.(requiere autenticación).

**DELETE** /topics/{id}: Elimina un tópico por ID (requiere autenticación).

**PUT** /topics/{id}: Actualiza un tópico por ID (requiere autenticación).

## Seguridad
Este proyecto utiliza Spring Security para gestionar la seguridad de los endpoints. A continuación, se describen los principales componentes de seguridad:

### Filtros de Seguridad
Filtro de Autenticación JWT: Se encarga de interceptar las solicitudes HTTP para verificar la presencia y validez del token JWT.

### Migraciones de Base de Datos
Flyway se utiliza para gestionar las migraciones de la base de datos. Las migraciones se encuentran en la carpeta src/main/resources/db/migration.

Cada archivo de migración debe seguir la convención de nomenclatura de Flyway, por ejemplo: V1__crear_tabla_topicos.sql.




