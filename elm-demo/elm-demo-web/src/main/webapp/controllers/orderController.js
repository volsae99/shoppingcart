angular.module("elmDemo")
.constant("ordersUrl", "http://localhost:8080/elm-demo-web/api/orders")
.controller("ordersCtrl", function ($scope, $http, ordersUrl) {

    $http.get(ordersUrl)
        .success(function (data) {
            $scope.orders = data;
        })
        .error(function (error) {
            $scope.error = error;
        });

    $scope.selectedOrder;

    $scope.selectOrder = function (order) {
        $scope.selectedOrder = order;
    };

    $scope.calcTotal = function (order) {
        var total = 0;
        for (var i = 0; i < order.products.length; i++) {
            total +=
                order.products[i].quantity * order.products[i].price;
        }
        return total;
    }
});
