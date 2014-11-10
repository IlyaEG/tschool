<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="ru.tsystems.ecare.persistence.entities.Customer"%>
<%@ page import="ru.tsystems.ecare.persistence.entities.Contract"%>
<%@ page import="ru.tsystems.ecare.persistence.entities.Tariff"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Choose new tariff</title>
    </head>
    <body>
        <h1>Choose new tariff for <c:out value="${contract.number}" /></h1>
        <form id="setTariff" method="post" action="SetTariff"
              enctype="application/x-www-form-urlencoded">
            <input type="hidden" name="number" value="${contract.number}">
            <p>Select tariff</p>
            <select name="tariff">
                <option selected="selected"></option>
                <c:forEach var="tariff" items="${tariffs}">
                    <option value="${tariff.id}">
                        ${tariff.name}
                    </option>
                </c:forEach>
            </select>
            <br>
            <input type="submit" value="Change tariff">
        </form>
    </body>
</html>
