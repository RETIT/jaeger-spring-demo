FROM java:8
VOLUME /tmp
ADD target/product-*.jar product.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/product.jar"]