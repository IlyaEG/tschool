<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ru.tsystems.ecare.persistence.entities.Customer" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Person" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Search Customer</title>
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

        <h1 id="banner">Search customer</h1>
        <div class="container">

            <form method="post" action="searchCustomer"
                  enctype="application/x-www-form-urlencoded">
                <div class="input-group">
                    <span class="input-group-addon">Phone Number:</span>
                    <input type="text" class="form-control" name="number">
                    <span class="input-group-addon">
                        <button class="btn" type="submit">Search</button>
                    </span>
                </div>
            </form>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Number</th>
                        <th>Tariff</th>
                        <th>Options</th>
                        <th>Customer</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="contract" items="${contracts}">
                        <tr>
                            <td><a href="contract/${contract.number}">${contract.number}</a></td>
                            <td><a href="tariff/${contract.number}">${contract.tariff.name}</a></td>
                            <td><a href="options/${contract.number}">Manage options</a></td>
                            <td>
                                <form id="customer" method="post"
                                      action="/ECare/employee/editCustomer"
                                      enctype="application/x-www-form-urlencoded">
                                    <input type="hidden" name="passport" value="${contract.customer.customerPassport}"/>
                                    <button class="btn btn-link" type="submit">${contract.customer.person.name} ${contract.customer.person.surname}</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="container">
                <p>${message}</p>
            </div>
        </div>
    </body>
</html>
