<%@page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@page import="ru.tsystems.ecare.persistence.entities.Customer"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Home page</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <!-- Custom styles for this template -->
        <link href="/ECare/resources/css/starter-template.css" rel="stylesheet">
        <!-- favicon -->
        <link rel="icon" href="/ECare/resources/graphic/favicon.ico">
        <!-- Optional: Include the jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <!-- Optional: Incorporate the Bootstrap JavaScript plugins -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <c:choose>
            <c:when test="${locked}">
                <p>You are currently logged-in as
                    <span id="username">${userName}</span>!
                </p>
                <div class="container">
                    <h4>Your account is locked!</h4>
                    <h4><a href="/ECare/logout">Logout</a></h4>
                </div>
            </c:when>
            <c:otherwise>
                <jsp:include page="navbar.jsp" />
                <h1 id="banner">Customer's control panel</h1>

                <hr>

                <p>You are currently logged-in as
                    <span id="username">${userName}</span>!
                </p>
                <div class="col-lg-6">
                    <h4>You can:</h4>
                    <h5><a href="/ECare/customer/allContracts">View all contracts</a></h5>
                    <h5><a href="/ECare/customer/allTariffs">View all available tariffs</a></h5>
                    <h5><a href="/ECare/customer/allOptions">View all available options</a></h5>
                </div>
                <div class="container">
                    <p class="text-danger text-center">${message}</p>
                </div>
            </c:otherwise>
        </c:choose>
    </body>
</html>