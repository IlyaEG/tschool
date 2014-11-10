<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="ru.tsystems.ecare.persistence.entities.Contract"%>
<%@ page import="ru.tsystems.ecare.persistence.entities.Tariff"%>
<%@ page import="ru.tsystems.ecare.persistence.entities.Option"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit "<c:out value="${contract.number}" />" contract options</title>
    </head>
    <body>
        <h1>Edit "<c:out value="${contract.number}" />" contract options</h1>
        <div>
            <h2>Active options, check to remove</h2>
            <form method="post" action="ChangeContractOptions">
                <p>
                    <c:forEach var="option" items="${contract.options}">
                        <input type="checkbox" name="rem${option.name}" value="${option.id}">${option.name}<br>
                    </c:forEach>
                </p>
                <input type="hidden" name="number" value="${contract.number}">
                <input type="submit" value="Remove options">
            </form>
            <h2>Available options, check to add</h2>
            <form method="post" action="ChangeContractOptions">
                <p>
                    <c:forEach var="option" items="${availableOptions}">
                        <input type="checkbox" name="add${option.name}" value="${option.id}">${option.name}<br>
                    </c:forEach>
                </p>
                <input type="hidden" name="number" value="${contract.number}">
                <input type="submit" value="Add options">
            </form>
        </div>
        <div>
            <a href="Home">Back to control panel home page</a>.
        </div>
    </body>
</html>