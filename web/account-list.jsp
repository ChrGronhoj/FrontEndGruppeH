<%-- 
    Document   : account-list
    Created on : 03-03-2014, 19:06:25
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
        
        <title>Account list</title>
    </head>
    <body>
        <h1>Account list page</h1>
        Welcome to the account list page
        <hr/>
        ${message} ${accounts.size()}
       
        <%
    String customerID = request.getParameter("customerID");
   session.setAttribute( "customerID", customerID );
%>
        <table border="1" style="width:400px">
            <c:forEach var="accounts" items="${accounts}">
                <tr>
                    <td>
                        <a href='Controller?command=show-account-details&accountNumber=${accounts.number}'>${accounts.number}</a>
                    </td>
                    <td>
                        ${accounts.type} 
                    </td>
                    <td>
                        <a href="Controller?command=prepare-transfer&accountNumber=${accounts.number}">Transfer money</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <hr/> 
        <form action="Controller" method="POST">
            <button name="command" value="main">Back to Main</button>
        </form>
    </body>
</html>
