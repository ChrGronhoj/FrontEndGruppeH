<%-- 
    Document   : transfer-edit
    Created on : 03-03-2014, 19:06:39
    Author     : christian-if
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width"/>
        <link type="text/css" rel="stylesheet" href="default.css"/>
        
        <title>Transfer edit</title>
    </head>
    <body>
         <h1>Register Form</h1>
        <hr/>
        <!--<form action="Controller?command=transfer-amount&accountNumber=${accountNumber}">-->
        <form action="Controller" method="POST">
            <table border="0">
                <tr>
                    <th>From Account:</th>
                    <td><input type="text" name="accountNumber" value="${accountNumber}"/></td>
                </tr> 
                <tr>
                    <th>To Account:</th>
                    <td><input type="text" name="toAccount" value=""/></td>
                </tr>
                <tr>
                    <th>$$$:</th>
                    <td><input type="text" name="money" value=""/></td>
                </tr>
                <tr class="ButtonRow">
                    <td colspan="2">
                        <button type="submit" name="command" value="cancel-transfer">Cancel</button>
                        <button type="submit" name="command" value="transfer-amount">Transfer</button>
                    </td>
                </tr>
            </table>
                            <input type="hidden" name="customerID" value="${customers.cpr}"
         </form>
    </body>
</html>
