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



             TODO




<%-- Footer --%>
<div class="footer">
    <jsp:include page="include/footer.jsp"/>
</div>
</body>
</html>


