
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@include file="template/header.jsp"%>


<div class="container-fluid">
    <div class="row centered">
        <div class="col-md-10 col-md-offset-1">
            <h2>Admin Page</h2>
            <div>

                <form action="/create/saveCategory" method="post">
                    <input type="text" name="categoryname">
                    <input type="submit">
                </form>

            </div>

        </div>
    </div>
</div>





<%@include file="template/footer.jsp"%>