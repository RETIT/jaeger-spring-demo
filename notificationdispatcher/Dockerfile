FROM java:8
VOLUME /tmp
ADD target/notificationdispatcher-*.jar notificationdispatcher.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/notificationdispatcher.jar"]