<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>

	<div class="outer">
		<h3>Registration:</h3>
		<div class="inner">
			<form method="post" action="Registration"
				enctype="application/x-www-form-urlencoded">
				<div id="center">
					<p>
						Name: <br> <input type="text" placeholder="name"
							class="simple-input" name="name" size=25 value="">
					</p>
					<p>
						Lastname: <br> <input type="text" placeholder="lastname"
							class="simple-input" name="lastname" size=25 value="">
					</p>

					<p>
						Birth date: <br> <input type="text" placeholder="yyyy-mm-dd"
							class="simple-input" name="birthdate" size=25 value="">
					</p>

					<p>
						Passport: <br> <input type="text"
							placeholder="passport series and number" class="simple-input"
							name="passport" size=25 value="">
					</p>

					<p>
						Address: <br> <input type="text" placeholder="address"
							class="simple-input" name="address" size=25 value="">
					</p>

					<p>
						E-mail (login): <br> <input type="text" placeholder="e-mail"
							class="simple-input" name="email" size=25 value="">
					</p>
					<p>
						Password: <br> <input type="password" placeholder="password"
							class="simple-input" name="password" size=25 value="">
					</p>
					<input type="submit" value="Create an account"/>
				</div>
			</form>
			<div>
				<p>If you already have registration, please <a href="login.jsp" class="inline-link">login</a></p>
			</div>
		</div>
	</div>

</body>
</html>