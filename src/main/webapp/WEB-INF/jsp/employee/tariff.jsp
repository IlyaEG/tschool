<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Option" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Tariff" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
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
        <title>New tariff</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp" />
        <h1 id="banner">Edit tariff</h1>
        <div class="container">
            <form method="post" action="/ECare/employee/createTariff"
                  enctype="application/x-www-form-urlencoded"
                  class="form-horizontal">
                <div class="control-group">
                    <label class="control-label" for="name">Tariff name</label>
                    <div class="controls">
                        <input type="text" id="name" name="name"
                               placeholder="Tariff name" required value="${tariff.name}">
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="rate">Monthly rate</label>
                    <div class="controls">
                        <input type="number" id="rate" name="rate"
                               placeholder="0000.00" required value="${tariff.rate}">
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <c:forEach var="option" items="${availableOptions}">
                            <label class="checkbox">
                                <input type="checkbox"
                                       name="addOption${option.name}"
                                       value="${option.id}">${option.name}
                            </label>
                        </c:forEach>
                        <c:forEach var="option" items="${tariff.options}">
                            <label class="checkbox">
                                <input type="checkbox"
                                       checked="true"
                                       name="addOption${option.name}"
                                       value="${option.id}">${option.name}
                            </label>
                        </c:forEach>
                        <input type="hidden" name="tariffId" value="${tariff.id}">
                        <button class="btn btn-primary" type="submit">
                            Save tariff
                        </button>
                    </div>
                </div>
                <p class="text-danger text-center">${message}</p>
            </form>
        </div>
    </body>
</html>
