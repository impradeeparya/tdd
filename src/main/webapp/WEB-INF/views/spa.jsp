<!DOCTYPE html>
<html lang="en" ng-app="hr">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>HelloRoomie</title>

    <!-- CSS -->
    <link rel="stylesheet" href="webjars/bootstrap/3.3.5/css/bootstrap.css">

    <!-- theme -->
    <link rel="stylesheet" href="webjars/bootstrap/3.3.5/css/bootstrap-theme.css">
    <link rel="stylesheet" type="text/css" href="resources/css/main.css">


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<div class="top-bar">
    <div class="container">
        <a class="" href="#/">Login</a> | <a class="" href="">SignUp</a>
    </div>
</div>


<div class="navbar pad-top-10">
    <div class="container">
        <a class="navbar-brand" href="#/"></a>
        <a class="btn pull-right btn-orange" href="">Post ad</a>
    </div>
</div>

<div class="container">
    <ng-view></ng-view>
</div>

<div class="container">
    <hr>
    <footer class="footer pull-right">
        <div>
            <a href="#/">www.helloroomie.in</a>

            <div>@helloRoomie</div>
        </div>
    </footer>
</div>


<!-- jQuery -->
<script src="webjars/jquery/2.1.4/jquery.js"></script>

<!-- javaScript -->
<script type="text/javascript" src="webjars/angularjs/1.4.1/angular.js"></script>
<script type="text/javascript" src="webjars/angularjs/1.4.1/angular-route.js"></script>
<script src="webjars/angular-ui-bootstrap/0.13.0/ui-bootstrap-tpls.js"></script>

<!-- angularJs files -->
<script type="text/javascript" src="resources/js/app/app.js"></script>
<script type="text/javascript" src="resources/js/app/controllers/dashboard/dashboard.js"></script>
<script type="text/javascript" src="resources/js/app/controllers/dashboard/controllers.js"></script>
<script type="text/javascript" src="resources/js/app/services/dashboard/services.js"></script>
</body>
</html>