<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="ru.tsystems.ecare.persistence.entities.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>My Info</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <!-- Custom styles for this template -->
        <link href="/ECare/resources/css/starter-template.css" rel="stylesheet">
        <!-- favicon -->
        <link rel="icon" href="/ECare/resources/graphic/favicon.ico">
        <!-- Custom styles for login form -->
        <link href="/ECare/resources/css/signin.css" rel="stylesheet">
        <!-- Optional: Include the jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <!-- Optional: Incorporate the Bootstrap JavaScript plugins -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="navbar.jsp" />
        <h1>My information</h1>
        <div class="container">
            <form class="form" role="form" method="post">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Name</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${person.name}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Surame</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${person.surname}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${person.email}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label"><a href="/ECare/employee" class="btn btn-default btn-lg" role="button">Home</a></label>
                    <div class="col-sm-10">
                        <p class="form-control-static"> </p>
                    </div>
                </div>
            </form>
        </div> <!-- /container -->
        <div class="container">
            <p class="text-danger text-center">${message}</p>
        </div>
    </body>
</html>