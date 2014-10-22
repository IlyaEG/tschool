<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="ru.tsystems.ecare.persistence.entities.Customer" %>
<%@ page import="ru.tsystems.ecare.persistence.entities.Person" %>
<%@ page import="ru.tsystems.ecare.persistence.entities.Contract" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><c:out value="${customer.customerPassport}"/> contracts page</title>
    </head>
    <body>
        <h1><c:out value="${customer.customerPassport}"/> contracts page</h1>
		<div>
			<c:forEach var="contract" items="${customer.contracts}">
				${contract.number}
			</c:forEach>
	</div>
</body>
</html>
