var app = angular.module('kek',[]);

app.controller("AddProduct",function ($scope,$http) {
    $scope.product = {};

    $scope.add = function(product,aForm){
        if(aForm.$valid){
            $http.post('http://localhost:8080/product/add', product);
        }
    };


});
