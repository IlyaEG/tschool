<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="ru.tsystems.ecare.persistence.entities.Option"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit option "<c:out value="${option.name}" />" relations</title>
    </head>
    <body>
        <h1>Edit option "<c:out value="${option.name}" />" relations</h1>
        <div>
            <h2>Related options, check to remove</h2>
            <form method="post" action="UpdateRalatedOptions">
                <p>
                    <c:forEach var="option" items="${option.optionsForRelId2}">
                        <input type="checkbox" name="rem${option.name}" value="${option.id}">${option.name}<br>
                    </c:forEach>
                </p>
                <input type="hidden" name="option" value="${option.id}">
                <input type="submit" value="Remove options">
            </form>
            <h2>Incompatible options, check to remove</h2>
            <form method="post" action="UpdateIncompatibleOptions">
                <p>
                    <c:forEach var="option" items="${option.optionsForIncompId2}">
                        <input type="checkbox" name="rem${option.name}" value="${option.id}">${option.name}<br>
                    </c:forEach>
                </p>
                <input type="hidden" name="option" value="${option.id}">
                <input type="submit" value="Remove options">
            </form>
            <h2>Available options, check to add related options</h2>
            <form method="post" action="UpdateRalatedOptions">
                <p>
                    <c:forEach var="option" items="${availableOptions}">
                        <input type="checkbox" name="add${option.name}" value="${option.id}">${option.name}<br>
                    </c:forEach>
                </p>
                <input type="hidden" name="option" value="${option.id}">
                <input type="submit" value="Add related options">
            </form>
            <h2>Available options, check to add incompatible options</h2>
            <form method="post" action="UpdateIncompatibleOptions">
                <p>
                    <c:forEach var="option" items="${availableOptions}">
                        <input type="checkbox" name="add${option.name}" value="${option.id}">${option.name}<br>
                    </c:forEach>
                </p>
                <input type="hidden" name="option" value="${option.id}">
                <input type="submit" value="Add related options">
            </form>
        </div>
        <div>
            <a href="controlPanel.jsp">Back to control panel home page</a>.
        </div>
    </body>
</html>