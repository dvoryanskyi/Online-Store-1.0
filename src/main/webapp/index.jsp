<html ng-app='kek'>
<head>
    <title>Title</title>
    <script src="resources/js/angular.min.js"></script>
    <script src="resources/js/1script.js"></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<h2>Hello World!</h2>
<div class="content">{{5+9}}</div>
<div ng-controller="AddProduct" class="container">
    <form name="aForm" >
        <input type="text" ng-model="product.name" required>
        <input type="number" ng-model="product.price" required min="0">
        <input type="text" ng-model="product.description" required>
        <input type="submit" ng-click="add(product,aForm)" class="btn btn-success">
    </form>
</div>
</body>
</html>
