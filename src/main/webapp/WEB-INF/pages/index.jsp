
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>

<div class="container-fluid">
    <div class="row background-blond-grey padding-top-10px">
        <div class="col-md-10 col-md-offset-1 max-width-">
            <div class="slider">
                <ul>
                    <c:forEach items="${stockSliders}" var="stockSlider">
                        <li><img src="${stockSlider.picture}" alt=""></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="container-fluid">
    <div class="row centered" style="height: 1000px;">
        <div class="col-md-10 col-md-offset-1">
            <div>
                <h2> Головна    </h2>

                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    lkjskjdlkaldkasdlbgfkjlg
                </sec:authorize>

                <%--<sec:authorize access="isAuthenticated()">--%>

                <%--</sec:authorize>--%>


                <a href="/admin/adminPage"> Admin Page</a> //  "/admin/adminPage"
                 <%--${categorys};--%>
                <br>


            </div>

        </div>
    </div>
</div>



<script src="/js/stockSlider.js"></script>

<%@include file="template/footer.jsp"%>
