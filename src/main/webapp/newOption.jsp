<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New option</title>
    </head>
    <body>
        <h1>New option</h1>
		<div>
			<form method="post" action="NewOption"
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
					<p>
						Price: <br> <input type="text" placeholder="connection price"
										  name="price" value="">
					</p>
					<input type="submit" value="Create new option"/>
				</div>
			</form>
			<div>
				<p>Back to <a href="controlPanel.jsp">control panel</a></p>
			</div>
		</div>
    </body>
</html>
