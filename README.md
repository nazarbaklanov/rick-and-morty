
Project description: 🎥
-----------------------
Rick and Morty - interesting app about characters from popular cartoon Rick and Morty.
There are 2 endpoints in the application:
- to get a list of all characters with a filter by part of the name;
- to get one character by random id.

Character's schema: 🧱
--------------------
 - id	|    int    |    The id of the character.
 - name | string |	The name of the character.
 - status |	string |	The status of the character ('Alive', 'Dead' or 'unknown').
 - species |	string |	The species of the character.
 - type |	string |	The type or subspecies of the character.
 - gender |	string |	The gender of the character ('Female', 'Male', 'Genderless' or 'unknown').
 - image |	string | (url)	Link to the character's image. All images are 300x300px and most are medium shots or portraits since they are intended to be used as avatars.
  
**Detail information about characters you can see by this** 👉 [**LINK**](https://rickandmortyapi.com/api/character)

Technologies used in project 💻
----------------------------
- Spring Boot 2.7, Spring Web, Spring Jpa
- DB PostgreSQL
- Java v.11
- Apache Maven v.3.1.1
- Docker

Instruction for run this application: 🚀
------------------------------------
- pull this file on your PC;
- install Docker in your PC;
- start docker on your PC;
- open terminal and insert next command: `docker -compose up`;
- open browser in this url: 👉 [**LINK**](http://localhost:6868/swagger-ui/#/);
- your application is ready to work.
