docker build -t demo-notificationservice .\notificationservice
docker create -p 8080:8080 --name demo-notificationservice --network demo_network --hostname demo-notificationservice demo-notificationservice

docker build -t demo-customer .\customer
docker create -p 8081:8081 --name demo-customer --network demo_network --hostname demo-customer demo-customer

docker build -t demo-product .\product
docker create -p 8082:8082 --name demo-product --network demo_network --hostname demo-product demo-product

docker build -t demo-purchase .\purchase
docker create -p 8083:8083 --name demo-purchase --network demo_network --hostname demo-purchase demo-purchase

docker build -t demo-notificationdispatcher .\notificationdispatcher
docker create -p 8084:8084 --name demo-notificationdispatcher --network demo_network --hostname demo-notificationdispatcher demo-notificationdispatcher

docker start demo-customer
docker start demo-product
docker start demo-purchase
docker start demo-notificationservice
docker start demo-notificationdispatcher