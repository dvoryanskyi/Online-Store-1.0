var app = angular.module('App',[]);


app.controller('GreetingController', ['$scope','$http', function($scope,$http) {


    $scope.products = [];

    $http.get('http://localhost:8080/product/find-all').then(function (response) {
        $scope.products = response.data;
    });

    $scope.greeting = 'Hola!';


    $scope.searchtext = '';
    $scope.find = function (searchtext) {
        $http.post('http://localhost:8080/product/find-by-text',searchtext).then(function (response) {
            $scope.products = response.data;
        });
    };


}]);


var app = angular.module('kek3', []);
app.controller('ShowProduct',function ($scope, $http, $location) {
    $scope.product = {};
    var url = $location.absUrl();
    $http.get(url + '.json').then(function (response) {
        $scope.product = response.data;
        console.log($scope)
    });
});