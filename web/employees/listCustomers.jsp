<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List Customers</title>
  </head>
  <body>
    <h1>List Customers</h1>

    <h2>Table with links </h2>
    <table border='1'>     
      <c:forEach var="customer" items="${customers}">
        <tr><td>
            <a href='Controller?custid=${customer.customerId}&command=viewcustomer'>
              ${customer.customerId}</a></td><td>${customer.firstName} 
            ${customer.lastName}</td></tr>
          </c:forEach>    
    </table>
    <h2>Customer ID entered via a form (command given via a hidden input field)</h2>
    <form action='Controller'>
      <label>Enter id for customer</label>
      <input type='text' name='custid' id='custid'>
      <input type='hidden' name='command' value='viewcustomer'>
      <input type='submit' value='show details'>
    </form>
    <ul>
      <li><a href="Controller?command=employee-main">Employee Start Page</a></li>
      <li><a href="Controller?command=main">Back to main</a></li>
    </ul>
  </body>
</html>
