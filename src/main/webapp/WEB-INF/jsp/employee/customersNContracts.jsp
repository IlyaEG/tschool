<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" type="text/css" media="screen"
              href="resources/css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customers and Contacts</title>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <h1>Customers and Contacts</h1>
        <div>
            <form name="searchCustomer" method="post" action="searchCustomer"
                  enctype="application/x-www-form-urlencoded">
                <input type="submit" value="Search customer" />

            </form>
        </div>
        <div>
            <form name="getAllCustomersUsers" method="post" action="allCustomers"
                  enctype="application/x-www-form-urlencoded">
                <input type="submit" value="All customers" />

            </form>
        </div>
        <div>
            <form name="getAllContracts" method="post" action="allContracts"
                  enctype="application/x-www-form-urlencoded">
                <input type="submit" value="All contracts" />

            </form>
        </div>
        <div>
            <form name="getAllCustomersUsers" method="post" action="newCustomer"
                  enctype="application/x-www-form-urlencoded">
                <input type="submit" value="New customer" />
            </form>
        </div>
    </body>
</html>
