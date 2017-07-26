
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>

<div id="myCarousel" class="carousel slide" data-interval="3000" data-ride="carousel">
    <ol class="carousel-indicators">
            <c:set var="n" value="0"/>
            <c:forEach items="${stockSliders}" var="stockSlider">
                <li data-target="#myCarousel" data-slide-to="${stockSlider.id}" <c:if test="${n == 0}">class="active"</c:if> >
                    <p class="visibility-hidden">${n = n+1} </p>
                </li>
            </c:forEach>
    </ol>
    <div class="carousel-inner">
        <c:set var="n" value="0"/>
        <c:forEach items="${stockSliders}" var="stockSlider">
            <div class <c:if test="${n == 0}">="item active" </c:if>
            <c:if test="${n > 0}">="item" </c:if> >
                <div class="carousel-caption" style="width: auto;">
                    <a href="#">
                        <p class="visibility-hidden">${n = n + 1} </p>
                        <img src="${stockSlider.picture}" alt="">
                    </a>
                </div>
            </div>
        </c:forEach>
    </div>
    <!-- Навигация для карусели -->
    <a class="carousel-control left" href="#myCarousel" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left color-red"></span>
    </a>
    <a class="carousel-control right" href="#myCarousel" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right color-red"></span>
    </a>
</div>




<%--<div class="container-fluid">--%>
    <%--<div class="row background-blond-grey padding-top-10px">--%>
        <%--<div class="col-md-10 col-md-offset-1 max-width-">--%>
            <%--<div class="slider">--%>
                <%--<ul>--%>

                <%--</ul>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>


<%--<c:forEach items="${stockSliders}" var="stockSlider">--%>
<%--<li><img src="${stockSlider.picture}" alt=""></li>--%>
<%--</c:forEach>--%>
<div class="container-fluid">
    <div class="row centered" style="height: 1000px;">
        <div class="col-md-10 col-md-offset-1">
            <div>
                <h2> Головна    </h2>

                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    lkjskjdlkaldkasdlbgfkjlg
                </sec:authorize>


                <br>


            </div>

        </div>
    </div>
</div>




<%@include file="template/footer.jsp"%>
