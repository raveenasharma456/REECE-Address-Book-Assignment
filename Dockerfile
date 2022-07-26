#define base docker image
From openjdk:8
LABEL maintainer="javaguides.net"
ADD target/addressbook-0.0.1-SNAPSHOT.jar addressBook-docker.jar
ENTYPOINT ["java",".jar","addressBook-docker.jar"]