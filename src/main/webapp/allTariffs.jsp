<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Tariff" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All tariffs</title>
    </head>
    <body>
        <h1>All tariffs</h1>
		<div>
			<form id="newTariff" method="post"
				  action="newTariff.jsp"
				  enctype="application/x-www-form-urlencoded">

				<input type="submit" value="New tariff">
			</form>
			<table>
				<tr>
					<td>Edit tariff</td>
					<td>Tariff name</td>
				</tr>
				<c:forEach var="tariff" items="${tariffs}">
					<tr>
						<td>
							<form id="edit${tariff.name}" method="post"
								  action="EditTariff"
								  enctype="application/x-www-form-urlencoded">
								<input type="hidden" name="name" value="${tariff.name}">
								<input type="submit" value="Edit tariff">
							</form>
						</td>
						<td>
							${tariff.name}
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div>
			<a href="controlPanel.jsp">Back to control panel home page
			</a>.
		</div>
    </body>
</html>
