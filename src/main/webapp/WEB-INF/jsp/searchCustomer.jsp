
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search customer</title>
    </head>
    <body>
        <h1>Search customer</h1>
		<form method="post" action="Search"
				  enctype="application/x-www-form-urlencoded">
				<div>
					<p>
						Phone Number: <br> <input type="text" placeholder="phone number"
													name="number" value="">
					</p>
					<input type="submit" value="Search"/>
				</div>
			</form>
			<div>
				<p>Back to <a href="controlPanel.jsp">control panel</a></p>
			</div>
    </body>
</html>
