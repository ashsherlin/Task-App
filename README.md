
# Task App Project

## Overview

I created this project to solidify my learning with Java as a backend, the MVC design pattern, the Spring Boot framework, and crafting a functional front-end. By starting from scratch, I was able to delve deep into each component, understanding its significance and role in the larger scheme of things. This project helped me piece together the puzzle of how each front-end interaction translated to specific operations in the backend, which made those topics I’ve learned throughout the bootcamp tangible beyond the classroom. 


### Users should be able to:

- View all Tasks
- Create a new Task
- Update an existing task
- Delete an existing task



### Setup Instructions
1. Run SQL file and configure database

2. Run index.html through local server, I used http-server on Bash. 


## My process

### Built with

![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)



### What I learned

#### Project Initialization:
This was the first project I've created on my own without instruction, so I was surprised when I was stumped as soon as I opened the Spring Initializer. I had to google why to use specific versions of Spring Boot & Java and what standard was for the Metadata. 

#### Database Design Decisions:
I started the project with the 'date_Added' field as a string, thinking it would be most flexible this way. Later I decided to change it to LocalDate so Postgres would handle the date field itself, this left me with a task that I couldn't get Postman to delete because of a null error. I chased this bug for a while before I deleted that old entry.

#### Project Hosting on GitHub Pages:
When I started this project I had the grand idea that it would be hosted as a GitHub page, but obviously the server being limited to my local machine made that impossible with the current setup as the frontend wouldn't be able to talk to the backend. 

#### Javascript:
Somehow Javascript ended up being the last piece of the puzzle I learned. Like so many I started my journey into tech learning HTML & CSS. I jumped around from Python to Java and then followed the path of the bootcamp ending with Javascript. In these last few weeks (counting the days till 11/17/2023!) we'll complete Vue.js, a final project and exam! 


### Continued development

- Filter Tasks by Tags: Hopefully by already having the tag field, this won't be huge to implement. But my idea would be able to quickly grab a list of related tasks, like all #kitchen tasks to quickly have a to-do list for that tag. 

- Search Bar: Search through tasks by name, note, date created, tags etc.  

- Security & Users: I would like for individual users to be able to log in and see only their tasks. 


- GitHub Page Hosting: Initially I thought an in memory database might work, but I'm going to have to do more research to see if this is posible for me as a student. I won't be able to spend the money for some services so I'm going to have to come back to this. 




