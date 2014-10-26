<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="ru.tsystems.ecare.persistence.entities.Contract" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit contract <c:out value="${contract.number}"/></title>
    </head>
    <body>
        <h1>Edit contract <c:out value="${contract.number}"/></h1>
		<form id="changeTariff" method="post"
			  action="ChangeTariff"
			  enctype="application/x-www-form-urlencoded">
			<input type="hidden" name="number" value="${contract.number}">
			<input type="submit" value="Change tariff">
		</form>
		<form id="changeOptions" method="post"
			  action="ChangeOptions"
			  enctype="application/x-www-form-urlencoded">
			<input type="hidden" name="number" value="${contract.number}">
			<input type="submit" value="Change options">
		</form>
		<div>
			<a href="controlPanel.jsp">
				Back to control panel
			</a>.
		</div>
    </body>
</html>
