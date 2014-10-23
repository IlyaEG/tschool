<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="ru.tsystems.ecare.persistence.entities.Customer" %>
<%@ page import="ru.tsystems.ecare.persistence.entities.Person" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All customers</title>
    </head>
    <body>
        <h1>All customers</h1>
		<div>
			<table>
				<tr>
					<td>Edit customer</td>
					<td>Customer name</td>
					<td>Customer passport</td>
					<td>Customer e-mail</td>
				</tr>
				<c:forEach var="customer" items="${customers}">
					<tr>
						<td>
							<form id="edit${customer.person.name}" method="post"
								  action="/EditCustomer"
								  enctype="application/x-www-form-urlencoded">
								<input type="hidden" name="passport" value="${customer.customerPassport}"/>
								<input type="submit" value="Edit customer" />
							</form>
						</td>
						<td>
								${customer.person.name}
						</td>
						<td>
							${customer.customerPassport}
						</td>
						<td>
							${customer.person.email}
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div>
			<a href="controlPanel.jsp"
			   class="inline-link">Back to control panel home page
			</a>.
		</div>
    </body>
</html>
