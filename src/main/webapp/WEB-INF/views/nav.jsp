<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav>
    <style>
        .navbar-fixed-left {
            width: 140px;
            position: fixed;

            height: 100%;
        }

        .navbar-fixed-left .navbar-nav > li {
            float: none;  /* Cancel default li float: left */
            width: 139px;
        }

    </style>
    <div class="navbar navbar-inverse navbar-fixed-left">
        <ul class="nav navbar-nav">
            <li><a href="#">Link1</a></li>
            <li><a href="#">Link2</a></li>
            <li><a href="#">Link3</a></li>
            <li><a href="#">Link4</a></li>
            <li><a href="#">Link5</a></li>
        </ul>
    </div>
</nav>