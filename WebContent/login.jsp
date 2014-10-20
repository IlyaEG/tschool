<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<h3>Authorization</h3>
	<form method="post" action="dispatcher"
		enctype="application/x-www-form-urlencoded">
		<div>
			<p>
				Login: &emsp; &emsp; <input type="text" placeholder="login"
					class="simple-input" name="login" size=20 value="">
			</p>
			<p>
				Password: &nbsp; <input type="password" placeholder="password"
					class="simple-input" name="password" size=20 value="">
			</p>
			<button type="submit">Enter</button>

		</div>
	</form>
	<p>
		If you haven't registered yet, please proceed to <a
			href="registration.jsp" class="inline-link">registration</a>.
	</p>

</body>
</html>