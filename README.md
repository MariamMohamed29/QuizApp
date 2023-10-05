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

## Architecture of Currency Conversion API

## <mark style="background: #FFB86CA6;">1- pair-conversion Api</mark>

### Api Contract :
```
GET : {base_url}/pair-conversion
	?base={base_currency}
	&target={target_currency}
	&amount={amount}
```

### Request Example :
```
GET : localhost:8080/pair-conversion
	?base=USD
	&target=EGP
	&amount=222
```

### Response Example :
```
{
    "statusCode": 200,
    "data": {
        "conversion_result": 6860.133
    }
}
```

****

## <mark style="background: #FFB86CA6;">2- comparison API</mark>

### Api Contract :
```
GET : {base_url}/comparison
	?base={base_currency}
	&target1={target_currency_1}
	&target={target_currency_2}
	&amount={amount}
```

### Request Example :
```
GET : localhost:8080/comparison
	?base=USD
	&target1=EUR
	&target2=EGP
	&amount=222
```

### Response Example :
```
{
    "statusCode": 200,
    "data": {
        "firstTargetCurrency": {
            "conversion_result": 205.6164
        },
        "secondTargetCurrency": {
            "conversion_result": 6860.133
        }
    }
}
```

****

## <mark style="background: #FFB86CA6;">3- Favorite currencies Api</mark>

### Api Contract :

***POST : to send request body for all currencies .***

```

POST : {base_url}/favorite-currencies
	?base={base_currency}

Body : [
         "EGP",
	 "EUR",
         "SAR"
       ]
```

### Request Example :
```
// For example : we have USD and 3 currencies as favorites : EGP, EUR, SAR

POST : localhost:8080/favorite-currencies
	?base=USD

Body : [
	"EGP",
	"EUR",
        "SAR"
       ]	
```

### Response Example :
```
{
    "statusCode": 200,
    "status": "success",
    "data": [
        30.9,
        0.9248,
        3.75
    ]
}
```


****

## <mark style="background: #FFB86CA6;">4- Get All Currencies Api</mark>

### Api Contract :
```
GET : {base_url}/currencies
```

### Request Example :
```
GET : localhost:8080/currencies
```

### Response Example :
```json
{
    "statusCode": 200,
    "data": [
        {
            "code": "EUR",
            "name": "Europe Union",
            "flagUrl": "*********"
        },
        {
            "code": "USD",
            "name": "United States",
            "flagUrl": "*********"
        }
    ]
}

