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
        <table class="table table striped">
        <thead>
        <tr>
            <td>Antal</td>
            <td>Top</td>
            <td>Bund</td>
            <td>Pris</td>
        </tr>
        </thead>
            <c:forEach var="basketItem" items="${sessionScope.basket.basketItemList}">
                <tr>
                    <td>${basketItem.quantity}</td>
                    <td>${basketItem.top.name}</td>
                    <td>${basketItem.bottom.name}</td>
                    <td>${basketItem.price}</td>

                </tr>
            </c:forEach>
            <tr>
                <td></td>
                <td></td>
                <td>pris i alt:</td>
                <td>${sessionScope.basket.totalSum()}</td>

            </tr>
        </table>


    </jsp:body>

</t:genericpage>
