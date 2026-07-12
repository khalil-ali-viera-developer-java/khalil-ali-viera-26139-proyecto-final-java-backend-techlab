# Gestor de Artículos API

API REST desarrollada con **Spring Boot** para la gestión de artículos mediante operaciones **CRUD (Crear, Leer, Actualizar y Eliminar)**. La aplicación utiliza **Spring Data JPA** para el acceso a datos y una base de datos **MariaDB** ejecutada mediante **XAMPP**.

---

## Tecnologías utilizadas

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* Maven
* XAMPP (MariaDB)
* Postman
* Git
* GitHub

---

## Funcionalidades

* Crear un artículo.
* Obtener todos los artículos.
* Obtener un artículo por ID.
* Actualizar un artículo.
* Eliminar un artículo.
* Validación de datos.
* Manejo de excepciones.
* Respuestas HTTP mediante `ResponseEntity`.

---

## Arquitectura del proyecto

La aplicación sigue una arquitectura en capas:

```text
Cliente
   │
   ▼
Controller
   │
   ▼
Service
   │
   ▼
Repository (Spring Data JPA)
   │
   ▼
MariaDB (XAMPP)
```

### Descripción de las capas

* **Controller:** recibe las solicitudes HTTP y devuelve las respuestas.
* **Service:** contiene la lógica de negocio y las validaciones.
* **Repository:** accede a la base de datos mediante Spring Data JPA.
* **Entity:** representa las tablas de la base de datos.

---

## Endpoints

| Método HTTP | Endpoint              | Descripción                 |
| ----------- | --------------------- | --------------------------- |
| GET         | `/api/articulos`      | Obtener todos los artículos |
| GET         | `/api/articulos/{id}` | Obtener un artículo por ID  |
| POST        | `/api/articulos`      | Crear un artículo           |
| PUT         | `/api/articulos/{id}` | Actualizar un artículo      |
| DELETE      | `/api/articulos/{id}` | Eliminar un artículo        |

---

## Estructura del proyecto

```text
gestor-articulos
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── controller
│   │   │   ├── service
│   │   │   ├── repository
│   │   │   ├── model
│   │   │   ├── exception
│   │   │   └── GestorArticulosApplication.java
│   │   │
│   │   └── resources
│   │       └── application.properties
│   │
│   └── test
│
├── docs
│   ├── uml
│   
├── pom.xml
└── README.md
```

---

## Base de datos

La aplicación utiliza **MariaDB**, ejecutada mediante **XAMPP**.

La configuración de la conexión se encuentra en:

```text
src/main/resources/application.properties
```

---

## Cómo ejecutar el proyecto

1. Clonar el repositorio.
2. Abrir el proyecto en **Visual Studio Code**.
3. Iniciar **Apache** y **MySQL (MariaDB)** desde XAMPP.
4. Crear la base de datos correspondiente.
5. Configurar la conexión en `application.properties`.
6. Ejecutar la aplicación.
7. Probar los endpoints utilizando Postman.

---

## Herramientas utilizadas durante el desarrollo

* Visual Studio Code
* Java Extension Pack
* Maven
* XAMPP
* phpMyAdmin
* Postman
* Git
* GitHub
* draw.io

---

## Documentación

La documentación técnica del proyecto se encuentra en la carpeta **docs**, donde se incluyen:

* Diagramas UML.

---

## Autor

**Khalil Ali Viera**
