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
        <h1 id="banner">All contracts of customer ${customer.person.name} ${customer.person.surname}</h1>
        <div class="container">

            <c:choose>
                <c:when test="${contracts == null}">
                    <h2>You have not contracts!</h2>
                </c:when>
                <c:otherwise>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Number</th>
                                <th>Locked</th>
                                <th>Tariff</th>
                                <th>Options</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="contract" items="${contracts}">
                                <tr>
                                    <td>${contract.number}</td>
                                    <td>
                                        <a href="/ECare/customer/lockContract/${contract.number}">
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
                                    <td><a href="/ECare/customer/contractTariff/${contract.number}">${contract.tariff.name}</a></td>
                                    <td><a href="/ECare/customer/contractOptions/${contract.number}">Manage options</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="container">
            <p class="text-danger text-center">${message}</p>
        </div>
    </body>
</html>
