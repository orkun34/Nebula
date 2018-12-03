FROM java:8
LABEL maintainer=“nebula_app@gmail.com”
EXPOSE 8282
ADD ./target/Nebula-0.1-SNAPSHOT.jar Nebula-0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Dspring.profiles.active=container","-jar","Nebula-0.1-SNAPSHOT.jar"]