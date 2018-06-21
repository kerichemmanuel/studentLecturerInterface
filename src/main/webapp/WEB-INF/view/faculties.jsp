<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Faculty List - StudentLecturer Application </title>
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
        <td height="350px" valign="top" width="100%">
            <%-- Page Content Area--%>
            <h3>List Of Available Fuculties</h3>
            <c:if test="${param.act eq 'sv'}">
                <p class="success">Faculty Saved Successfully</p>
            </c:if>
            <c:if test="${param.act eq 'del'}">
                <p class="success">Faculty Deleted Successfully</p>
            </c:if>


            <table width="100%">
                <tr>
                    <td align="right">
                        <form action="<s:url value="/admin/faculty_search"/>">
                            <input type="text" name="freeText" value="${param.freeText}"
                                   placeholder="Enter Text To Search">
                            <button>Find</button>
                        </form>
                    </td>
                </tr>
            </table>

            <form action="<s:url value="/admin/bulk_faculty_delete"/>">
                <button onclick="if(!(confirm('Are You Sure You Want To Delete The Selected Records?')))
                                return false">Delete Selected Records</button>
                <br/><br/>
                <table border="1" cellpadding="3" width="100%">
                    <tr>
                        <th>SELECT</th>
                        <th>FACULTY ID</th>
                        <th>FACULTY CODE</th>
                        <th>FACULTY NAME</th>
                        <th>ACTION</th>
                    </tr>

                    <c:if test="${empty facultyList}">
                        <tr>
                            <td align="center" colspan="8" class="error">No Records Present</td>
                        </tr>
                    </c:if>

                    <c:forEach var="f" items="${facultyList}" varStatus="st">
                        <tr>
                            <td align="center"><input type="checkbox" name="fid" value="${f.facultyId}"/></td>
                            <td>${f.facultyId}</td>
                            <td>${f.facultyCode}</td>
                            <td>${f.facultyName}</td>

                            <s:url var="url_del" value="/admin/del_faculty">
                                <s:param name="fid" value="${f.facultyId}"/>
                            </s:url>
                            <s:url var="url_edit" value="/admin/edit_faculty">
                                <s:param name="fid" value="${f.facultyId}"/>
                            </s:url>
                            <td>
                                <a onclick="if(!(confirm('Are You Sure You Want To Edit The Record?')))
                                return false"  href="${url_edit}">Edit</a> |
                                <a onclick="if(!(confirm('Are You Sure You Want To Delete The Record?')))
                                return false"  href="${url_del}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
        </td>
    </tr>
<div class="footer">
    <jsp:include page="include/footer.jsp"/>
</div>
</body>
</html>
