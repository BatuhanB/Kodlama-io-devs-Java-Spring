<div align="center">
<h1>Kodlama.io.devs</h1>
<img width="200" height="200" src="https://user-images.githubusercontent.com/56514839/200259435-347a3bdd-e062-4338-b2e3-21f86c547106.png"/>
</br>
<h3>What have been used for this project ?</h3>
<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/>
<img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/>
<img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white"/>
</div>

<div align="center">
    
  <code>If you like to my project please give a star </code>
  </br>
  <code>Also i would like to get feedbacks! 😊</code>
  </br>
  </br>
  <img src="https://user-images.githubusercontent.com/56514839/200272997-0aa54c5d-a173-4842-8366-352ff273af53.gif" width="150" height="150"/>
</div>

<div align="left">

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.5/maven-plugin/reference/html/#build-image)
* [Validation](https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#io.validation)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#web)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#using.devtools)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#data.sql.jpa-and-spring-data)

### Guides

The following guides illustrate how to use some features concretely:

* [Validation](https://spring.io/guides/gs/validating-form-input/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

> ## Project Requirements
### | Requirement 1 |
- [x] **System must hold programming languages**
- [x] Write an architecture that need to do basic CRUD operations for programming languages
- [x] Programming Language name cannot be repeated
- [x] Programming Language name connot be empty (Not using Library, Write your own code for algoritm)

### | Requirement 2 |
- [x] **System must hold technologies of programming languages**
1. **etc.** Java : Spring, JSP.
2. **etc.** C#: WPF, ASP.NET.
3. **etc.** JavaScript : Vue, React.
- [x] Build a realtionship between programming languages and technologies
- [x] Add postgresql for database

</br>

  > ## Endpoints

  <ul>
    <b><li>| Programming Language |</li></b>
    <ul>
      <li>| api/v1/programminglanguages/getall</li>
      <li>| api/v1/programminglanguages/getallwithtechnologies</li>
      <li>| api/v1/programminglanguages/getbyid/{id}</li>
      <li>| api/v1/programminglanguages/getbyname/{name}</li>
      <li>| api/v1/programminglanguages/add</li>
      <li>| api/v1/programminglanguages/delete/{id}</li>
      <li>| api/v1/programminglanguages/update/{id}</li>
    </ul>
   <b><li>| Technology |</li></b>
    <ul>
      <li>| api/v1/technology/getall</li>
      <li>| api/v1/technology/getallwithlanguages</li>
      <li>| api/v1/technology/getbyid/{id}</li>
      <li>| api/v1/technology/getbyname/{name}</li>
      <li>| api/v1/technology/add</li>
      <li>| api/v1/technology/delete/{id}</li>
      <li>| api/v1/technology/update/{id}</li>
    </ul>
  </ul>
</br>

  > ## Project Structure
  
  <ul>
    <li>
      <p>main</p>
       <ul>
          <li><p>--> controllers</p></li>
               <li><p>--> models</p>          </li>
              <li> <p>--> repositories</p>          </li>
              <li> <p>--> services |</p>          </li>
              <ul>
                <li> <p> -programming Language</p></li>
                <ul>
                    <li>commands</li>
                    <li>constants</li>
                    <li>queries</li>
                    <li>mapper</li>
                    <b><li>programmingLanguageService</li></b>
                  </ul>
                <li> <p> -technology</p></li>
                  <ul>
                    <li>commands</li>
                    <li>constants</li>
                    <li>queries</li>
                    <li>mapper</li>
                    <b><li> technologyService</li></b>
                  </ul>
              </ul>
       </ul>
    </li>
  </ul>

</div>

## Project Endpoint Images
![image](https://user-images.githubusercontent.com/56514839/200272692-3b306d90-8eb4-4c01-8e78-dffbf10ae2df.png)

