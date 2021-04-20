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
                <p>
                 <label for="bottoms">Choose a bottom:</label>

                 <select name="bottoms" id="bottoms">
                     <option value="Chocolate">Chocolate</option>
                     <option value="vanilla">vanilla</option>
                     <option value="Nutmeg">Nutmeg</option>
                     <option value="Pistacchio">Pistacchio</option>
                     <option value="Almond">Almond</option>
                 </select>
                 <label for="toppings">Choose a topping</label>
                 <select name="toppings" id="toppings">
                     <option value="Chocolate">Chocolate</option>
                     <option value="Blueberry">Blueberry</option>
                     <option value="Strawberry">Strawberry</option>
                     <option value="Bluecheese">Blue cheese</option>
                     <option value="Raspberry">Raspberry</option>
                     <option value="Orange">Orange</option>
                     <option value="Lemon">Lemon</option>
                     <option value="Rumraisin">Rum raisin</option>
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

        </div>

    </jsp:body>
</t:genericpage>