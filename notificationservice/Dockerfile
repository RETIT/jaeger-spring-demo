FROM java:8
VOLUME /tmp
ADD target/notificationservice-*.jar notificationservice.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/notificationservice.jar"]