<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="ru.tsystems.ecare.persistence.entities.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Employee's control panel</title>
	</head>
	<body>
		<h1>Control panel</h1>
		<div>
			<p>You are currently logged as <c:out value="${role}" /> <c:out value="${user}" /></p>
		</div>
		<div>
			<p>
				You can
				<a href="controlCustomersNContracts.jsp">
					manage customers and contracts
				</a>.
			</p>
		</div>
		<div>
			<p>
				Or you can
				<a href="controlTariffsNOptions.jsp">
					manage tariffs and options
				</a>.
			</p>
		</div>
		<div>
			<form id="logout" method="post"
			  action="Logout"
			  enctype="application/x-www-form-urlencoded">
			<input type="submit" value="Logout">
		</form>
		</div>


	</body>


</html>