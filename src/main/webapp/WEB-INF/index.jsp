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
            <c:if test="${sessionScope.role == 'employee' }">
               <h1>Hello, ${sessionScope.email}.</h1>
                <p>What would you like to do?</p>
                <a class="btn btn-primary" href="fc/employeepage" role="button">View customers and their orders</a>

            </c:if>

             <c:if test="${sessionScope.role == 'customer' }">
                <p style="font-size: larger">Since you're logged in, you can now order:</p>
                <p>
                 <form method="post" action="${pageContext.request.contextPath}/fc/checkout">
                 <label for="bottoms">Choose a bottom:</label>
                 <select name="bottoms" id="bottoms">
                     <c:forEach var="bottomItem" items="${applicationScope.bottomList}">
                     <option value="1">Chocolate (5.0kr)</option>
                     <option value="2">vanilla (5.0kr)</option>
                     <option value="3">Nutmeg (5.0kr)</option>
                     <option value="4">Pistacchio (6.0kr)</option>
                     <option value="5">Almond (7.0kr)</option>
                     </c:forEach>
                 </select>
                 <label for="toppings">Choose a topping</label>
                 <select name="toppings" id="toppings">
                     <c:forEach var="topItem" items="${applicationScope.topList}">
                     <option value="1">Chocolate (5.0kr)</option>
                     <option value="2">Blueberry (5.0kr)</option>
                     <option value="3">Strawberry (6.0kr)</option>
                     <option value="4">Blue cheese (8.0kr)</option>
                     <option value="5">Raspberry (5.0kr)</option>
                     <option value="6">Orange (8.0kr)</option>
                     <option value="7">Lemon (8.0kr)</option>
                     <option value="8">Rum raisin (7.0kr)</option>
                     <option value="9">Crispy (6.0kr)</option>
                     </c:forEach>
                 </select>
                     <label for="toppings">Choose a topping</label>
                     <select name="amount" id="quantity">
                         <option value="1">1 stk.</option>
                         <option value="2">2 stk.</option>
                         <option value="3">3 stk.</option>
                         <option value="4">4 stk.</option>
                         <option value="5">5 stk.</option>
                     </select>


                <%-- <div class="dropdown mb-3">
                      <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          Choose a bottom
                      </button>
                      <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                          <a class="Chocolate" href="#">Chocolate</a>
                          <a class="vanilla" href="#">Vanilla</a>
                          <a class="Nutmeg" href="#">Nutmeg</a>
                          <a class="Pistacchio" href="#">Pistacchio</a>
                          <a class="Almond" href="#">Almond</a>
                      </div>
                      <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          Choose a topping
                      </button>
                      <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                          <a class="Chocolate" href="#">Chocolate</a>
                          <a class="Blueberry" href="#">Blueberry</a>
                          <a class="Raspberry" href="#">Raspberry</a>
                          <a class="Strawberry" href="#">Strawberry</a>
                          <a class="Bluecheese" href="#">Blue cheese</a>
                          <a class="Orange" href="#">Orange</a>
                          <a class="Lemon" href="#">Lemon</a>
                          <a class="Rumraisin" href="#">Rum raisin</a>
                      </div>--%>
                  </div>
                    <button class="btn btn-success" type="submit">Add to cart</button>
                </p>
            </c:if>
        </form>


    </jsp:body>
</t:genericpage>