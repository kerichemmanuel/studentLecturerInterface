<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lecturer Dashboard - Interface Application </title>
    <s:url var="url_css" value="/static/css/style.css"/>
    <link href="${url_css}" rel="stylesheet" type="text/css"/>
</head>
<s:url var="url_bg" value="/static/images/bg.jpg"/>
<body background="${url_bg}">

    <tr>
        <td height="80px">
            <%-- Header --%>
            <jsp:include page="include/header.jsp"/>
        </td>
    </tr>
    <tr>
        <td height="25px">
            <%-- Menu --%>
            <jsp:include page="include/menu.jsp"/>
        </td>
    </tr>
    <tr>
        <td height="350px" valign="top">
            <%-- Page Content Area--%>
            <h1>Lecturer Dashboard</h1>
            TODO : Lecturer Options in this page
        </td>
    </tr>
    <%-- Footer --%>
    <div class="footer">
        <jsp:include page="include/footer.jsp"/>
    </div>
</body>
</html>
