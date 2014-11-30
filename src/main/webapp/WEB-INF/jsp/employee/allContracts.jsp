<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Customer" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Person" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Contract" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Tariff" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Role" %>
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
            <c:if test="${owners != 'of all customers'}">
                <form id="newContract" method="post"
                      action="/ECare/employee/newContract"
                      enctype="application/x-www-form-urlencoded">
                    <input type="hidden" name="passport" value="${customer.customerPassport}"/>
                    <input type="submit" value="New contract">
                </form>
            </c:if>
            <form method="post" action="/ECare/employee/removeContracts"
                  enctype="application/x-www-form-urlencoded">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Remove</th>
                            <th>Number</th>
                            <th>Locked</th>
                            <th>Tariff</th>
                            <th>Options</th>
                            <th>Customer</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="contract" items="${contracts}">
                            <tr>
                                <td><input type="checkbox" name="remove${contract.number}" value="${contract.number}"></td>
                                <td>${contract.number}</td>
                                <td>
                                    <a href="/ECare/employee/lockContract/${contract.number}">
                                        <c:choose>
                                            <c:when test="${contract.lockedBy != null}">
                                                By ${contract.lockedBy.name}
                                            </c:when>
                                            <c:otherwise>
                                                Not locked
                                            </c:otherwise>
                                        </c:choose>
                                    </a>
                                </td>
                                <td><a href="/ECare/employee/contractTariff/${contract.number}">${contract.tariff.name}</a></td>
                                <td><a href="/ECare/employee/contractOptions/${contract.number}">Manage options</a></td>
                                <td><a href="/ECare/employee/editCustomer/${contract.customer.personId}">${contract.customer.person.name} ${contract.customer.person.surname}</a></td>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <button class="btn btn-danger"type="submit">Remove selected contracts</button>
            </form>
        </div>
    </body>
</html>
