REM #############################################################################################
REM ### build applications with maven
REM #############################################################################################
call .\buildProjects.bat

REM #############################################################################################
REM ### create docker bridge "demo_network" and run the jaeger all-in-one docker container in it.
REM #############################################################################################
docker run -d --name jaeger -e COLLECTOR_ZIPKIN_HTTP_PORT=9411 -p 5775:5775/udp -p 6831:6831/udp -p 6832:6832/udp -p 5778:5778 -p 16686:16686 -p 14268:14268 -p 9411:9411 --network="demo_network" jaegertracing/all-in-one:1.10

REM #############################################################################################
REM ### build docker images from applications, create containers and start them in
REM #############################################################################################
call .\startContainers.bat