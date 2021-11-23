# springboot-sample-application
## 개발환경 구성
#### Single Zookeeper, Single Kafka Cluster
- SpringBoot : 2.6.0
    
## 테스트 방법

### Spring Profile 설정
IntelliJ RUN Edit Configuration > Modify options > Add VM options 

VM options : -Dspring.profiles.active=live

- live profile port : 30000
- dev profile port : 30001 

### Endpoint 테스트
GET
~~~
curl -X GET "hhtp://localhost:30000/cirspy/app/foo"
curl -X GET "http://localhost:30000/crispy/app/users/{userId}"
curl -X GET "http://localhost:30000/crispy/app/users/{userId}"
~~~

POST
~~~
curl -X POST "http//localhost:30000/crispy/app/users/create" -d "userId={userId}"
~~~

DELETE
~~~
curl -X DELETE "http://localhost:30000/cirspy/app/users/{userId}"
~~~

## 구현 내용
Spring Boot Sample Application
- profile 설정
- endpoint controller 샘플 구현
