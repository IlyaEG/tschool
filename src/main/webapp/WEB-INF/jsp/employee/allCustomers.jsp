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
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Edit customer's information</th>
                        <th>Get customer's contracts</th>
                        <th>Customer name</th>
                        <th>Customer surname</th>
                        <th>Customer passport</th>
                        <th>Customer e-mail</th>
                        <th>Locked</th>
                        <th>Lock/Unlock</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="customer" items="${customers}">
                        <tr>
                            <td>
                                <form id="edit${customer.personId}" method="post"
                                      action="/ECare/employee/editCustomer"
                                      enctype="application/x-www-form-urlencoded">
                                    <input type="hidden" name="passport" value="${customer.customerPassport}">
                                    <input type="submit" value="Edit customer">
                                </form>
                            </td>
                            <td>
                                <form id="editcontracts${customer.personId}" method="post"
                                      action="/ECare/employee/getCustomersContracts"
                                      enctype="application/x-www-form-urlencoded">
                                    <input type="hidden" name="passport" value="${customer.customerPassport}">
                                    <input type="submit" value="Edit customer's contracts">
                                </form>
                            </td>
                            <td>${customer.person.name}</td>
                            <td>${customer.person.surname}</td>
                            <td>${customer.customerPassport}</td>
                            <td>${customer.person.email}</td>
                            <td>${customer.locked}</td>
                            <td>
                                <form id="lock${customer.personId}" method="post"
                                      action="/ECare/employee/lockCustomer"
                                      enctype="application/x-www-form-urlencoded">
                                    <input type="hidden" name="passport" value="${customer.customerPassport}">
                                    <input type="submit" value="Lock customer">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
