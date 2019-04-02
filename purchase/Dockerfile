FROM java:8
VOLUME /tmp
ADD target/purchase-*.jar purchase.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/purchase.jar"]