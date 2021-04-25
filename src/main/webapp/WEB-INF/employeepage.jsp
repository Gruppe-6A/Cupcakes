<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Demo Page for Employee Roles
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        This is a list of all orders:

        <table>
            <thead><th>Customer</th><th>Orders ID</th><th>Topping</th><th>Bottom</th></thead>
            <c:forEach var="cupcakeEntryList" items="${requestScope.cupcakeEntryList}">
                <tr>
                    <td>${cupcakeEntryList.email}</td>
                    <td>${cupcakeEntryList.orders_id}</td>
                    <td>${cupcakeEntryList.topping}</td>
                    <td>${cupcakeEntryList.bottom}</td>
                </tr>
            </c:forEach>
        </table>

    </jsp:body>
</t:genericpage>
