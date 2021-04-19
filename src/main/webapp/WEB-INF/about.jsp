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

            <h2>About Olsker cupcakes</h2>

            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum odio ligula, elementum nec lobortis euismod, sodales vitae est. Duis tempus tempus ullamcorper. Mauris luctus facilisis neque, et volutpat dolor congue ac. Nunc lobortis hendrerit ligula eu pellentesque. Ut blandit felis a mollis porta. Suspendisse sed elit sapien. Curabitur ultricies ante et nisi pretium, non consequat tellus ullamcorper. Sed vitae dictum turpis. Sed pharetra lectus quis urna fermentum, ac pharetra augue laoreet. Etiam fringilla, tortor interdum maximus sollicitudin, elit est dignissim sapien, non dignissim nisi lorem sit amet justo. Vestibulum aliquet condimentum interdum. Duis nec vestibulum eros. Duis porta vehicula lacinia. Sed non volutpat nulla. Ut id eros hendrerit, aliquam ligula nec, aliquet metus. Quisque luctus viverra diam, vitae lacinia quam placerat nec.

                Nam vehicula eros quis elit blandit, id sagittis nibh fermentum. Aliquam turpis turpis, sollicitudin vel viverra tincidunt, varius ac sem. Aliquam pharetra ligula ut laoreet ultricies. Aliquam non sem et sem scelerisque bibendum. Nam leo felis, pharetra efficitur dapibus id, placerat non nisl. Cras ultricies hendrerit dapibus. Praesent finibus blandit neque, nec vehicula ipsum hendrerit sed. Donec vel porta sem. Fusce sed odio pretium, ullamcorper augue et, hendrerit orci. Quisque elit orci, egestas ac justo cursus, commodo ullamcorper ligula.

                Vestibulum faucibus tincidunt tempor. Pellentesque dapibus egestas sapien, scelerisque dictum nibh viverra et. Cras id tincidunt dui, viverra posuere purus. Nunc finibus mauris non elit viverra lacinia. Pellentesque pharetra efficitur tortor. Nunc facilisis, odio nec dictum placerat, elit est volutpat quam, nec lacinia nulla leo at dolor. Sed finibus libero a ligula pretium elementum eu et erat. Etiam odio tortor, fermentum non urna vitae, tincidunt pharetra sem. Cras elementum justo lorem, eget interdum ligula fringilla porttitor.

                Pellentesque eu mauris rutrum, malesuada urna sed, iaculis ex. Mauris consectetur diam sapien, ut tristique elit ultrices sed. Aenean lacus massa, efficitur eget risus eget, tristique cursus nulla. Donec eu lectus ultricies, auctor tellus nec, sodales est. Quisque vehicula ante sit amet nisl auctor, nec viverra libero ornare. Cras malesuada nibh venenatis quam interdum, quis dapibus tellus tempor. Quisque porttitor placerat sodales. Fusce diam libero, euismod ut efficitur ut, venenatis ac lacus. Vestibulum hendrerit lacinia metus, non elementum tortor faucibus ac. Proin nec aliquet lectus, et sagittis massa. Aliquam congue erat viverra orci malesuada, eget mattis massa rutrum. Sed sapien lorem, consequat in est quis, dignissim molestie nisi.

                Nulla sed dui quis turpis fringilla viverra. Ut mattis feugiat blandit. Curabitur libero nunc, feugiat in ultricies nec, tempor in enim. Nunc semper tempor accumsan. Sed rutrum dui diam, nec molestie lacus convallis eget. Aliquam vel arcu sit amet turpis tincidunt varius. Integer in lacus quam. Morbi tincidunt tempus cursus. Ut rhoncus neque sed ante ultricies, quis sollicitudin tellus auctor. Sed gravida, velit vel malesuada convallis, lorem urna semper purus, volutpat hendrerit orci odio sed nibh. Proin eget tellus urna. In vehicula urna et velit pretium vulputate.</p>


        </div>

    </jsp:body>
</t:genericpage>