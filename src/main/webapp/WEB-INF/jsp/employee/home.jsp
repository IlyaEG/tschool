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
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="employee">ECare</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="employee/about">My info</a></li>
                        <li><a href="logout">Logout</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>

        <h1 id="banner">Employee's control panel</h1>
        <hr>

        <p>You are currently logged-in as
            <span id="username">${userName}</span>!
        </p>
        <div class="col-lg-6">
            <h4>Manage customers and contracts</h4>

            <h5><a href="employee/searchCustomer">Search customer</a></h5>
            <h5><a href="employee/allCustomers">View all customer</a></h5>
            <h5><a href="employee/allContracts">View all contracts</a></h5>
            <h5><a href="employee/newCustomer">Register new customer</a></h5>
        </div>
        <div class="col-lg-6">
            <h4>Manage tariffs and options</h4>
            <h5><a href="employee/allTariffs">View all tariffs</a></h5>
            <h5><a href="employee/newTariff">Create new tariff</a></h5>
            <h5><a href="employee/allOptions">View all options</a></h5>
            <h5><a href="employee/newOption">Create new option</a></h5>
        </div>
    </body>
</html>