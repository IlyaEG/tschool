<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customers and Contacts</title>
    </head>
    <body>
        <h1>Customers and Contacts</h1>
        <div>
            <form name="searchCustomer" method="post" action="searchCustomer.jsp"
                  enctype="application/x-www-form-urlencoded">
                <input type="submit" value="Search customer" />

            </form>
        </div>
        <div>
            <form name="getAllCustomersUsers" method="post" action="AllCustomers"
                  enctype="application/x-www-form-urlencoded">
                <input type="submit" value="All customers" />

            </form>
        </div>
        <div>
            <form name="getAllContracts" method="post" action="AllContracts"
                  enctype="application/x-www-form-urlencoded">
                <input type="submit" value="All contracts" />

            </form>
        </div>
        <div>
            <form name="getAllCustomersUsers" method="post" action="newCustomer.jsp"
                  enctype="application/x-www-form-urlencoded">
                <input type="submit" value="New customer" />
            </form>
        </div>
        <div>
            <a href="controlPanel.jsp">Back to control panel home page</a>.
        </div>
    </body>
</html>
