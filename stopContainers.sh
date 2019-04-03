#!/bin/bash
echo "#############################################################################################"
echo "### stopping containers"
echo "#############################################################################################"
docker stop demo-notificationservice
docker stop demo-customer
docker stop demo-product
docker stop demo-purchase
docker stop demo-notificationdispatcher
echo "#############################################################################################"
echo "### deleting containers"
echo "#############################################################################################"
docker rm demo-notificationdispatcher
docker rm demo-customer
docker rm demo-purchase
docker rm demo-notificationservice
docker rm demo-product