<%-- 
    Document   : account-edit
    Created on : 17-Mar-2014, 13:38:27
    Author     : Po
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account</title>
    </head>
    <body>
        <h1>Create Account</h1>
         <form action="Controller" method="POST">
            <table border="0">
                <tr>
                    <th>Interest</th>
                    <td><input type="text" name="interest" value=""/></td>
                </tr>
                <tr class="ButtonRow">
                    <td>
                        <button type="submit" name="command" value="save-account">Save</button>
                        <button type="submit" name="command" value="cancel-create-account">Cancel</button>
                    </td>
                </tr>
            </table>
         </form>
    </body>
</html>
