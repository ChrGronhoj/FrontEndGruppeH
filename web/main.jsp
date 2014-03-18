<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width"/>
        <link type="text/css" rel="stylesheet" href="default.css"/>

        <title>GronPo Bank ヽ༼ຈل͜ຈ༽ﾉ</title>
    </head>
    <body>
        <h1><b class=".Headline">GronPo Bank</b></h1>
        <hr>
        <h2>Welcome to GronPo Bank's main page</h2>
        <h3 style="color:black" ><b><i>GronPo Bank - We raise our dongers</i> ヽ༼ຈل͜ຈ༽ﾉ</b></h3>
        <br>
        <p style="color:darkred"><i>Welcome to GronPo Bank. We have a bit of history with professional
                monetary management. You should <b>definitely</b> trust us with all of your money.</i></p>
        <p>"It is definitely the best bank ever" - <i>Unbiased anonymous person</i></p>
        <p>"10/10" - <i>IGN</i></p>
        <p>"A wise man chooses GronPo Bank" - <i>Socrates</i></p>
        <br>

        <br/>
        <hr>
        <ul>
            From here you can navigate to:
            <li><a href="Controller?command=list-customers">Customer list page</a></li>
            <li><a href="Controller?command=create-customer">Create customer</a></li>

            <hr>
            <h5> Security implementationer</h5>
            <h6>This page can be seen by all</h6>
            <br/>

            <c:if test="${pageContext.request.isUserInRole('Customer')==true}">
                <li><a href="Controller?command=customer-main">Customer main page</a></li>
            </c:if >

            <c:if test="${pageContext.request.isUserInRole('Employee')==true || 
                          pageContext.request.isUserInRole('SuperEmployee')==true}">
                <li><a href="Controller?command=employee-main">Employee Main page</a></li>
            </c:if>

            <c:if test="${pageContext.request.isUserInRole('SuperEmployee')==true}">
                <li><a href="Controller?command=addcustomer">Add Customer</a></li>
            </c:if>

        </ul>
        <h3>
            <c:choose >
                <c:when test="${pageContext.request.remoteUser== null}">
                    <a href="Controller?command=showlogin">Login</a>
                </c:when>
                <c:otherwise>
                    <a href="Controller?command=logout">Log out</a>
                </c:otherwise>
            </c:choose>
        </h3>


    </body>
</html>