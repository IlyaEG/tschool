<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="ru.tsystems.ecare.persistence.entities.Tariff"%>
<%@ page import="ru.tsystems.ecare.persistence.entities.Option"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit tariff "<c:out value="${tariff.name}" />" options</title>
    </head>
    <body>
        <h1>Edit tariff "<c:out value="${tariff.name}" />" options</h1>
		<div>
			<h2>Active options, check to remove</h2>
			<form method="post" action="RemoveTariffOptions">
				<p>
					<c:forEach var="option" items="${tariff.options}">
						<input type="checkbox" name="rem${option.name}" value="${option.id}">${option.name}<br>
					</c:forEach>
				</p>
				<input type="hidden" name="tariff" value="${tariff.id}">
				<input type="submit" value="Remove options">
			</form>
			<h2>Available options, check to add</h2>
			<form method="post" action="AddTariffOptions">
				<p>
					<c:forEach var="option" items="${availableOptions}">
						<input type="checkbox" name="add${option.name}" value="${option.id}">${option.name}<br>
					</c:forEach>
				</p>
				<input type="hidden" name="tariff" value="${tariff.id}">
				<input type="submit" value="Add options">
			</form>
		</div>
		<div>
			<a href="controlPanel.jsp">Back to control panel home page</a>.
		</div>
    </body>
</html>
