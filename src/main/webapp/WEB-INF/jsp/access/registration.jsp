<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" href="resources/graphic/favicon.ico">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <!-- Custom styles for login form -->
        <link href="/ECare/resources/css/signin.css" rel="stylesheet">
        <!-- Optional: Include the jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <!-- Optional: Incorporate the Bootstrap JavaScript plugins -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <title>Registration</title>
    </head>

    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/ECare">ECare</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="login">Login</a></li>
                        <li class="active"><a href="registration">Registration</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>
        <div class="container">

            <form class="form-signin" role="form" action="finishRegistration" method="post">
                <h2 class="form-signin-heading">Please fill all fields</h2>
                <label for="name" class="sr-only">Name</label>
                <input type="text" id="name" name="name"
                       class="form-control" placeholder="Name" required autofocus>
                <label for="surname" class="sr-only">Surname</label>
                <input type="text" id="surname" name="surname"
                       class="form-control" placeholder="Surname" required>
                <label for="birthdate" class="sr-only">Birthdate</label>
                <input type="date" id="birthdate" name="birthdate"
                       class="form-control" placeholder="YYYY-MM-DD" required>
                <label for="passport" class="sr-only">Passport</label>
                <input type="text" id="passport" name="passport"
                       class="form-control" placeholder="Passport number" required>
                <label for="address" class="sr-only">Address</label>
                <input type="text" id="address" name="address"
                       class="form-control" placeholder="Address" required>
                <input type="email" id="email" name="email"
                       class="form-control" placeholder="Email address" required>
                <label for="password" class="sr-only">Password</label>
                <input type="password" id="password" name="password"
                       class="form-control" placeholder="Password" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
            </form>
        </div> <!-- /container -->
        <p class="text-danger text-center">${message}</p>
        <div class="container">
            <p class="text-center">
                If you already have registration, please <a href="login">login</a>.
            </p>
        </div>
    </body>
</html>