# Character CRUD API - Spring Boot Demo

A comprehensive RESTful API for managing character records, built with Spring Boot, Spring Data JPA, and PostgreSQL. This project demonstrates fundamental concepts for building APIs with Spring Boot.

## Table of Contents

- [What is This Project?](#what-is-this-project)
- [Technology Stack](#technology-stack)
- [Installation & Setup](#installation--setup)
- [Running the Application](#running-the-application)
- [Project Architecture](#project-architecture)
- [API Endpoints](#api-endpoints)
- [Key Spring Boot Concepts](#key-spring-boot-concepts)
- [Database Schema](#database-schema)

---

## What is This Project?

This is a **CRUD API** (Create, Read, Update, Delete) that manages character records. It demonstrates:

- How to build a REST API with Spring Boot
- How to connect to a PostgreSQL database using JPA
- How to structure a Spring Boot application with layers (Controller, Service, Repository)
- How to handle HTTP requests and responses
- How to perform database operations

**CRUD** stands for:

- **C**reate - Add new character records
- **R**ead - Retrieve character records
- **U**pdate - Modify existing character records
- **D**elete - Remove character records

---

## Technology Stack

| Technology          | Version | Purpose                                |
| ------------------- | ------- | -------------------------------------- |
| **Java**            | 25      | Programming language                   |
| **Spring Boot**     | 4.0.3   | Framework for building the application |
| **Spring Data JPA** | Latest  | ORM layer for database access          |
| **Hibernate**       | Latest  | JPA implementation                     |
| **PostgreSQL**      | Latest  | Relational database                    |
| **Maven**           | Latest  | Build and dependency management        |

### Java - [Spring ORM with JPA and Hibernate](https://medium.com/@burakkocakeu/jpa-hibernate-and-spring-data-jpa-efa71feb82ac)
- We are using ORM (Object-Relational Mapping) to deal with databases. This is a technique that allows us to interact with a relational database using object-oriented programming principles.
- JPA (Jakarta Persistence, formerly Java Persistence API) is a specification that defines ORM standards in Java. It provides an abstraction layer for ORM frameworks to make concrete implementations.
- Hibernate: Hibernate is a popular ORM framework that implements JPA. It simplifies database operations by mapping Java objects to database tables and handling queries efficiently.
- Spring ORM allows seamless integration of Hibernate and JPA, making database interactions more manageable and reducing boilerplate code.

### Key Dependencies Explained

**spring-boot-starter-data-jpa**: Provides Spring Data JPA for simplified database access through repositories and automatic query generation.

**spring-boot-starter-webmvc**: Provides Spring Web MVC for building REST APIs with annotations like `@Controller`, `@GetMapping`, etc.

**postgresql**: JDBC driver to connect to PostgreSQL database.

---

## Installation & Setup

### Prerequisites

Before you begin, ensure you have installed:

1. **Java 25 JDK**
   - Download from [Oracle Java](https://www.oracle.com/java/technologies/downloads/) or use a package manager
   - Verify installation: `java -version`

2. **Neon.tech PostgreSQL Database** (Cloud-based, Serverless)
   - This project uses [Neon.tech](https://neon.tech), a serverless PostgreSQL database in the cloud
   - You don't need to install PostgreSQL locally
   - Sign up for a free account at [Neon.tech](https://neon.tech)
   - You only need an internet connection to connect to the database

3. **Git** (optional, for cloning the project)
   - Download from [Git Official Site](https://git-scm.com/)

### About Maven Wrapper

**Good news!** This project includes the **Maven Wrapper** (`mvnw` on Mac/Linux and `mvnw.cmd` on Windows). This means you **do not need to install Maven separately**. The wrapper automatically downloads the correct Maven version for you.

The Maven Wrapper is a handy tool that ensures everyone working on the project uses the same Maven version, reducing compatibility issues.

### Setup Instructions

1. **Clone or Download the Project**

   ```bash
   git clone <repository-url>
   cd sp26-crud-api-demo
   ```

2. **Install Dependencies**
   The Maven Wrapper will automatically download dependencies from the `pom.xml` file:

   **On Windows**:

   ```cmd
   mvnw.cmd clean install
   ```

   **On Mac/Linux**:

   ```bash
   ./mvnw clean install
   ```

   This command:
   - `clean`: Removes previous build artifacts
   - `install`: Downloads all dependencies and compiles the project
   - First run may take a few minutes as Maven is downloaded

3. **Database Configuration (Neon.tech Serverless PostgreSQL)**

   #### Step 1: Get Your Neon.tech Connection String

   1. Navigate to [Neon.tech](https://neon.tech)
   2. Sign in to your account
   3. In your project dashboard, find your connection string
   4. It will look like: `postgresql://username:password@host:5432/dbname`

   #### Step 2: Stop Tracking `application.properties` Locally

   To prevent accidentally committing your database credentials to Git, use `git skip-worktree` to exclude your local copy:

   ```bash
   git update-index --skip-worktree src/main/resources/application.properties
   ```

   This tells Git to ignore any changes you make to this file locally. You can now safely edit the file without worrying about committing sensitive data.

   #### Step 3: Update Your Connection String

   Edit `src/main/resources/application.properties` and add your Neon.tech PostgreSQL connection string:

   ```properties
   spring.application.name=crud-api
   spring.datasource.url=jdbc:postgresql://host:5432/dbname
   spring.datasource.username=your_neon_username
   spring.datasource.password=your_neon_password
   spring.jpa.hibernate.ddl-auto=update

   #Log out sql queries
   logging.level.org.hibernate.SQL=DEBUG
   logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
   logging.level.org.hibernate.orm.jdbc.bind=TRACE
   ```

   Replace with your actual Neon.tech credentials:
   - `host`: Your Neon.tech host (e.g., `some-cool-projectName-pooler.c-7.us-east-1.aws.neon.tech`)
   - `dbname`: Your database name (usually `neondb`)
   - `your_neon_username`: Your Neon.tech username
   - `your_neon_password`: Your Neon.tech password

   #### Example Connection String

   ```properties
   spring.datasource.url=jdbc:postgresql://ep-cool-cherry-ai9ih0ua-pooler.c-7.us-east-1.aws.neon.tech:5432/neondb
   spring.datasource.username=neondb_owner
   spring.datasource.password=your_password_here
   ```

   #### To Resume Tracking the File

   If you need to revert and track the file again:

   ```bash
   git update-index --no-skip-worktree src/main/resources/application.properties
   ```

   **Important Note**: This approach (using `git skip-worktree`) keeps credentials safe locally while the file can be tracked in Git. However, in production environments, database credentials should be managed using environment variables or cloud-based secret management services like AWS Secrets Manager or Azure Key Vault.

4. **Verify Setup**

   **On Windows (PowerShell)**:

   ```cmd
   mvnw.cmd compile
   ```

   **On Mac/Linux (Bash/zsh)**:

   ```bash
   ./mvnw compile
   ```

   If successful, you'll see `BUILD SUCCESS` at the end.

---

## Running the Application

### Using Maven Wrapper

**On Windows**:

```cmd
mvnw.cmd spring-boot:run
```

**On Mac/Linux**:

```bash
./mvnw spring-boot:run
```

The application will start on **http://localhost:8080**

You should see output like:

```
Started CrudApiApplication in 4.532 seconds
```

### Using Java (After Building)

Alternatively, after building the project, you can run the compiled JAR file:

```bash
java -jar target/crud-api-0.0.1-SNAPSHOT.jar
```

### Using VS Code GUI

1. **Open the Project**: Open the project folder in VS Code
2. **Install Extension**: Install the "Extension Pack for Java" (by Microsoft) if not already installed
3. **Run the Application**:
   - Go to the Explorer view (left sidebar)
   - Navigate to `src > main > java > com > csc340 > homework > CrudApiApplication.java`
   - Right-click on `CrudApiApplication.java`
   - Select **"Run Java"** or click the ▶️ **Run** button that appears above the class definition
4. **View Output**: The terminal will show the Spring Boot startup messages and confirm the application is running

### Using IntelliJ IDEA GUI

1. **Open the Project**: Open the project folder in IntelliJ IDEA (it will recognize it as a Maven project)
2. **Configure JDK**:
   - Go to **File → Project Structure → Project**
   - Set the Project SDK to Java 25
3. **Run the Application**:
   - Navigate to `src > main > java > com > csc340 > homework > CrudApiApplication.java` in the Project Explorer
   - Right-click on `CrudApiApplication.java`
   - Select **"Run 'CrudApiApplication.main()'"** or click the ▶️ **Run** button next to the class name
4. **View Output**: The Run window at the bottom will show Spring Boot startup messages and confirm the application is running

**Alternative: Using the Run Menu**:
- Go to **Run → Run...** and select `CrudApiApplication` from the list
- Or use the keyboard shortcut: **Shift+F10** (Windows) or **Ctrl+R** (Mac)

### Stopping the Application

Press `Ctrl+C` in your terminal to stop the running application. If using IDE GUI, click the ⏹️ **Stop** button in the Run/Debug toolbar.

---

## Project Architecture

### Folder Structure

```
src/main/java/com/csc340/crud_api/
├── CrudApiApplication.java          # Entry point of the application
├── StudentApiController.java         # Handles HTTP requests
├── StudentService.java               # Business logic layer
├── StudentRepository.java            # Database access layer
└── Student.java                      # Entity/Model class

src/main/resources/
└── application.properties             # Configuration file
```

### Architectural Pattern: **Layered Architecture**

This project follows a three-tier architecture pattern:

```
┌─────────────────────────────────────┐
│   HTTP Client (REST Client, Browser)│
└────────────────┬────────────────────┘
                 │
┌────────────────▼────────────────────┐
│    Controller Layer                 │
│  (StudentApiController)             │
│  - Handles HTTP requests/responses  │
│  - Maps URLs to methods(endpoints)  │
└────────────────┬────────────────────┘
                 │
┌────────────────▼────────────────────┐
│    Service Layer                    │
│  (StudentService)                   │
│  - Contains business logic          │
│  - Processes data from repositories │
└────────────────┬────────────────────┘
                 │
┌────────────────▼────────────────────┐
│    Repository Layer                 │
│  (StudentRepository)                │
│  - Communicates with database       │
│  - Performs CRUD operations         │
└────────────────┬────────────────────┘
                 │
┌────────────────▼────────────────────┐
│    Database                         │
│  (PostgreSQL)                       │
└─────────────────────────────────────┘
```

### Why This Architecture?

- **Separation of Concerns**: Each layer has a specific responsibility
- **Reusability**: Service layer logic can be reused by multiple controllers
- **Testability**: Each layer can be tested independently
- **Maintainability**: Changes in one layer don't require changes in others

---

## API Endpoints

All endpoints use the base URL: `http://localhost:8080/api/characters`

### 1. Get All Characters

```http
GET /api/characters/
```

**Description**: Retrieve a list of all characters in the database.

**Parameters**: None

**Response**:

- **Status Code**: `200 OK`
- **Body**: Array of Student objects

#### Example Request

```bash
curl http://localhost:8080/api/characters/
```

#### Example Response (Status: 200 OK)

```json
[
 [
	{
		"characterID": 1,
		"description": "Krobus is the only friendly monster players will encounter, however he still refers to other hostile monsters as his friends. He is a shadow person who lives in the Sewers.",
		"lovedGift": "Diamond",
		"marriageStatus": "No",
		"name": "Krobus"
	},
	{
		"characterID": 2,
		"description": "Sam is an outgoing and energetic young man with a passion for music. He works part-time at JojaMart.",
		"lovedGift": "Pizza",
		"marriageStatus": "Yes",
		"name": "Sam"
	}
]
```

---

### 2. Get Character by ID

```http
GET /api/characters/{id}
```

**Description**: Retrieve a single character by their ID.

**Path Parameters**:

- `id` (Long, required): The unique identifier of the student

**Response**:

- **Status Code**: `200 OK` (if found) or `404 Not Found` (if not found)
- **Body**: Student object

#### Example Request

```bash
curl http://localhost:8080/api/characters/1
```

#### Example Response (Status: 200 OK)

```json
{
  "characterID": 1,
  "description": "Krobus is the only friendly monster players will encounter, however he still refers to other hostile monsters as his friends. He is a shadow person who lives in the Sewers.",
  "lovedGift": "Diamond",
  "marriageStatus": "No",
  "name": "Krobus"
}
```

#### Example Response if not found (Status: 404 Not Found)

```
(Empty body)
```

---

### 3. Create a New Character

```http
POST /api/characters/
```

**Description**: Create a new character record in the database.

**Request Body**: Character object with the following fields:

- `name` (String, required): Characters name
- `lovedGift` (String, optional): Character's loved gift
- `marriageStatus` (String, optional): Character's marriage status (yes or no)

**Response**:

- **Status Code**: `200 OK` (if created successfully)
- **Body**: Created Character object with assigned `characterID`

#### Example Request

```bash
curl -X POST http://localhost:8080/api/characters/ \
  -H "Content-Type: application/json" \
  -d '{
    "description": "Haley is a villager who lives in Pelican Town. She's one of the twelve characters available to marry.",
    "lovedGift": "Sunflower",
    "marriageStatus": "Yes",
    "name": "Haley"
  }'
```

#### Example Response (Status: 200 OK)

```json
{
  "studentId": 8,
  "description": "Haley is a villager who lives in Pelican Town. She's one of the twelve characters available to marry.",
  "lovedGift": "Sunflower",
  "marriageStatus": "Yes",
  "name": "Haley"
}
```

---

### 4. Get Character by loved gift

```http
GET /api/characters/gifts/{lovedGift}
```

**Description**: Retrieve all characters with a specific loved gift.

**Path Parameters**:

- `lovedGift` (String, required): The loved gift to filter by (e.g., "Amethyst")

**Response**:

- **Status Code**: `200 OK`
- **Body**: Array of character objects

---

### 5. Get Character by marriage status

```http
GET /api/characters/marriage/{marriageStatus}
```

**Description**: Retrieve all characters with a specific marriage status.

**Path Parameters**:

- `marriageStatus` (String, required): The marriage status to filter by (e.g, "No")

**Response**:

- **Status Code**: `200 OK`
- **Body**: Array of character objects 

#### Example Request

```bash
curl http://localhost:8080/api/characters/marriage/No
```

#### Example Response (Status: 200 OK)

```json
[
    {
		"characterID": 1,
		"description": "Krobus is the only friendly monster players will encounter, however he still refers to other hostile monsters as his friends. He is a shadow person who lives in the Sewers.",
		"lovedGift": "Diamond",
		"marriageStatus": "No",
		"name": "Krobus"
	},
	{
		"characterID": 5,
		"description": "Robin is the town carpenter and runs her own Carpenter's Shop, at her home, from 9am to 5pm every day except Tuesday and part of Friday (closes early).",
		"lovedGift": "Peach",
		"marriageStatus": "No",
		"name": "Robin"
	}
]
```

---

### 6. Search Characters by Name

```http
GET /api/characters/search?name={ro}
```

**Description**: Search for characters by name (partial match supported) or retrieve all characters if no name is provided.

**Query Parameters**:

- `name` (String, optional): The name or part of the name to search for

**Response**:

- **Status Code**: `200 OK`
- **Body**: Array of matched Character objects

#### Example Request

```bash
curl "http://localhost:8080/api/characters/search?name=ro"
```

#### Example Response (Status: 200 OK)

```json
[
	{
		"characterID": 1,
		"description": "Krobus is the only friendly monster players will encounter, however he still refers to other hostile monsters as his friends. He is a shadow person who lives in the Sewers.",
		"lovedGift": "Diamond",
		"marriageStatus": "No",
		"name": "Krobus"
	}
]
```

---

### 8. Update a Character

```http
PUT /api/characters/{id}
```

**Description**: Update an existing character's information.

**Path Parameters**:

- `id` (Long, required): The ID of the character to update

**Request Body**: Character object with fields to update:

- `description` (String): Updated description
- `lovedGift` (String): Updated loved gift
- `marriageStatus` (String): Updated marriage status
- `Name` (String): Updated name

**Response**:

- **Status Code**: `200 OK` (if updated successfully) or `404 Not Found` (if character not found)
- **Body**: Updated Character object

#### Example Request

```bash
curl -X PUT http://localhost:8080/api/students/1 \
  -H "Content-Type: application/json" \
  -d '{
    "description": "Haley is a villager who lives in Pelican Town. She's one of the twelve characters available to marry.",
    "lovedGift": "Coconut",
    "marriageStatus": "Yes",
    "name": "Haley"
  }'
```

#### Example Response (Status: 200 OK)

```json
{
  "characterID": 8,
  "description": "Haley is a villager who lives in Pelican Town. She's one of the twelve characters available to marry.",
  "lovedGift": "Coconut",
  "marriageStatus": "Yes",
  "name": "Haley"
}
```

---

### 9. Delete a StudCharacterent

```http
DELETE /api/characters/{id}
```

**Description**: Delete an existing character record from the database.

**Path Parameters**:

- `id` (Long, required): The ID of the character to delete

**Response**:

- **Status Code**: `204 No Content` (successful deletion)
- **Body**: Empty

#### Example Request

```bash
curl -X DELETE http://localhost:8080/api/characters/1
```

#### Example Response (Status: 204 No Content)

```
(Empty body)
```

---

## Key Spring Boot Concepts

### What is Spring Boot?

Spring Boot is a framework that simplifies building production-ready Spring applications. It provides:

- Auto-configuration of Spring application based on jar dependencies
- Embedded web server (Tomcat) - no need to deploy WAR files
- Convention over configuration - sensible defaults
- Easy integration with databases and other services

### @Controller and @RequestMapping

```java
@Controller
@RequestMapping("/api/characters")
public class CharacterApiController { }
```

- `@Controller`: Tells Spring this class handles HTTP requests
- `@RequestMapping("/api/characters")`: All endpoints in this class start with `/api/characters`

### HTTP Mapping Annotations

- `@GetMapping`: Handles GET requests (retrieve data)
- `@PostMapping`: Handles POST requests (create data)
- `@PutMapping`: Handles PUT requests (update data)
- `@DeleteMapping`: Handles DELETE requests (delete data)

### @Service and Dependency Injection

```java
@Service
public class CharacterService {
  private final CharacterRepository characterRepository;

  public CharacterService(CharacterRepository characterRepository) {
    this.characterRepository = characterRepository;
  }
}
```

- `@Service`: Marks a class as a service component (business logic)
- Constructor injection: Dependencies are provided through the constructor (best practice)

### Spring Data JPA Repository

```java
public interface CharacterRepository extends JpaRepository<Character, Long> {
    List<Character> findByLovedGift(String lovedGift);
    List<Character> findByMarriageStatus(String marriageStatus);
}
```

- `JpaRepository<Character, Long>`: Provides CRUD methods automatically
- Spring automatically generates implementations for custom finder methods
- `findByLovedGift` generates a query like: `SELECT * FROM characters WHERE lovedGift = ?`

### @Entity and JPA Annotations

```java
@Entity
@Table(name = "characters")
public class Character {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long characterID;
}
```

- `@Entity`: Marks this class as a database table
- `@Table(name = "students")`: Specifies the table name
- `@Id`: Marks the primary key field
- `@GeneratedValue`: Auto-generates IDs (database handles increment)

### ResponseEntity

```java
  public ResponseEntity<Character> getCharacterById(@PathVariable Long id) {
    Character character = characterService.getCharacterByID(id);
    if (character != null) {
      return ResponseEntity.ok(character);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
```

`ResponseEntity` provides full control over HTTP responses including:

- Status codes (200, 404, 201, etc.)
- Response headers
- Response body

---

## Database Schema

The application uses a single table to store character data:

### CHARACTERS Table

| Column                 | Type             | Constraints      | Description                         |
| ---------------------- | ---------------- | ---------------- | ----------------------------------- |
| `characterID`          | SERIAL           | PRIMARY KEY      | Auto-incrementing unique identifier |
| `name`                 | VARCHAR(255)     | NOT NULL         | Character's name                    |
| `description`          | TEXT             | NOT NULL         | Character's description             |
| `lovedGift`            | VARCHAR(255)     | NOT NULL         | Character's loved gift              |
| `marriageStatus`       | VARCHAR(255)     | NOT NULL         | Character's marriage status         |


### SQL (for reference)

```sql
CREATE TABLE characters (
  character_ID SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description TEXT NOT NULL,
  lovedGift VARCHAR(255) NOT NULL,
  marriageStatus VARCHAR(255) NOT NULL
);
```

**Note**: This schema is automatically created by Hibernate based on the entity class when `spring.jpa.hibernate.ddl-auto=update` is set in `application.properties`.

---

## Testing the API

### Using Postman/Echo API/Bruno (GUI)

1. Create a new request
2. Select HTTP method (GET, POST, PUT, DELETE)
3. Enter URL (e.g., http://localhost:8080/api/characters/)
4. If POST/PUT, go to "Body" tab → select "raw" and "JSON"
5. Enter JSON data and click "Send"

---

## Common Issues and Solutions

### Issue: Port 8080 is already in use

**Solution**: Change the port in `application.properties`:

```properties
server.port=8081
```

Then access the API at `http://localhost:8081/api/characters/`

### Issue: "Connection refused" when accessing database

**Solution**:
- Ensure you have **internet access** to connect to Neon.tech (the database is cloud-based and always running)
- Verify your connection string is correct in `application.properties`
- Check that your username and password from Neon.tech are correct
- Make sure the host/endpoint is reachable (not blocked by firewall)

### Issue: Getting 404 errors

**Solution**:

- Verify the endpoint URL is correct
- Make sure the application is running (use `mvnw.cmd spring-boot:run` on Windows or `./mvnw spring-boot:run` on Mac/Linux)
- Check the base path is `/api/characters`

### Issue: JSON parsing errors in POST/PUT requests

**Solution**:

- Ensure `Content-Type: application/json` header is set
- Verify JSON syntax is valid (use online JSON validator)
- Check all required fields are included (name and email are required)

---

## Additional Resources

- [Spring Boot Official Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA Guide](https://spring.io/projects/spring-data-jpa)
- [REST API Best Practices](https://restfulapi.net/)
- [PostgreSQL Documentation](https://www.postgresql.org/docs/)