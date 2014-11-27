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
        <title>Contract</title>
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

        <h1 id="banner">Edit contract with number
            <c:out value="${contract.number}" />
            of <c:out value="${contract.customer.person.name}" /> <c:out value="${contract.customer.person.surname}" /></h1>
        <div class="container">
            <form id="changeTariff" method="post"
                  action="/ECare/employee/changeContractTariff"
                  enctype="application/x-www-form-urlencoded">
                <input type="hidden" name="number" value="${contract.number}">
                <input type="submit" value="Change tariff">
            </form>
        </div>
        <div class="container">
            <h2>Active options, check to remove</h2>
            <form method="post" action="/ECare/employee/changeContractOptions">
                <p>
                    <c:forEach var="option" items="${contract.options}">
                        <input type="checkbox" name="remOption${option.name}" value="${option.id}">${option.name}<br>
                    </c:forEach>
                </p>
                <input type="hidden" name="number" value="${contract.number}">
                <input type="submit" value="Remove options">
            </form>
            <h2>Available options, check to add</h2>
            <form method="post" action="/ECare/employee/changeContractOptions">
                <p>
                    <c:forEach var="option" items="${availableOptions}">
                        <input type="checkbox" name="addOption${option.name}" value="${option.id}">${option.name}<br>
                    </c:forEach>
                </p>
                <input type="hidden" name="number" value="${contract.number}">
                <input type="submit" value="Add options">
            </form>
        </div>
    </body>
</html>