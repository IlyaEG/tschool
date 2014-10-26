<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="ru.tsystems.ecare.persistence.entities.Customer"%>
<%@ page import="ru.tsystems.ecare.persistence.entities.Contract"%>
<%@ page import="ru.tsystems.ecare.persistence.entities.Tariff"%>
<%@ page import="ru.tsystems.ecare.persistence.entities.Option"%>
<%@ page import="ru.tsystems.ecare.persistence.entities.Role"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Customer <c:out value="${customer.person.name}" /> <c:out value="${customer.person.surname}" /> control panel</title>
	</head>
	<body>
		<h1>
			Customer <c:out value="${customer.person.name}" />  <c:out value="${customer.person.name}" /> control panel
		</h1>
		<div>
			<table>
				<tr>
					<td>Edit tariff</td>
					<td>Number</td>
					<td>Tariff name</td>
					<td>Tariff rate</td>
					<td>Contract locked</td>
					<td>Lock/Unlock contract</td>
				</tr>
				<c:forEach var="contract" items="${customer.contracts}">
					<tr>
						<td>
							<form id="edit${contract.number}" method="post"
								  action="EditContract"
								  enctype="application/x-www-form-urlencoded">
								<input type="hidden" name="number" value="${contract.number}">
								<input type="submit" value="Edit contract">
							</form>
						</td>
						<td>${contract.number}</td>
						<td>${contract.tariff.name}</td>
						<td>${contract.tariff.rate}</td>
						<td>${contract.lockedBy.name}</td>
						<td>
							<form id="lock${contract.number}" method="post"
								  action="LockContract"
								  enctype="application/x-www-form-urlencoded">
								<input type="hidden" name="number" value="${contract.number}">
								<input type="submit" value="Lock/Unlock contract">
							</form>
						</td>
					</tr>
					<tr>
					<span>Options for ${contract.number} contract</span>
					</tr>
					<tr>
					<form id="addOption" method="post"
						  action="AddOptionToContract"
						  enctype="application/x-www-form-urlencoded">
						<input type="hidden" name="number" value="${contract.number}">
						<input type="submit" value="Add option">
					</form>
					</tr>
					<tr>
						<td>Remove option</td>
						<td>Option name</td>
						<td>Remove rate</td>
					</tr>
					<c:forEach var="option" items="${contract.options}">
						<tr>
							<td>
								<form id="Remove${option.name}" method="post"
									  action="RemoveOtionFromContract"
									  enctype="application/x-www-form-urlencoded">
									<input type="hidden" name="number" value="${contract.number}">
									<input type="hidden" name="option" value="${option.id}">
									<input type="submit" value="Remove option">
								</form>
							</td>
							<td>${option.name}</td>
							<td>${option.rate}</td>
						</tr>
					</c:forEach>
				</c:forEach>
			</table>
		</div>
	</body>
</html>