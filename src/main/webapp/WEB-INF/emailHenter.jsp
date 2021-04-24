<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">

    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>

        <div>
            <h2>Postbuddet</h2>

            <form method="post" action="${pageContext.request.contextPath}/fc/moneypage">
                    <label for="customerEmail">Insert email:</label>
                    <input id="customerEmail" name="customerEmail" type="text"><b/>
                    <label for="amountToAdd">Insert amount:</label>
                    <input id="amountToAdd" name="amountToAdd" type="text"><b/>
                    <button type="submit">Insert amount</button>


            </form>
        </div>

        <c:if test="${requestScope.error != null}">
            <p style="color: red">
                ${requestScope.error}
            </p>
        </c:if>


    </jsp:body>

</t:genericpage>
