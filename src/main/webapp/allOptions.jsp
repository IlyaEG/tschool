<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Option" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All options</title>
    </head>
    <body>
        <h1>All options</h1>
		<div>
			<table>
				<tr>
					<td>Edit option</td>
					<td>Option name</td>
				</tr>
				<c:forEach var="option" items="${options}">
					<tr>
						<td>
							<form id="edit${option.name}" method="post"
								  action="EditOption"
								  enctype="application/x-www-form-urlencoded">
								<input type="hidden" name="name" value="${option.name}">
								<input type="submit" value="Edit option">
							</form>
						</td>
						<td>
								${option.name}
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
