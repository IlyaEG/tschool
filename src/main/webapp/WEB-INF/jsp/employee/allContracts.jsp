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
        <title>All contracts</title>
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
        <h1 id="banner">All contracts ${owners}</h1>
        <div class="container">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Edit contract</th>
                        <th>Number</th>
                        <th>Tariff</th>
                        <th>Month rate</th>
                        <th>Customer name</th>
                        <th>Customer surname</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="contract" items="${contracts}">
                        <tr>
                            <td>
                                <form id="edit${contract.number}" method="post"
                                      action="/ECare/employee/EditContract"
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
                </tbody>
            </table>
        </div>
    </body>
</html>
