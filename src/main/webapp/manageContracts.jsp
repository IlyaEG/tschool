<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Customer" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Person" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Contract" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><c:out value="${customer.person.name}"/> <c:out value="${customer.person.surname}"/> contracts page</title>
    </head>
    <body>
        <h1><c:out value="${customer.person.name}"/> <c:out value="${customer.person.surname}"/> contracts page</h1>
		<div>
			<table>
				<tr>
					<td>
						<p>
							New contract
						</p>
					</td>
					<td>
						<form id="newContract" method="post"
							  action="/NewContract"
							  enctype="application/x-www-form-urlencoded">
							<input type="hidden" name="passport" value="${customer.customerPassport}"/>
							<input type="submit" value="New contract" />
						</form>
					</td>
				</tr>
				<c:forEach var="contract" items="${customer.contracts}">
					<tr>
						<td>
							${contract.number}
						</td>
						<td>
							<form id="edit${contract.number}" method="post"
								  action="/EditContract"
								  enctype="application/x-www-form-urlencoded">
								<input type="hidden" name="number" value="${contract.number}"/>
								<input type="submit" value="Edit contract" />
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>
