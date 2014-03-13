<%-- 
    Document   : customer-list
    Created on : 03-03-2014, 19:06:11
    Author     : christian-if
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width"/>
        <link type="text/css" rel="stylesheet" href="default.css"/>
        
        <title>Customer list</title>
    </head>
    <body>
        <h1>Customer list</h1>
        Welcome to the customer list page
        <br>
        <form action="Controller" method="POST">
        <ul>
            <table border="1" style="width:400px">
                <c:forEach var="customers" items="${customers}">
                    <tr>
                        <td>
                            <a href='Controller?command=list-customer-accounts&customerID=${customers.cpr}'> ${customers.name}</a>
                        </td>
                        <td>
                            <a href='Controller?command=list-customer-accounts&customerID=${customers.cpr}'> ${customers.cpr}</a>
                        </td>
                    </tr>
                </c:forEach>   
            </table>
            <br>
            </form>
            <hr>
        </ul>
        <form action="Controller" method="POST">
            <button name="command" value="main">Back to Main</button>
        </form>
    </body>
</html>
