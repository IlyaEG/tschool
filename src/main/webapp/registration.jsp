<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
		<h3>Registration:</h3>
		<div>
			<form method="post" action="Registration"
				enctype="application/x-www-form-urlencoded">
				<div id="center">
					<p>
						Name: <br> <input type="text" placeholder="name"
							name="name" size=25 value="">
					</p>
					<p>
						Surname: <br> <input type="text" placeholder="surname"
							name="surname" size=25 value="">
					</p>

					<p>
						Passport: <br> <input type="text"
							placeholder="passport full number"
							name="passport" size=25 value="">
					</p>

					<p>
						Address: <br> <input type="text" placeholder="address"
							name="address" size=25 value="">
					</p>

					<p>
						E-mail (login): <br> <input type="text" placeholder="e-mail"
							name="email" size=25 value="">
					</p>
					<p>
						Password: <br> <input type="password" placeholder="password"
							name="password" size=25 value="">
					</p>
					<p>
						Is Employee: <input type="checkbox" name="isemployee">
					</p>
					<p>
						Employee registration password: <br> <input type="password" placeholder="Password for employe registration"
							name="employeePassword" size=25 value="">
					</p>
					<input type="submit" value="Create an account"/>
				</div>
			</form>
			<div>
				<p>If you already have registration, please <a href="login.jsp">login</a></p>
			</div>
		</div>

</body>
</html>