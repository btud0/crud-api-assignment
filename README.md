# crud-api-assignment
Assignment 3 for CSC340 - Building a CRUD api for static prototype we previously made

## Installation
1. Clone the Repository
```bash
git clone https://github.com/btud0/crud-api-assignment.git
```

2. Install The Dependencies
```bash
./mvnw clean install
```
3. Run the Application
```bash
./mvnw spring-boot:run
```
4. The API Will Run At http://localhost:8080

## API Endpoints

All endpoints use the base URL: `http://localhost:8080/characters`

### 1. Get All Characters

```http
GET /characters/
```

**Description**: Retrieve a list of all characters in the database.

**Parameters**: None

**Response**:

- **Status Code**: `200 OK`
- **Body**: Array of Character Objects

#### Example Request

```bash
curl http://localhost:8080/characters/
```

#### Example Response (Status: 200 OK)

```json

  [
	{
		"characterId": 2,
		"description": "Strongest sorcerer in the world",
		"name": "Satoru Gojo",
		"rank": "Special Grade",
		"techniques": "Limitless, Six Eyes"
	}
]

```

---

### 2. Get Character by ID

```http
GET /characters/{id}
```

**Description**: Retrieve a single Character by their ID.

**Path Parameters**:

- `id` (Long, required): The unique identifier of the Character

**Response**:

- **Status Code**: `200 OK` (if found) or `404 Not Found` (if not found)
- **Body**: Character object

#### Example Request

```bash
curl http://localhost:8080/characters/2
```

#### Example Response (Status: 200 OK)

```json
{
	"characterId": 2,
	"description": "Strongest sorcerer in the world",
	"name": "Satoru Gojo",
	"rank": "Special Grade",
	"techniques": "Limitless, Six Eyes"
}
```

#### Example Response if not found (Status: 404 Not Found)

```
(Empty body)
```

---

### 3. Create a New Character

```http
POST /characters/
```

**Description**: Create a new Character record in the database.

**Request Body**: Character object with the following fields:

- `name` (String, required): Character's name
- `description` (String, optional): A brief character description
- `rank` (String, required): Character's Rank
- `techniques` (String, required): Character's Techniques

**Response**:

- **Status Code**: `200 OK` (if created successfully)
- **Body**: Created Character object with assigned `characterId`

#### Example Request

```bash
curl -X POST http://localhost:8080/characters/ \
  -H "Content-Type: application/json" \
  -d '{
  "name": "Megumi Fushiguro",
  "description": "Student at Tokyo Jujutsu High and user of the Ten Shadows Technique.",
  "rank": "Grade 2",
  "techniques": "Ten Shadows Technique, Divine Dogs"
}'
```

#### Example Response (Status: 200 OK)

```json
{
  "characterId": 3,
  "name": "Megumi Fushiguro",
  "description": "Student at Tokyo Jujutsu High and user of the Ten Shadows Technique.",
  "rank": "Grade 2",
  "techniques": "Ten Shadows Technique, Divine Dogs"
}
```

---

### 4. Get Characters by Rank

```http
GET /characters/rank/{rank}
```

**Description**: Retrieve all characters with a specific rank.

**Path Parameters**:

- `rank` (String, required): The rank to filter by (e.g., "Special Grade")

**Response**:

- **Status Code**: `200 OK`
- **Body**: Array of Character objects

#### Example Request

```bash
curl http://localhost:8080/characters/rank/Special%20Grade
```

#### Example Response (Status: 200 OK)

```json
[
  {
    "characterId": 2,
    "name": "Satoru Gojo",
    "description": "Strongest sorcerer in the world",
    "rank": "Special Grade",
    "techniques": "Limitless, Six Eyes"
  }
]
```

---

### 5. Get Characters by Technique

```http
GET /characters/technique/{technique}
```

**Description**: Retrieve characters that use a specific technique (partial match supported).

**Path Parameters**:

- `technique` (String, required): The technique to search for

**Response**:

- **Status Code**: `200 OK`
- **Body**: Array of Character objects

#### Example Request

```bash
curl http://localhost:8080/characters/technique/Limitless
```

#### Example Response (Status: 200 OK)

```json
[
  {
    "characterId": 2,
    "name": "Satoru Gojo",
    "description": "Strongest sorcerer in the world",
    "rank": "Special Grade",
    "techniques": "Limitless, Six Eyes"
  }
]
```

---

### 6. Search Characters by Name

```http
GET /characters/search?name={name}
```

**Description**: Search for characters by name (partial match supported) or retrieve all characters if no name is provided.

**Query Parameters**:

- `name` (String, optional): The name or part of the name to search for

**Response**:

- **Status Code**: `200 OK`
- **Body**: Array of matched Character objects

#### Example Request

```bash
curl "http://localhost:8080/characters/search?name=Gojo"
```

#### Example Response (Status: 200 OK)

```json
[
  {
    "characterId": 2,
    "name": "Satoru Gojo",
    "description": "Strongest sorcerer in the world",
    "rank": "Special Grade",
    "techniques": "Limitless, Six Eyes"
  }
]
```

---

### 7. Update a Character

```http
PUT /characters/{id}
```

**Description**: Update an existing character's information.

**Path Parameters**:

- `id` (Long, required): The ID of the character to update

**Request Body**: Character object with fields to update:

- `name` (String): Updated name
- `description` (String): Updated description
- `rank` (String): Updated rank
- `techniques` (String): Updated techniques

**Response**:

- **Status Code**: `200 OK` (if updated successfully) or `404 Not Found` (if character not found)
- **Body**: Updated Character object

#### Example Request

```bash
curl -X PUT http://localhost:8080/characters/2 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Satoru Gojo",
    "description": "The strongest sorcerer in the modern era",
    "rank": "Special Grade",
    "techniques": "Limitless, Six Eyes, Infinity"
  }'
```

#### Example Response (Status: 200 OK)

```json
{
  "characterId": 2,
  "name": "Satoru Gojo",
  "description": "The strongest sorcerer in the modern era",
  "rank": "Special Grade",
  "techniques": "Limitless, Six Eyes, Infinity"
}
```

---

### 8. Delete a Character

```http
DELETE /characters/{id}
```

**Description**: Delete an existing character record from the database.

**Path Parameters**:

- `id` (Long, required): The ID of the character to delete

**Response**:

- **Status Code**: `204 No Content` (successful deletion)
- **Body**: Empty

#### Example Request

```bash
curl -X DELETE http://localhost:8080/characters/2
```

#### Example Response (Status: 204 No Content)

```
(Empty body)
```

## Demo Video

Link to demo video showing api endpoints: 
```markdown
https://uncg-my.sharepoint.com/:v:/g/personal/bjhansen_uncg_edu/IQAk6-OQjzkXQIG3j8hRWnYJAdElnLeCtDhROvnk_m7zAC8?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJPbmVEcml2ZUZvckJ1c2luZXNzIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXciLCJyZWZlcnJhbFZpZXciOiJNeUZpbGVzTGlua0NvcHkifX0&e=0pxh5r