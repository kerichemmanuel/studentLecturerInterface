<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Student List - StudentLecturer Application </title>
    <s:url var="url_css" value="/static/css/style.css"/>
    <link href="${url_css}" rel="stylesheet" type="text/css"/>
    <s:url var="url_jqlib" value="/static/js/jquery-3.2.1.min.js"/>
    <script src="${url_jqlib}"></script>
    <script>
        function changeStatus(sid, lstatus) {
            //alert(userId+", "+loginStatus);
            $.ajax({
                url: 'change_student_status',
                data: {studentId: sid, loginStatus: lstatus},
                success: function (data) {
                    alert(data);
                }
            });
        }
    </script>
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
            <h3>List Of Students</h3>
                <%-- Student Registration Success Message --%>
                <c:if test="${param.act eq 'regStud'}">
                    <p class="success">Student Saved Successfully</p>
                </c:if>
            <table border="1">
                <tr>
                    <th>SR</th>
                    <th>STUDENT ID</th>
                    <th>FIRST NAME</th>
                    <th>LAST NAME</th>
                    <th>FACULTY</th>
                    <th>DEPARTMENT</th>
                    <th>EMAIL</th>
                    <th>PHONE</th>
                    <th>YEAR LEVEL</th>
                    <th>STATUS</th>
                    <th>ACTION</th>
                </tr>
                <c:forEach var="s" items="${studentList}" varStatus="st">
                    <tr>
                        <td>${st.count}</td>
                        <td>${s.regNo}</td>
                        <td>${s.firstName}</td>
                        <td>${s.lastName}</td>
                        <td>${s.faculty}</td>
                        <td>${s.department}</td>
                        <td>${s.email}</td>
                        <td>${s.phone}</td>
                        <td>${s.yearLevel}</td>
                        <td>
                            <select id="id_${s.studentId}" onchange="changeStatus(${s.studentId},$(this).val())">
                                <option value="1">Active</option>
                                <option value="2">Block</option>
                            </select>
                            <script>
                                $('#id_${s.studentId}').val(${s.loginStatus});
                            </script>
                                <%-- ${u.loginStatus} --%>
                        </td>
                        <s:url var="url_del" value="/admin/del_student">
                            <s:param name="sid" value="${s.studentId}"/>
                        </s:url>
                        <s:url var="url_edit" value="/admin/edit_student">
                            <s:param name="sid" value="${s.studentId}"/>
                        </s:url>
                        <td>
                            <a onclick="if(!(confirm('Are You Sure You Want To Edit The Record?')))
                                return false"  href="${url_edit}">Edit</a> |
                            <a onclick="if(!(confirm('Are You Sure You Want To Delete The Record?')))
                                return false"  href="${url_del}">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>

        </td>
    </tr>

<div class="footer">
    <jsp:include page="include/footer.jsp"/>
</div>
</body>
</html>
