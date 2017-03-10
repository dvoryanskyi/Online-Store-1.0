var app = angular.module('kek', []);

app.controller("AddProduct", function ($scope, $http,$window) {
    $scope.product = {};
    $scope.kkk = {};




    $scope.add = function (product, aForm) {
        if (aForm.$valid) {
            $http.post('http://localhost:8080/product/img',document.getElementById('kkk').files[0]);
            alert(aForm);
            debugger;
            $http.post('http://localhost:8080/product/add', product);
            $window.location.href = '/product/all';
        }
    };


});

var app = angular.module('kek1', []);

app.controller("UpdateProduct", function ($scope, $http, $location,$window) {
    $scope.product = {};
    var url = $location.absUrl();
    $http.get(url + '.json').then(function (response) {
        $scope.product = response.data;
    });



    $scope.update = function (product, aForm) {
        if (aForm.$valid) {
            $http.post('http://localhost:8080/product/update', product);

            $window.location.href = '/product/all';
        }
    };
});

