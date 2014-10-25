<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Customer" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Person" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Contract" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Contract</title>
    </head>
    <body>
        <h1>New contract with <c:out value="${customer.person.name}"/> <c:out value="${customer.person.surname}"/></h1>
		<form id="newContract" method="post"
			  action="CreateContract"
			  enctype="application/x-www-form-urlencoded">
			<input type="hidden" name="passport" value="${customer.customerPassport}"/>
			<select>
				<c:forEach var="tariff" items="${tariffs}">
					<option value="${tariff.id}">
						${tariff.name}
					</option>
				</c:forEach>
			</select>
			<input type="submit" value="New contract" />
		</form>
    </body>
</html>
