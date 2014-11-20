<%@page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@page import="ru.tsystems.ecare.persistence.entities.Customer"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

        <!-- Optional: Include the jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <!-- Optional: Incorporate the Bootstrap JavaScript plugins -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>


<!--
        <link rel="stylesheet" type="text/css" media="screen"
              href="resources/css/style.css">
-->
        <title>Employee's control panel</title>
    </head>

    <body>
        <jsp:include page="menu.jsp" />
        <h1 id="banner">Employee's control panel</h1>
        <hr>

        <p>You are currently logged as 
            <span id="username">
                <sec:authentication property="principal.username"/>
                <sec:authentication property="principal.authorities"/>
            </span>!
        </p>
        <div>
            <p>
                You can
                <a href="customersNContracts">
                    manage customers and contracts
                </a>.
            </p>
        </div>
        <div>
            <p>
                Or you can
                <a href="tariffsNOptions">
                    manage tariffs and options
                </a>.
            </p>
        </div>
    </body>
</html>