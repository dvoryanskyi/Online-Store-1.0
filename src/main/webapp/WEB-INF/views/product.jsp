<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="kek3">
<head>
    <title>Title</title>
    <script src="/resources/js/angular.min.js"></script>
    <script src="/resources/js/script.js"></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body ng-controller="ShowProduct">
    <div class="col-sm-11 col-sm-offset-1 thumbnail text-center" style="border-radius:50%;background-color:lightgrey" >
        <h1>{{product.name}}</h1>
        <i>{{product.description}}</i>
        <p>{{product.price | currency}}</p>
        <img src={{product.imgURL}} alt="none">
        <a class="btn btn-info btn-sm" href="update/{{product.id}}">Edit</a>
        <a class="btn btn-info btn-sm" ng-href="/product/all">Back</a>
        <a class="btn btn-success btn-sm glyphicon glyphicon-shopping-cart"></a>
    </div>

</body>
</html>
