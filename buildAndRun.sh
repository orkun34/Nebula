mvn clean install
docker-compose build
docker-compose up
#docker run -p 3366:3366 --name docker-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=adventureworks -e MYSQL_USER=nebula -e MYSQL_PASSWORD=password -d nebula_nebula-mysql:latest
#docker run -p 8087:8087 --name nebula-app -d nebula_nebula-app:latest link docker-mysql
#docker run -p 5666:5666 --name rabbitmq-app -d
#docker run -d --hostname my-rabbitmq --name  rabbitmq-app
