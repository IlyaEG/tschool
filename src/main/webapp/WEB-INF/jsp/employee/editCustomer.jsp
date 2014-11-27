<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Edit customer</title>
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
        <h1>Customer information</h1>
        <div class="container">
            <form class="form-signin" role="form" action="/ECare/employee/saveCustomer" method="post">
                <h2 class="form-signin-heading">Please fill all fields</h2>
                <label for="name" class="sr-only">Name</label>
                <input type="text" id="name" name="name" value="${name}"
                       class="form-control" placeholder="Name" required autofocus>
                <label for="surname" class="sr-only">Surname</label>
                <input type="text" id="surname" name="surname" value="${surname}"
                       class="form-control" placeholder="Surname" required>
                <label for="birthdate" class="sr-only">Birthdate</label>
                <input type="date" id="birthdate" name="birthdate" value="${birthdate}"
                       class="form-control" placeholder="YYYY-MM-DD" required>
                <label for="passport" class="sr-only">Passport</label>
                <input type="text" id="passport" name="passport" value="${passport}"
                       class="form-control" placeholder="Passport number" required>
                <label for="address" class="sr-only">Address</label>
                <input type="text" id="address" name="address" value="${address}"
                       class="form-control" placeholder="Address" required>
                <input type="email" id="email" name="email" value="${email}"
                       class="form-control" placeholder="Email address" required>
                <label for="password" class="sr-only">Password</label>
                <input type="password" id="password" name="password" value="${password}"
                       class="form-control" placeholder="Password" required>
                <c:if test="${new > 0}">
                    <select name="tariff" class="form-control">
                        <c:forEach var="tariff" items="${availableTariffs}">
                            <option value="${tariff.id}">
                                ${tariff.name}
                            </option>
                        </c:forEach>
                    </select>
                    <select name="number" class="form-control">
                        <c:forEach var="number" items="${availableNumbers}">
                            <option value="${number}">
                                ${number}
                            </option>
                        </c:forEach>
                    </select>
                </c:if>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Save</button>
            </form>
        </div> <!-- /container -->
        <p class="text-danger text-center">${message}</p>

    </body>
</html>
