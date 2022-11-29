# rb-student-service

Student services to add new students and retrieve student details based on studendId
### API:
* POST - [/rakbank/api/student](/rakbank/api/student) (ADD STUDENT - check swagger for more details)
* GET - [/rakbank/api/student/{studentId}](/rakbank/api/student/{studentId}) (GET STUDENT BY STUDENT_ID - check swagger for more details)

### Useful Links
* Local Swagger URL: [http://localhost:8080/rakbank/api/student/swagger-ui.html](http://localhost:8080/rakbank/api/student/swagger-ui.html) 
* Swagger File: [https://github.com/getimran/rb-student-fee-collection/blob/master/swagger/rb-student-service-swagger.json](https://github.com/getimran/rb-student-fee-collection/blob/master/swagger/rb-student-service-swagger.json)
* Postman Collection: [https://github.com/getimran/rb-student-fee-collection/blob/master/postman/1-rb-student-service.postman_collection.json](https://github.com/getimran/rb-student-fee-collection/blob/master/postman/1-rb-student-service.postman_collection.json)

### Tech Stack
* Java 8
* Spring Boot
* Spring Data JPA
* H2 in-memory database

### Installation
**Run locally Using Intellij:**
```
git clone https://github.com/getimran/rb-student-service.git
git checkout develop
gradle clean build
gradle bootRun
```