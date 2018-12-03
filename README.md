# Nebula

Project Nebula is a kind of product review check application that handles inappropriate words which comes from client review.

Modules that are used in projects are;
 - spring-boot
 - spring-amqp
 - spring-data-jpa
 - log4j2.xml
 - mysql

##### Default Queue Definitions
There are 2 queues which are **requestQueue** and **dbQueue**. These are defined static final in src/main/com/nebula/review/common/NebulaConstant.java

#### Legacy usage (default property)
If rabbitmq(port:15672) and some modules of mysql(port:3306) already install in your localhost , do followings;
 - Run /db/adventureworks_productreview.sql in your SQL window of MYSQL
 - After that run below command in project direcotry
```sh
mvn spring-boot:run
```
#### Docker usage
Run below command in order
```sh
mvn clean install
docker-compose up nebula-mysql
docker-compose up nebula-rabbitmq
docker-compose up nebula-app
```
(Actually I provided depedency for nebula-app that belongs to nebula-mysql and nebula-rabbitmq , but didn't work. Therefore better to run them in order in project folder)
##### Key notes
There are 3 Dockerfile and 1 sql script;
 * In project direcotory
 * /mysql (for mysql)
 * /rabbit (for rabbit)
 * /db (for db migration)

### REST usage
Endpoint is (http:// localhost:<RUNNING_PORT>/api/reviews) and works with POST method

Sample request
```json
- {"name":"Garry Jackson","email":"gary_jackson@gmail.com","productId":"1231","review":"Nice stuff bro..!"}
```
Sample response
```json
- {"success":"true","reviewId":"999"}
```

##### application.properties
Log file can be configured in /src/main/resources/application.properties