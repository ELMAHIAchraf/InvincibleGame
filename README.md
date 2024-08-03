<h1 align="center">Guardians of Earth: Rise Against Viltrum</h1>

<p align="center">
  <img src="https://github.com/user-attachments/assets/0bcc5d5c-d921-4c94-975b-285b2105d65a" width="400px" alt="Logo">
</p>

## Description
"Guardians of Earth: Rise Against Viltrum" is a **JAVA-BASED** game designed using various **DESIGN PATTERNS**. In this game, players purchase heroes to battle formidable enemies in a richly detailed universe filled with adventure and challenges.

The game aims to deliver an engaging entertainment experience while being easy to maintain and expandable with additional characters and villains.

Detailed specifications and features include:

+ Randomized selection of villains
+ Player budget system for hero selection
+ Efficient memory management
+ Flexibility and scalability
+ Villains can recharge their energy during combat

Players have a budget of $25 to spend on heroes to defeat a Viltrumite soldier invading Earth, similar to the game shown in the image below.

<img src="https://github.com/user-attachments/assets/7ebebb63-ce68-4ca1-8122-f4d2a87d5750" width="400px">

## Conception Diagrams (UML)
### Class diagram

![TheGame](https://github.com/user-attachments/assets/0e04b8e9-295f-49fc-87d4-27dbf9c5405a)

## Design Patterns
### Prototype:
Allows the duplication of instances of Hero and ViltrumVillain classes, providing the ability to create new characters while preserving the integrity of the original object. 

### Template Method:
This pattern is used to customize the phrase or taunt that each villain says before each battle, thereby simplifying the management of behaviors common to all villains
<p align="center">
  <img src="https://github.com/user-attachments/assets/d48fefc0-59ec-4955-b1c2-b91cf1a1a5af" width="250px" height="300px">
  <img src="https://github.com/user-attachments/assets/d08ac651-4d64-4b11-94ef-9f911fe3f7a8" width="200px" height="300px">
</p>

### Adapter:
This pattern is used to handle the differentiation between various types of villains, such as the villain Rognarr who is not a Viltrumite
<p align="center">
  <img src="https://github.com/user-attachments/assets/565ccf0e-46cf-4c23-8cb7-67d4f269cd3e" width="250px">
</p>

### Factory Method:
Used for the creation and management of instances of the Elixir class, allowing each villain to recharge their energy when it reaches a critical threshold.



