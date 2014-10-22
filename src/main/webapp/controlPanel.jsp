<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="ru.tsystems.ecare.persistence.entities.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee's control panel</title>
</head>
<body>
	<header>Employee's control panel</header>
</body>

<p>Role(temporary):</p>
<jsp:useBean id="person" class="ru.tsystems.ecare.persistence.entities.Person" scope="session"></jsp:useBean>
<jsp:getProperty property="email" name="person"/>
<hr>

<p>Search client by phone number:</p>
<form method="post" action="ControlPanel"
	enctype="application/x-www-form-urlencoded">
	<p>
		Number: <input type="text" placeholder="telephone number"
			class="simple-input" name="number" size=20 value="">
		<button type="submit">Search</button>
	</p>
</form>

<hr>

<p>
	<a href='<%=request.getContextPath()%>controlPanel?&action=viewAllTariffs'
		class="inline-link">View all tariffs</a>
</p>

<hr>

<p>
	List of clients. <a
		href='<%=request.getContextPath()%>controlPanel?action=deleteAllCustomers'
		class="inline-link">(clear list)</a>
</p>
<table>
	<tr>
		<td>Client ID</td>
		<td>Name</td>
		<td>Passport</td>
		<td>E-mail</td>
	</tr>
	<c:forEach var="client" items="${clientsList}">
		<tr>
			<td><a
				href='<%=request.getContextPath()%>controlPanel?id=${client.id}&action=viewCustomer'
				class="inline-link">${client.id}</a></td>
			<td>${client.name}</td>
			<td>${client.passport}</td>
			<td>${client.email}</td>
			<td><a
				href='<%=request.getContextPath()%>controlPanel?id=${client.id}&action=deleteCustomer'
				class="inline-link">delete</a></td>
		</tr>
	</c:forEach>
</table>

</html>