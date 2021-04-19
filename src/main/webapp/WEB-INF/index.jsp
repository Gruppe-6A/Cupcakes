<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Home
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div>

            <h2>Welcome to Olsker cupcakes</h2>


                <c:if test="${sessionScope.user == null}">
                <p style="font-size: larger">Log in to make an order:
                    </br><a href="fc/loginpage">Login</a> or <a href="fc/registerpage">sign up</a>
                </p>
                </c:if>


             <c:if test="${sessionScope.role == 'customer' }">
                <p style="font-size: larger">Since you're logged in, you can now order:</p>
                <p><label for="cars">Choose a car:</label>
                    <select id="cars" name="cars">
                        <option value="volvo">Volvo</option>
                        <option value="saab">Saab</option>
                        <option value="fiat">Fiat</option>
                        <option value="audi">Audi</option>
                    </select>
            </c:if>

        </div>

    </jsp:body>
</t:genericpage>