<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test</title>
    </head>
    <body>
        <center>
            <% String user = (String)session.getAttribute("user");%>
            <% String userRole = (String)session.getAttribute("role");%>

            Welcome
            <%= userRole%> : <%= user%>
        </center>
    </body>
</html>