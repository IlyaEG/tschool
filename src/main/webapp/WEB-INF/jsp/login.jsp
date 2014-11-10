<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Authorization</h1>
        <form name="user" method="post" action="Login"
              enctype="application/x-www-form-urlencoded">

            Login:<input type="text" name="login" value="" />
            <br/>
            Password:<input type="password" name="password" value="" />
            <br/>
            <input type="submit" value="Login" />

        </form>
        <div>
            <p>
                If you haven't registered yet, please proceed to <a
                    href="registration.jsp" class="inline-link">registration</a>.
            </p>
        </div>
    </body>
</html>