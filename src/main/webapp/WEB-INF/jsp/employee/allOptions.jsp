<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Option" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" href="resources/graphic/favicon.ico">
        <title>All options</title>
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
                    <a class="navbar-brand" href="#">ECare</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="#about">About</a></li>
                        <li><a href="#contact">Contact</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>
        <h1 id="banner">All options</h1>
        <div class="container">
            <form id="newOption" method="post"
                  action="newOption"
                  enctype="application/x-www-form-urlencoded">
                <input type="submit" value="New option">
            </form>
            <table>
                <tr>
                    <td>Edit option relations</td>
                    <td>Option name</td>
                    <td>Option month rate</td>
                    <td>Option connection price</td>
                </tr>
                <c:forEach var="option" items="${options}">
                    <tr>
                        <td>
                            <form id="edit${option.name}" method="post"
                                  action="EditOptionRelations"
                                  enctype="application/x-www-form-urlencoded">
                                <input type="hidden" name="name" value="${option.id}">
                                <input type="submit" value="Edit option">
                            </form>
                        </td>
                        <td>${option.name}</td>
                        <td>${option.rate}</td>
                        <td>${option.price}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
