<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class=" navbar  navbar-fixed-top navbar-inverse text-success">
        <strong>This is Header</strong>
        <a href="" class="btn btn-info">Button</a>
        <a href="" class="btn btn-info">Button</a>
        <form>
                <input type="text" ng-model="searchtext" placeholder="Search">
                <input type="submit" ng-click="find(searchtext)" class="btn btn-success">
        </form>
</header>
