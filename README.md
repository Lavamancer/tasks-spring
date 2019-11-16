# Spring Boot

### Notas

Docker MySQL
```
docker run --name tasksdb -d -p 3310:3306 -e MYSQL_ROOT_PASSWORD=1234 -e MYSQL_DATABASE=tasksdb mariadb

docker network create tasks
docker run --name tasksdb --network tasks -d -p 3310:3306 -e MYSQL_ROOT_PASSWORD=34jk2SNP -e MYSQL_DATABASE=tasksdb mariadb
docker exec -it tasksdb bash
```

Run con Gradle
```
./gradlew bootRun -Pmysql
```
