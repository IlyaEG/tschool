<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Option" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Option</title>
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
        <h1 id="banner">${option.name} option features:</h1>
        <div class="container">
            <form method="post" action="/ECare/employee/saveOption/${option.id}"
                  enctype="application/x-www-form-urlencoded">
                <div class="container">
                    <p>
                        Name: <br> <input type="text" placeholder="name"
                                          name="name" value="${option.name}">
                    </p>
                    <p>
                        Rate: <br> <input type="text" placeholder="monthly rate"
                                          name="rate" value="${option.rate}">
                    </p>
                    <p>
                        Price: <br> <input type="text" placeholder="connection price"
                                           name="price" value="${option.price}">
                    </p>
                </div>
                <div class="container">
                    <h2>Related options, check to add</h2>
                    <p>
                        <c:forEach var="option" items="${relatedOptions}">
                            <input type="checkbox" name="related${option.name}" value="${option.id}" checked="true">${option.name} <small>${option.fullInfo()}</small><br>
                        </c:forEach>
                        <c:forEach var="option" items="${availableOptions}">
                            <input type="checkbox" name="related${option.name}" value="${option.id}">${option.name} <small>${option.fullInfo()}</small><br>
                        </c:forEach>
                    </p>
                    <h2>Incompatible options, check to add</h2>
                    <p>
                        <c:forEach var="option" items="${incompatibleOptions}">
                            <input type="checkbox" name="incompatible${option.name}" value="${option.id}" checked="true">${option.name} <small>${option.fullInfo()}</small><br>
                        </c:forEach>
                        <c:forEach var="option" items="${availableOptions}">
                            <input type="checkbox" name="incompatible${option.name}" value="${option.id}">${option.name} <small>${option.fullInfo()}</small><br>
                        </c:forEach>
                    </p>
                </div>
                <input type="submit" value="Save option"/>
            </form>
        </div>
    </body>
</html>
