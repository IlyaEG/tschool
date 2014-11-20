<%-- 
    Document   : home
    Created on : Nov 13, 2014, 1:57:12 PM
    Author     : ilya
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" type="text/css" media="screen" href="resources/css/style.css"/>
        <title>Customer Home</title>
    </head>

    <body>
        <jsp:include page="menu.jsp" />
        <h1 id="banner">Customer Home</h1>
        <hr/>

        <p>Welcome <span id="username"><%=SecurityContextHolder.getContext().getAuthentication().getName()%></span>!</p>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean et velit et sem
            fermentum viverra. Duis fringilla consequat lectus, et rhoncus mauris porta ut. Cum
            sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.
            Donec commodo lorem sed felis iaculis pretium. Cras vel scelerisque ipsum.
            Donec a lacus lectus, ac dignissim dui. Duis vel dui et lacus dapibus lacinia. Mauris
            lacus metus, semper in varius vitae, ornare at augue. Nam enim elit, iaculis iaculis
            viverra at, blandit quis turpis. Nulla turpis quam, suscipit sed pellentesque sit amet,
            fermentum nec mauris. In non urna ornare sem cursus luctus. Pellentesque sed leo
            elit. Duis ut felis dui, et mollis nibh. Suspendisse faucibus molestie feugiat. Pellentesque
            non velit blandit ipsum auctor tempor placerat a eros. Quisque nec porttitor velit.</p>
    </body>
</html>
