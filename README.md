# Demo Letter Service

A demo application comprised of a set of Java/Spring based micro services, demonstrating Opentracing with Jaeger. Simulate dispatching of letters through a web UI to all customers who purchased a certain product and find bottlenecks in the application using the collected traces.

The services are built using Spring boot and instrumented using Jaeger's Opentracing implementation through the [spring web starter](https://github.com/opentracing-contrib/java-spring-jaeger "Spring web starter github repo") contribution.  

## Getting started

Prerequisites:

* JDK 1.8
* Maven
* Docker

First, create the docker "demo_network":

    docker network create --driver bridge demo_network 

Run the all-in-one Jagertracing docker container in the "demo_network" (refer to [Jaeger documentation](https://www.jaegertracing.io/docs/1.8/getting-started "Jaeger documentation") for more details):

    docker run -d --name jaeger -e COLLECTOR_ZIPKIN_HTTP_PORT=9411 -p 5775:5775/udp -p 6831:6831/udp -p 6832:6832/udp -p 5778:5778 -p 16686:16686 -p 14268:14268 -p 9411:9411 --network="demo_network" jaegertracing/all-in-one:1.10
    
The Jaeger UI may be accessed on [http://localhost:16686](http://localhost:16686/ "Jaeger UI").

In order to start the notification service demo, run the following script:

    .\startAll.bat (./startAll.sh)
    
It will build the Spring applications, create Docker images and containers and start the containers. The demo application UI lives under [http://localhost:8080/index.html](http://localhost:8080/index.html "Letter service"). 
The containers will be running in the Docker bridge network "demo_network", just as the Jaegertracing applications. They will also expose their ports to the host.

In order to stop the applications and delete the containers, run:

     .\stopContainers.bat (./stopContainers.sh)
     
Commands for stopping the all-in-one Jaeger container and removing the network:

     docker stop jaeger
     docker network rm demo_network
