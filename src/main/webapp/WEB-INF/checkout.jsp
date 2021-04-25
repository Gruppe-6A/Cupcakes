<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Demo Page for Customer Roles
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        Here's your order:</br>
        Bottoms: ${requestScope.getBottomsNames} ${requestScope.getBottomsPrice}kr</br>
        Toppings: ${requestScope.getToppingsNames} ${requestScope.getToppingsPrice}kr</br>
        Sum: ${requestScope.getSum}kr

    <form action="${pageContext.request.contextPath}/fc/receipt.jsp" method="post">
        <button class="btn btn-success" type="submit">Checkout</button>
    </form>
    </jsp:body>

</t:genericpage>
