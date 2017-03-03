<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" ng-app="App">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Document</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body ng-controller="GreetingController">

        <div class="container">
                <div ng-repeat="product in products" class="col-sm-3 col-sm-offset-1 thumbnail text-center" style="border-radius:50%;background-color:lightgrey">
                    <p><strong>{{product.name}}</strong></p>
                    <i>{{product.description}}</i>
                    <p>{{product.price | currency}}</p>
                    <a class="btn btn-info btn-sm">Edit</a>
                    <a class="btn btn-info btn-sm" ng-href="/product/{{product.id}}">Advance</a>
                    <a class="btn btn-success btn-sm glyphicon glyphicon-shopping-cart"></a>
                </div>


        </div>


        <jsp:include page="footer.jsp"/>



        <script src="/resources/js/angular.min.js"></script>
        <script src="/resources/js/script.js"></script>


    </body>
</html>
