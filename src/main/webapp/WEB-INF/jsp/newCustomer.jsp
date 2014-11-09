<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Contract with new customer</title>
    </head>
    <body>
        <h1>New Contract with new customer</h1>
		<h2><c:out value="${message}"/></h2>
		<form name="newCustomer" method="post" action="NewCustomer"
			  enctype="application/x-www-form-urlencoded">
			Name:<input type="text" name="name" value="">
			<br>
			Surname:<input type="text" name="surname" value="">
			<br>
			Birth date ("yyyy-mm-dd"): <input type="text" placeholder="yyyy-mm-dd" name="birthdate" value="">
			<br>
			E-mail:<input type="text" name="email" value="">
			<br>
			Password:<input type="password" name="password" value="">
			<br>
			Address:<input type="text" name="address" value="">
			<br>
			Passport:<input type="passport" name="passport" value="">
			<br>
			<input type="submit" value="Create" />
		</form>
		<div>
			<a href="controlPanel.jsp">
				Back to control panel
			</a>.
		</div>
    </body>
</html>
