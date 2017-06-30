
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@include file="template/header.jsp"%>

<div class="container-fluid" style="height: 1200px">
    <div class="row centered">
        <div class="col-md-10 col-md-offset-1">

            <div>
                <h2> Головна    </h2>

                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    lkjskjdlkaldkasdlbgfkjlg
                </sec:authorize>

                <%--<sec:authorize access="isAuthenticated()">--%>

                <%--</sec:authorize>--%>


                <a href="/admin/adminPage"> Admin Page</a> //  "/admin/adminPage"
                 ${categorys};
                <br>


            </div>

        </div>
    </div>
</div>




<%@include file="template/footer.jsp"%>
