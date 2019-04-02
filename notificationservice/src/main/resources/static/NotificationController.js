'use strict'
angular.module('notification-service').controller("NotificationController", ["$scope","$http", "constants",
    function($scope, $http, constants) {
        $scope.products = [];
        $http.get(constants.productservicehost + ":" +  constants.productserviceport + "/products").then(function(value) {
            console.log(value.data);
            $scope.products = value.data;
        });

        $scope.notifications = [];
        $scope.notificationText = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.";

        $scope.sendNotification = function(productid) {
            var startTime = new Date().getTime();
            console.log("Sending notification for: " + productid);
            $http.post(constants.notificationservicehost + ":" +  constants.notificationserviceport + "/notify/" + productid, $scope.notificationText).then(function(value) {
                var endTime = new Date().getTime();
                for(var i = 0; i < value.data.length; ++i) {
                    value.data[i].duration = (endTime - startTime) / 1000;
                }
                $scope.notifications = value.data.concat($scope.notifications).slice(0,30); // display only the last 30 notifications
                console.log(value.data);
                console.log($scope.notifications);
            });
        };
    }
]);