<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Tariff" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>All tariffs</title>
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
                        <li><a href="#about">About</a></li>
                        <li><a href="#contact">Contact</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>

        <div class="container">
            <h1 id="banner">All tariffs</h1>
            <form id="newTariff" method="post"
                  action="NewTariff"
                  enctype="application/x-www-form-urlencoded">
                <input type="submit" value="New tariff">
            </form>
            <table>
                <tr>
                    <td>Edit tariff options</td>
                    <td>Tariff name</td>
                    <td>Tariff rate</td>
                </tr>
                <c:forEach var="tariff" items="${tariffs}">
                    <tr>
                        <td>
                            <form id="edit${tariff.name}" method="post"
                                  action="EditTariffOptions"
                                  enctype="application/x-www-form-urlencoded">
                                <input type="hidden" name="tariff" value="${tariff.id}">
                                <input type="submit" value="Edit tariff">
                            </form>
                        </td>
                        <td>
                            ${tariff.name}
                        </td>
                        <td>
                            ${tariff.rate}
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div>
            <a href="controlPanel.jsp">Back to control panel home page
            </a>.
        </div>
    </body>
</html>
