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

## <mark style="background: #FFB86CA6;">5- Update question by ID</mark>

### Api Contract :

### Request Example :
```

PUT : http://localhost:8080/7

Body :  {
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
```
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
```
****

## <mark style="background: #FFB86CA6;">6- Get all questions</mark>

### Api Contract :

### Request Example :
```

GET : http://localhost:8080/allQuestions

```

### Response Example :
```
[
    {
        "category": "java",
        "questionTitle": "which java keyword is used to create a subclass?",
        "option1": "class",
        "option2": "interface",
        "option3": "extends",
        "option4": "implements",
        "rightAnswer": "extends",
        "difficultyLevel": "easy"
    },
    {
        "category": "java",
        "questionTitle": "Who invented Java Programming?",
        "option1": "Guido van Rossum",
        "option2": "James Gosling",
        "option3": "Dennis Ritchie",
        "option4": "Bjarne Stroustrup",
        "rightAnswer": " James Gosling",
        "difficultyLevel": "easy"
    },
    {
        "category": "java",
        "questionTitle": "Which environment variable is used to set the java path?",
        "option1": "MAVEN_Path",
        "option2": "JavaPATH",
        "option3": "JAVA",
        "option4": "JAVA_HOME",
        "rightAnswer": "JAVA_HOME",
        "difficultyLevel": "easy"
    },
    {
        "category": "java",
        "questionTitle": "Which of the following is not an OOPS concept in Java?",
        "option1": "Polymorphism",
        "option2": "Inheritance",
        "option3": "Compilation",
        "option4": "Encapsulation",
        "rightAnswer": "Compilation",
        "difficultyLevel": "easy"
    },
    {
        "category": "java",
        "questionTitle": "Which exception is thrown when java is out of memory?",
        "option1": "MemoryError",
        "option2": "OutOfMemoryError",
        "option3": "MemoryOutOfBoundsException",
        "option4": "MemoryFullException",
        "rightAnswer": " OutOfMemoryError",
        "difficultyLevel": "easy"
    },
    {
        "category": "java",
        "questionTitle": "Which of these are selection statements in Java?",
        "option1": "break",
        "option2": "continue",
        "option3": "for()",
        "option4": "if()",
        "rightAnswer": "if()",
        "difficultyLevel": "easy"
    },
    {
        "category": "python",
        "questionTitle": "Which type of Programming does Python support?",
        "option1": "object-oriented programming",
        "option2": "structured programming",
        "option3": "functional programming",
        "option4": " all of the mentioned",
        "rightAnswer": " all of the mentioned",
        "difficultyLevel": "easy"
    },
    {
        "category": "python",
        "questionTitle": "Is Python case sensitive when dealing with identifiers?",
        "option1": " no",
        "option2": "yes",
        "option3": "machine dependent",
        "option4": "none of the mentioned",
        "rightAnswer": "yes",
        "difficultyLevel": "easy"
    },
    {
        "category": "python",
        "questionTitle": "All keywords in Python are in _________",
        "option1": "Capitalized",
        "option2": "lower case",
        "option3": "UPPER CASE",
        "option4": "None of the mentioned",
        "rightAnswer": "None of the mentioned",
        "difficultyLevel": "easy"
    },
    {
        "category": "python",
        "questionTitle": "Which keyword is used for function in Python language?",
        "option1": "Function",
        "option2": "def",
        "option3": "Fun",
        "option4": "Define",
        "rightAnswer": "def",
        "difficultyLevel": "easy"
    },
    {
        "category": "python",
        "questionTitle": " Which of the following functions can help us to find the version of python that we are currently working on?",
        "option1": "sys.version(1)",
        "option2": "sys.version(0)",
        "option3": "sys.version()",
        "option4": "sys.version",
        "rightAnswer": "sys.version",
        "difficultyLevel": "easy"
    },
    {
        "category": "python",
        "questionTitle": " Python supports the creation of anonymous functions at runtime, using a construct called __________",
        "option1": "pi",
        "option2": "anonymous",
        "option3": "lambda",
        "option4": "none of the mentioned",
        "rightAnswer": "lambda",
        "difficultyLevel": "easy"
    },
    {
        "category": "python",
        "questionTitle": "Which of the following is true for variable names in Python?",
        "option1": "underscore and ampersand are the only two special characters allowed",
        "option2": "unlimited length",
        "option3": " all private members must have leading and trailing underscores",
        "option4": "none of the mentioned",
        "rightAnswer": "unlimited length",
        "difficultyLevel": "easy"
    },
    {
        "category": "java",
        "questionTitle": "Which of the below is not a Java Profiler?",
        "option1": "JProfiler",
        "option2": "Eclipse Profiler",
        "option3": "JVM",
        "option4": "JConsole",
        "rightAnswer": "JVM",
        "difficultyLevel": "hard"
    },
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
]
```
****

## <mark style="background: #FFB86CA6;">7- Get questions by category</mark>

### Api Contract :

### Request Example :
```

GET : http://localhost:8080/api/python

