<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Option" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>All options</title>
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

        <div class="container">
            <h1 id="banner">All options</h1>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Option name</th>
                        <th>Option month rate</th>
                        <th>Option connection price</th>
                        <th>Compatible Tariffs</th>
                        <th>Related options</th>
                        <th>Incompatible options</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="option" items="${options}">
                        <tr>
                            <td>${option.name}</td>
                            <td>${option.rate}</td>
                            <td>${option.price}</td>
                            <td>${option.compatibleTariffs()}</td>
                            <td>${option.relatedNames()}</td>
                            <td>${option.incompatibleNames()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>