# Korber Pharma Backend Challenge
## DOT - Department of Transportation

Considerations:

Due to time constraints all requirements where implemented,
but not all features were implemented.

The endpoints /top-zones and /zone-trips were left to be implemented.

Not used to working with Spring-boot, in my job I use Quarkus, but anyway I
decided to use spring to this challenge.

### Dev
How to run the application, first:

1. Start containers
````bash
$ docker-compose up -d
````

2. Run application
````bash
$ mvn spring-boot:run
````

3. Import the files, firstly the zones file and then the others (yellow..., green...)

### Tests

Unit tests were implemented with TestContainers to be able to create a new database
only for the test usage using flyway asswell to put default data to be used.

### Api documentation 

Swagger Ui
http://localhost:8080/swagger-ui/#/

Swagger Json
http://localhost:8080/v2/api-docs

Postman Collection
https://documenter.getpostman.com/view/9285303/VUxKS99X


