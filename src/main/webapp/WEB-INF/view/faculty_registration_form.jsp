<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Faculty Form - StudentLecturer Application </title>
    <s:url var="url_css" value="/static/css/style.css"/>
    <link href="${url_css}" rel="stylesheet" type="text/css"/>
</head>
<s:url var="url_bg" value="/static/images/bg.jpg"/>
<body background="${url_bg}">
<table border="1" width="80%" align="center">
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
            <h3>Faculty Registration Form</h3>
            <c:if test="${err!=null}">
                <p class="error">${err}</p>
            </c:if>
            <s:url var="url_faculty_save" value="/admin/save_faculty"/>
            <f:form action="${url_faculty_save}" modelAttribute="command">
                <table border="1">
                    <tr>
                        <td>Faculty Code</td>
                        <td><f:input path="facultyCode"/></td>
                        <td><f:errors path="facultyCode" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Faculty Name</td>
                        <td><f:input path="facultyName"/></td>
                        <td><f:errors path="facultyName" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="right">
                            <button>Save</button>
                        </td>
                    </tr>
                </table>
            </f:form>
        </td>
    </tr>
    <tr>
        <td height="25px">
            <%-- Footer --%>
            <jsp:include page="include/footer.jsp"/>
        </td>
    </tr>
</table>
</body>
</html>
