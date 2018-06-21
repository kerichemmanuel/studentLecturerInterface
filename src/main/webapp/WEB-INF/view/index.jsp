<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title> User Login </title>


    <s:url var="url_css_bootstrap" value="/static/bootstrap-dist/css/bootstrap.css"/>
    <link href="${url_css_bootstrap}" rel="stylesheet" type="text/css"/>

    <s:url var="url_css" value="/static/css/style.css"/>
    <link href="${url_css}" rel="stylesheet" type="text/css"/>
</head>

<body background="${url_bg}">
<jsp:include page="include/header.jsp"/>
<s:url var="url_bg" value="/static/images/bg.jpg"/>
<jsp:include page="include/menu.jsp"/>


<%-- Error Displayed upon wrong logging in Details--%>
<c:if test="${err!=null}">
    <p class="error">${err}</p>
</c:if>


<%-- Logout Success Message --%>
<c:if test="${param.act eq 'lo'}">
    <p class="success">Logout Successfully! Thanks for using StudentLecturer application.</p>
</c:if>

<%-- Student Registration Success Message --%>
<c:if test="${param.act eq 'reg'}">
    <p class="success">User Registered Successfully. Please login</p>
</c:if>

<%--

<div class="container">
    <div class="row">
        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3 col-sm-offset-3">
            <div style="margin-top: 10px">
                <hr>
                <div class="panel panel-primary">
                    <div class="panel-body">

                        <s:url var="url_login" value="/login"/>
                        <f:form action="${url_login}" modelAttribute="command">
                            <div class="form-group">
                                <h3>User Login</h3>
                                <hr/>

                                <input type="text" class="form-control" name="loginName"
                                       placeholder="Enter Your User Name">
                            </div>
                            <div class="form-group">

                                <input type="password" class="form-control" name="password"
                                       placeholder="Enter Password">
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary">
                                    <i class="glyphicon-lock"></i>
                                    &nbsp;
                                    Login
                                </button>
                            </div>
                            <br>
                            <s:url var="url_reg_form" value="/student_registration_form"/>
                            <p>If you don't have account <a href=${url_reg_form}
                                                                    class="badge-primary">Register Here</a></p>
                        </f:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
--%>
<%--</div>--%>
<%-- Footer --%>
<div class="footer">
    <jsp:include page="include/footer.jsp"/>
</div>
</body>
</html>


