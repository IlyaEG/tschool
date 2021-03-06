<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Option" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create new tariff</title>
    </head>
    <body>
        <h1>Create new tariff</h1>
		<div>
			<form method="post" action="CreateTariff"
				  enctype="application/x-www-form-urlencoded">
				<div>
					<p>
						Name: <br> <input type="text" placeholder="name"
										  name="name" value="">
					</p>
					<p>
						Rate: <br> <input type="text" placeholder="monthly rate"
										  name="rate" value="">
					</p>
					<c:forEach var="option" items="${options}">
						<input type="checkbox" name="${option.id}"
							   value="${option.id}">${option.name}
						<br>
					</c:forEach>

					<input type="submit" value="Create new tariff"/>
				</div>
			</form>
			<div>
				<p>Back to <a href="controlPanel.jsp">control panel</a></p>
			</div>
		</div>
    </body>
</html>
