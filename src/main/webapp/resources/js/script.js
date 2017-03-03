var app = angular.module('App',[]);


app.controller('GreetingController', ['$scope','$http', function($scope,$http) {


    $scope.products = [];

    $http.get('http://localhost:8080/product/find-all').then(function (response) {
        $scope.products = response.data;
    });

    $scope.greeting = 'Hola!';





}]);