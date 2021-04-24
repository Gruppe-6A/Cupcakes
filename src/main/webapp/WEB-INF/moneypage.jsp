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
            <h2>Insert amount to customers account</h2>



            ${requestScope.customerEmail}
           <br/>
            ${requestScope.amountToAdd}
        </div>

        <c:if test="${requestScope.error != null}">
            <p style="color: red">
                ${requestScope.error}
            </p>
        </c:if>


    </jsp:body>

</t:genericpage>
