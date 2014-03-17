<!DOCTYPE html>
<html>
    <head>
        <title>Register Customer</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
    </head>
    <body>
        <h1>Customer Form</h1>
        <hr/>
        <!--<form action="http://datdb.cphbusiness.dk:8080/Echo/" method="post">-->
        <form action="Controller" method="POST">
            <table border="0">
                <tr>
                    <th>CPR:</th>
                    <td><input type="text" name="cpr" value="${customerDetail.getCpr()}"/></td>
                </tr>
                <tr>
                    <th>Title:</th>
                    <td><input type="text" name="title" value="${customerDetail.getTitle()}"/></td>
                </tr>
                <tr>
                    <th>First Name:</th>
                    <td><input type="text" name="firstName" value="${customerDetail.getFirstName()}"/></td>
                </tr>
                <tr>
                    <th>Last Name:</th>
                    <td><input type="text" name="lastName" value="${customerDetail.getLastName()}"/></td>
                </tr>
                <tr>
                    <th>Street:</th>
                    <td><input type="text" name="street" value="${customerDetail.getStreet()}"/></td>
                </tr>
                <tr>
                    <th>Postal Code:</th>
                    <td><input type="text" name="postalCode" value="${customerDetail.getPostalCode()}"/></td>
                </tr>
                <tr>
                    <th>Postal District:</th>
                    <td><input type="text" name="postalDistrict" value="${customerDetail.getPostalDistrict()}"/></td>
                </tr>
                <tr>
                    <th>Phone:</th>
                    <td><input type="text" name="phone" value="${customerDetail.getPhone()}"/></td>
                </tr>
                <tr>
                    <th>E-mail:</th>
                    <td><input type="text" name="email" value="${customerDetail.getEmail()}"/></td>
                </tr>
                <tr class="ButtonRow">
                    <td colspan="2">
                        <button type="submit" name="command" value="save-customer">Save Customer</button>
                        <button type="submit" name="command" value="main">Back to Main</button>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
