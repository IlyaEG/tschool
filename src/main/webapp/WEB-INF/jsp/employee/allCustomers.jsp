<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Customer" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Person" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Contract" %>
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
        <jsp:include page="navbar.jsp" />

        <h1 id="banner">All customers</h1>
        <hr>
        <div class="container">
            <form method="post" action="/ECare/employee/removeCustomers"
                  enctype="application/x-www-form-urlencoded">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Remove</th>
                            <th>Customer</th>
                            <th>Customer e-mail</th>
                            <th>Get customer's contracts</th>
                            <th>Lock/Unlock</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="customer" items="${customers}">
                            <tr>
                                <td><input type="checkbox" name="remove${customer.customerPassport}" value="${customer.personId}"></td>
                                <td><a href="/ECare/employee/editCustomer/${customer.personId}">${customer.person.name} ${customer.person.surname}</a></td>
                                <td>${customer.person.email}</td>
                                <td><a href="/ECare/employee/getCustomersContracts/${customer.personId}">View customer's contracts</a></td>
                                <td><a href="/ECare/employee/lockCustomer/${customer.customerPassport}">${customer.locked}</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <button class="btn btn-danger"type="submit">Remove selected customers</button>
            </form>
        </div>
    </body>
</html>
