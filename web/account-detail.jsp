<%-- 
    Document   : account-detail
    Created on : 03-03-2014, 19:06:53
    Author     : christian-if
--%>

<%@page import="dk.cphbusiness.bank.contract.dto.TransferSummary"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width"/>
        <link type="text/css" rel="stylesheet" href="default.css"/>
        
        <title>Account detail</title>
    </head>
    <body>
        <h1>Account detail</h1>
        <table border="1" style="width:400px">
                <c:forEach var="ts" items="${transferSummary}">
                    <tr>
                        <td>
                            ${ts.getDate()}
                        </td>
                        <td>
                            ${ts.getAccountNumber()}
                        </td>
                        <td>
                            ${ts.getAmount()}
                        </td>
                    </tr>
                </c:forEach>   
            </table>
            <form action="Controller" method="POST">
            <button name="command" value="main">Back to Main</button>
            <button name="command" value="prepare-transfer">Make a Transfer</button>
        </form>
    </body>
</html>
