<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" href="resources/graphic/favicon.ico">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <!-- Custom styles for this template -->
        <link href="resources/css/signin.css" rel="stylesheet">
        <!-- Optional: Include the jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <!-- Optional: Incorporate the Bootstrap JavaScript plugins -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <title>Login</title>
    </head>

    <body>
        <div class="container">

            <form class="form-signin" role="form" action="j_spring_security_check" method="post">
                <h2 class="form-signin-heading">Please sign in</h2>
                <label for="j_username" class="sr-only">Email address</label>
                <input type="email" id="j_username" name="j_username"
                       class="form-control" placeholder="Email address" required autofocus>
                <label for="j_password" class="sr-only">Password</label>
                <input type="password" id="j_password" name="j_password"
                       class="form-control" placeholder="Password" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            </form>

        </div> <!-- /container -->

        <p class="text-danger text-center">${message}</p>
        <div class="container">
            <p class="text-center">
                If you haven't registered yet, please proceed to
                <a href="registration" >registration</a>.
            </p>
        </div>
    </body>
</html>