<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Customer" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Person" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Contract" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Tariff" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" href="resources/graphic/favicon.ico">
        <title>All contracts</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <!-- Custom styles for this template -->
        <link href="resources/css/starter-template.css" rel="stylesheet">
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
                    <a class="navbar-brand" href="home">ECare</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="#about">About</a></li>
                        <li><a href="#contact">Contact</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>
        <h1>All contracts</h1>
        <div>
            <table>
                <tr>
                    <td>Edit contract</td>
                    <td>Number</td>
                    <td>Tariff</td>
                    <td>Month rate</td>
                    <td>Customer name</td>
                    <td>Customer surname</td>
                </tr>
                <c:forEach var="contract" items="${contracts}">
                    <tr>
                        <td>
                            <form id="edit${contract.number}" method="post"
                                  action="EditContract"
                                  enctype="application/x-www-form-urlencoded">
                                <input type="hidden" name="number" value="${contract.number}"/>
                                <input type="submit" value="Edit contract" />
                            </form>
                        </td>
                        <td>${contract.number}</td>
                        <td>${contract.tariff.name}</td>
                        <td>${contract.tariff.rate}</td>
                        <td>${contract.customer.person.name}</td>
                        <td>${contract.customer.person.surname}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
