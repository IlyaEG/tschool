<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="ru.tsystems.ecare.persistence.entities.Contract"%>
<%@page import="ru.tsystems.ecare.persistence.entities.Tariff"%>
<%@page import="ru.tsystems.ecare.persistence.entities.Option"%>
<%@page import="ru.tsystems.ecare.persistence.entities.Customer"%>
<%@page import="ru.tsystems.ecare.persistence.entities.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Customer's tariff</title>
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

        <h1>Customer's  tariff </h1>
        <div class="container">
            <h2>Customer info:</h2>
            <p>
                Customer: ${customer.person.name} ${customer.person.surname}
            </p>
            <p>
                Contract number: ${contract.number}
            </p>
            <p>
                Current tariff: ${contract.tariff.name}
            </p>
        </div>
        <div class="container">
            <h2>Available tariffs to change:</h2>
            <form id="newTariff" method="post"
                  action="/ECare/customer/changeTariff"
                  enctype="application/x-www-form-urlencoded">
                <input type="hidden" name="number" value="${contract.number}"/>
                <input type="hidden" name="passport" value="${customer.customerPassport}"/>
                <p>Select tariff</p>
                <select name="tariff">
                    <option value="${contract.tariff.id}" selected="selected">${contract.tariff.name}</option>
                    <c:forEach var="tariff" items="${availableTariffs}">
                        <option value="${tariff.id}">
                            ${tariff.name}
                        </option>
                    </c:forEach>
                </select>
                <br>
                <br>
                <button class="btn btn-primary" type="submit">Set tariff</button>
            </form>
        </div>
        <div class="container">
            <p class="text-danger text-center">${message}</p>
        </div>
    </body>
</html>