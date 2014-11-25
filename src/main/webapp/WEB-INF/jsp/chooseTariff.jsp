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
        <title>New Contract</title>
    </head>
    <body>
        <h1>New contract with <c:out value="${customer.person.name}"/> <c:out value="${customer.person.surname}"/></h1>
        <form id="newContract" method="post"
              action="createContract"
              enctype="application/x-www-form-urlencoded">
            <input type="hidden" name="passport" value="${customer.customerPassport}"/>
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
            <p>Select number</p>
            <select name="number">
                <option selected="selected"></option>
                <c:forEach var="number" items="${numbers}">
                    <option value="${number}">
                        ${number}
                    </option>
                </c:forEach>
            </select>
            <input type="submit" value="New contract" />
        </form>
    </body>
</html>
