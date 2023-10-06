# QuizAppProject
This is a sample Java / Maven / Spring Boot (version 2.7.14) application that aims to ثnables the user to perform quizes in various versions related to programming if he is a student , and put quiz if he is a trainer.
## About the Service
Her is the services that application contains:

1- Enable user to insert new question if he/she is trainer.

2- Enable User to delete question.

3- Enable user to update question.

4- Enable user to get specific question with specific ID.

5-Enable user to get all questions.

6-Enable user to get some questions with specific category.

7-Enable user to get questions with specific category and difficulty level.

8-Enable user to create quiz if he/she is a trainer.

9-Enable user to get questions of specific quiz.

10-Enable user to submit his/her answer.

11-Enable user to register to application.

12-Enable user to login to the application.

## Adding the dependency
 
If you are using Maven, add the following dependency.  


```xml
<dependencies>
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-api</artifactId>
			<version>0.11.5</version>
		</dependency>
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-impl</artifactId>
			<version>0.11.5</version>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-jackson</artifactId>
			<version>0.11.5</version>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
		<dependency>
			<groupId>org.junit.platform</groupId>
			<artifactId>junit-platform-launcher</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
			<version>2.5.0</version>
		</dependency>
	</dependencies>
```
## Steps to run
1. Build the project using
  `mvn clean install`
2. Make sure you are using JDK 18 and Maven 2.x
3. Run using `mvn spring-boot:run`
4. The web application is accessible via localhost:8080## Steps to run
Once the application runs you should see something like this

```
2023-08-29 04:54:49.833  INFO 14096 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-08-29 04:54:50.325  INFO 14096 --- [           main] f.C.CurrencyConversionProjectApplication : Started CurrencyConversionProjectApplication in 6.646 seconds (JVM running for 7.43)

```
## Tools & Technologies💡
1-Programming Language: Java 17.

2-Backend Framework: Spring Boot v2.7.14.

3-Logger: SLF4J.

4-Actuator.

5-Docker.

6-Login & Registration.

7-Authentication & Authorization.



## Architecture of Quiz Application API

## <mark style="background: #FFB86CA6;">1- regesteration Api</mark>

### Api Contract :

### Request Example :
```
POST : http://localhost:8080/api/auth/register

Body : {
         "userNameOrEmail":"marwa",
         "password":"marwa0011"
       }
```

### Response Example :
```
{
    "userName": "marwa",
    "email": "marwa",
    "role": "ROLE_USER"
}
```

****

## <mark style="background: #FFB86CA6;">2- Login API</mark>

### Api Contract :
### Request Example :
```
POST : http://localhost:8080/api/auth/login

Body : {
    "userNameOrEmail":"mariam",
    "password":"mariam292000",
    "confirmPassword":"mariam292000"
       }
```

### Response Example :
```
{
    "userName": "mariam",
    "email": "mariam",
    "role": "ROLE_USER",
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjEsImVtYWlsIjoibWFyaWFtIiwic3ViIjoibWFyaWFtIiwiaWF0IjoxNjk2NTQ5NDA4LCJleHAiOjE2OTY1NTA4NDh9.vMdhChMQY8EmP4hYwRYfPh-xLVqHQjN35DxOmp8PP1I",
    "authenticated": true
}
```

****

## <mark style="background: #FFB86CA6;">3- adding new question API</mark>

### Api Contract :

### Request Example :
```

POST : http://localhost:8080/newQuestion

Body : {
    "category":"java",
    "questionTitle":"Which of the below is not a Java Profiler?",
    "option1":"JProfiler",
    "option2":"Eclipse Profiler",
    "option3":"JVM",
    "option4":"JConsole",
    "rightAnswer":"JVM",
    "difficultyLevel":"hard"
}
```

### Response Example :
```
{
    "category": "java",
    "questionTitle": "Which of the below is not a Java Profiler?",
    "option1": "JProfiler",
    "option2": "Eclipse Profiler",
    "option3": "JVM",
    "option4": "JConsole",
    "rightAnswer": "JVM",
    "difficultyLevel": "hard"
}
```

****

## <mark style="background: #FFB86CA6;">4- Get question by ID</mark>

### Api Contract :

### Request Example :
```

GET : GET : http://localhost:8080/7

```

### Response Example :
```
{
    "category": "java",
    "questionTitle": "Which of the following is a type of polymorphism in Java Programming?",
    "option1": "Multiple polymorphism",
    "option2": "Compile time polymorphism",
    "option3": "Multilevel polymorphism",
    "option4": "Execution time polymorphism",
    "rightAnswer": "Compile time polymorphism",
    "difficultyLevel": "easy"
}
```



****


## <mark style="background: #FFB86CA6;">4- Update question by ID</mark>

### Api Contract :


### Request Example :
```
PUT : http://localhost:8080/7

Body : {
    "category": "java",
    "questionTitle": "Which of the following is a type of polymorphism in Java Programming?",
    "option1": "Multiple polymorphism",
    "option2": "Compile time polymorphism",
    "option3": "Multilevel polymorphism",
    "option4": "Execution time polymorphism",
    "rightAnswer": "Compile time polymorphism",
    "difficultyLevel": "hard"
}
```

### Response Example :
```json
{
    "category": "java",
    "questionTitle": "Which of the following is a type of polymorphism in Java Programming?",
    "option1": "Multiple polymorphism",
    "option2": "Compile time polymorphism",
    "option3": "Multilevel polymorphism",
    "option4": "Execution time polymorphism",
    "rightAnswer": "Compile time polymorphism",
    "difficultyLevel": "hard"
}


