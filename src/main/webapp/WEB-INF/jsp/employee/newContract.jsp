<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ru.tsystems.ecare.persistence.entities.Customer" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Person" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Tariff" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>New contract</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <!-- Custom styles for this template -->
        <link href="/ECare/resources/css/starter-template.css" rel="stylesheet">
        <!-- favicon -->
        <link rel="icon" href="/ECare/resources/graphic/favicon.ico">
        <!-- Custom styles for login form -->
        <link href="/ECare/resources/css/signin.css" rel="stylesheet">
        <!-- Optional: Include the jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <!-- Optional: Incorporate the Bootstrap JavaScript plugins -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="navbar.jsp" />
        <h1>New contract with customer:</h1>
        <div class="container">

            <form class="form-signin" role="form" action="/ECare/employee/saveContract" method="post">
                <h2 class="form-signin-heading">Please fill all fields</h2>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Customer</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${customer.person.name} ${customer.person.surname}</p>
                    </div>
                    <label class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${customer.person.email}</p>
                    </div>
                </div>
                <label class="control-label">Tariff</label>
                <select name="tariff" class="form-control">
                    <c:forEach var="tariff" items="${availableTariffs}">
                        <option value="${tariff.id}">
                            ${tariff.name}
                        </option>
                    </c:forEach>
                </select>
                <label  class="control-label">Number</label>
                <select name="number" class="form-control">
                    <c:forEach var="number" items="${availableNumbers}">
                        <option value="${number}">
                            ${number}
                        </option>
                    </c:forEach>
                </select>
                <input type="hidden" name="passport" value="${customer.customerPassport}">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Save</button>
            </form>
        </div>
    </body>
</html>
