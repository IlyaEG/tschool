<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Customer" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Person" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>All customers</title>
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

        <h1 id="banner">All customers</h1>
        <hr>
        <div class="container">
            <table>
                <tr>
                    <td> Edit customer </td>
                    <td> Customer name </td>
                    <td> Customer passport </td>
                    <td> Customer e-mail </td>
                    <td> Locked </td>
                    <td> Lock/Unlock </td>
                </tr>
                <c:forEach var="customer" items="${customers}">
                    <tr>
                        <td>
                            <form id="edit${customer.person.name}" method="post"
                                  action="editCustomer"
                                  enctype="application/x-www-form-urlencoded">
                                <input type="hidden" name="passport" value="${customer.customerPassport}">
                                <input type="submit" value="Edit customer">
                            </form>
                        </td>
                        <td>${customer.person.name}</td>
                        <td>${customer.customerPassport}</td>
                        <td>${customer.person.email}</td>
                        <td>${customer.locked}</td>
                        <td>
                            <form id="lock${customer.personId}" method="post"
                                  action="lockCustomer"
                                  enctype="application/x-www-form-urlencoded">
                                <input type="hidden" name="passport" value="${customer.customerPassport}">
                                <input type="submit" value="Lock customer">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
