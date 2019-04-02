FROM java:8
VOLUME /tmp
ADD target/customer-*.jar customer.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/customer.jar"]