```

### Response Example :
```
[
    {
        "category": "python",
        "questionTitle": "Which type of Programming does Python support?",
        "option1": "object-oriented programming",
        "option2": "structured programming",
        "option3": "functional programming",
        "option4": " all of the mentioned",
        "rightAnswer": " all of the mentioned",
        "difficultyLevel": "easy"
    },
    {
        "category": "python",
        "questionTitle": "Is Python case sensitive when dealing with identifiers?",
        "option1": " no",
        "option2": "yes",
        "option3": "machine dependent",
        "option4": "none of the mentioned",
        "rightAnswer": "yes",
        "difficultyLevel": "easy"
    },
    {
        "category": "python",
        "questionTitle": "All keywords in Python are in _________",
        "option1": "Capitalized",
        "option2": "lower case",
        "option3": "UPPER CASE",
        "option4": "None of the mentioned",
        "rightAnswer": "None of the mentioned",
        "difficultyLevel": "easy"
    },
    {
        "category": "python",
        "questionTitle": "Which keyword is used for function in Python language?",
        "option1": "Function",
        "option2": "def",
        "option3": "Fun",
        "option4": "Define",
        "rightAnswer": "def",
        "difficultyLevel": "easy"
    },
    {
        "category": "python",
        "questionTitle": " Which of the following functions can help us to find the version of python that we are currently working on?",
        "option1": "sys.version(1)",
        "option2": "sys.version(0)",
        "option3": "sys.version()",
        "option4": "sys.version",
        "rightAnswer": "sys.version",
        "difficultyLevel": "easy"
    },
    {
        "category": "python",
        "questionTitle": " Python supports the creation of anonymous functions at runtime, using a construct called __________",
        "option1": "pi",
        "option2": "anonymous",
        "option3": "lambda",
        "option4": "none of the mentioned",
        "rightAnswer": "lambda",
        "difficultyLevel": "easy"
    },
    {
        "category": "python",
        "questionTitle": "Which of the following is true for variable names in Python?",
        "option1": "underscore and ampersand are the only two special characters allowed",
        "option2": "unlimited length",
        "option3": " all private members must have leading and trailing underscores",
        "option4": "none of the mentioned",
        "rightAnswer": "unlimited length",
        "difficultyLevel": "easy"
    }
]
```
****

## <mark style="background: #FFB86CA6;">8- Get questions by category and difficultyLevel</mark>

### Api Contract :

### Request Example :
```

GET : http://localhost:8080/api/java/easy

```

### Response Example :
```
[
    {
        "category": "java",
        "questionTitle": "which java keyword is used to create a subclass?",
        "option1": "class",
        "option2": "interface",
        "option3": "extends",
        "option4": "implements",
        "rightAnswer": "extends",
        "difficultyLevel": "easy"
    },
    {
        "category": "java",
        "questionTitle": "Who invented Java Programming?",
        "option1": "Guido van Rossum",
        "option2": "James Gosling",
        "option3": "Dennis Ritchie",
        "option4": "Bjarne Stroustrup",
        "rightAnswer": " James Gosling",
        "difficultyLevel": "easy"
    },
    {
        "category": "java",
        "questionTitle": "Which environment variable is used to set the java path?",
        "option1": "MAVEN_Path",
        "option2": "JavaPATH",
        "option3": "JAVA",
        "option4": "JAVA_HOME",
        "rightAnswer": "JAVA_HOME",
        "difficultyLevel": "easy"
    },
    {
        "category": "java",
        "questionTitle": "Which of the following is not an OOPS concept in Java?",
        "option1": "Polymorphism",
        "option2": "Inheritance",
        "option3": "Compilation",
        "option4": "Encapsulation",
        "rightAnswer": "Compilation",
        "difficultyLevel": "easy"
    },
    {
        "category": "java",
        "questionTitle": "Which exception is thrown when java is out of memory?",
        "option1": "MemoryError",
        "option2": "OutOfMemoryError",
        "option3": "MemoryOutOfBoundsException",
        "option4": "MemoryFullException",
        "rightAnswer": " OutOfMemoryError",
        "difficultyLevel": "easy"
    },
    {
        "category": "java",
        "questionTitle": "Which of these are selection statements in Java?",
        "option1": "break",
        "option2": "continue",
        "option3": "for()",
        "option4": "if()",
        "rightAnswer": "if()",
        "difficultyLevel": "easy"
    }
]
```
****

## <mark style="background: #FFB86CA6;">9- Create quiz API</mark>

### Api Contract :

### Request Example :
```

PUT : http://localhost:8080/quiz?category=java&numOfQues=5&title=Jquiz


```

### Response Example :
```
success
```
****

## <mark style="background: #FFB86CA6;">10- Get questions of quiz by quizID</mark>

### Api Contract :

### Request Example :
```

GET : http://localhost:8080/QuizQuestions/18


```

### Response Example :
```
[
    {
        "category": "java",
        "questionTitle": "Which environment variable is used to set the java path?",
        "option1": "MAVEN_Path",
        "option2": "JavaPATH",
        "option3": "JAVA",
        "option4": "JAVA_HOME",
        "rightAnswer": null,
        "difficultyLevel": "easy"
    },
    {
        "category": "java",
        "questionTitle": "Which of these are selection statements in Java?",
        "option1": "break",
        "option2": "continue",
        "option3": "for()",
        "option4": "if()",
        "rightAnswer": null,
        "difficultyLevel": "easy"
    },
    {
        "category": "java",
        "questionTitle": "Which of the following is not an OOPS concept in Java?",
        "option1": "Polymorphism",
        "option2": "Inheritance",
        "option3": "Compilation",
        "option4": "Encapsulation",
        "rightAnswer": null,
        "difficultyLevel": "easy"
    }
]
```
****

## <mark style="background: #FFB86CA6;">11- Submit answers of quiz</mark>

### Api Contract :

### Request Example :
```

PUT : http://localhost:8080/submission/18

Body :["JAVA_HOME","No","MemoryFullException"]


```

### Response Example :
```
1
```






