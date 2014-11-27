<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/ECare/employee">ECare</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/ECare/employee/about">My info</a></li>
                <li><a href="/ECare/employee/newCustomer">Register new customer</a></li>
                <li><a href="/ECare/employee/searchCustomer">Search customer</a></li>
                <li><a href="/ECare/employee/tariff">Create new tariff</a></li>
                <li><a href="/ECare/logout">Logout</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
