<h1 align="center" id="title">Stash</h1>

<p id="description">Welcome to the Stash Repository. This is an API that is built to manage inventory/shop made using Spring Boot and Spring Security. The Key features include secure authentication and use of tokens to safely manage inventory.</p>

## Features

- [x] User registration
- [x] Secure User Login via Tokens
- [x] Perform CRUD operations for managing the inventory

## Technologies

* Spring Boot 3.0
* Spring Security
* JSON Web Tokens (JWT)
* BCrypt
* Maven
* Docker
* PostgreSQL

## Getting Started
To get started with this project, you will need to have the following installed on your local machine:

* JDK 17+
* Maven 3+

## To build and run the project

### Clone the Repository

```
git clone https://github.com/SachinPrasanth777/Stash
```

> [!NOTE]  
> Create a database users before running the main project

> [!NOTE]
> Navigate into the project directory and create a database named users

### Build the Project

```
mvn clean install
```

### Run the project

```
mvn spring-boot:run
```

> [!NOTE]
> The project will start running in port 8080

<p align="center" style="font-size: 100px;">
  OR
</p>


### Run the Docker Container

```
docker compose up --build
```
