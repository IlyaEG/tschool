<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Customer" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Person" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Contract" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Tariff" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All contracts</title>
    </head>
    <body>
        <h1>All contracts</h1>
		<div>
			<table>
				<tr>
					<td>Edit contract</td>
					<td>Number</td>
					<td>Tariff</td>
					<td>Month rate</td>
					<td>Customer name</td>
					<td>Customer surname</td>
				</tr>
				<c:forEach var="contract" items="${contracts}">
					<tr>
						<td>
							<form id="edit${contract.number}" method="post"
								  action="EditContract"
								  enctype="application/x-www-form-urlencoded">
								<input type="hidden" name="number" value="${contract.number}"/>
								<input type="submit" value="Edit contract" />
							</form>
						</td>
						<td>${contract.number}</td>
						<td>${contract.tariff.name}</td>
						<td>${contract.tariff.rate}</td>
						<td>${contract.customer.person.name}</td>
						<td>${contract.customer.person.surname}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div>
			<a href="controlPanel.jsp">
				Back to control panel
			</a>.
		</div>
    </body>
</html>
