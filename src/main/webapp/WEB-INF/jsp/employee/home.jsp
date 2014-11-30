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
        <title>Employee's control page</title>
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
    <jsp:include page="navbar.jsp" />
        <h1 id="banner">Employee's control panel</h1>
        <hr>

        <p>You are currently logged-in as
            <span id="username">${userName}</span>!
        </p>
        <div class="col-lg-6">
            <h4>Manage customers and contracts</h4>

            <h5><a href="/ECare/employee/searchCustomer">Search customer</a></h5>
            <h5><a href="/ECare/employee/allCustomers">View all customers</a></h5>
            <h5><a href="/ECare/employee/allContracts">View all contracts</a></h5>
            <h5><a href="/ECare/employee/newCustomer">Register new customer</a></h5>
        </div>
        <div class="col-lg-6">
            <h4>Manage tariffs and options</h4>
            <h5><a href="/ECare/employee/allTariffs">View all tariffs</a></h5>
            <h5><a href="/ECare/employee/tariff">Create new tariff</a></h5>
            <h5><a href="/ECare/employee/allOptions">View all options</a></h5>
            <h5><a href="/ECare/employee/option">Create new option</a></h5>
        </div>
        <div class="container">
            <p class="text-danger text-center">${message}</p>
        </div>
    </body>
</html>