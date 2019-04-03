ECHO "#############################################################################################"
ECHO "### stopping containers #####"
ECHO "#############################################################################################"
docker stop demo-notificationservice
docker stop demo-customer
docker stop demo-product
docker stop demo-purchase
docker stop demo-notificationdispatcher
ECHO "#############################################################################################"
ECHO "### deleting containers #####"
ECHO "#############################################################################################"
docker rm demo-notificationdispatcher
docker rm demo-customer
docker rm demo-purchase
docker rm demo-notificationservice
docker rm demo-product