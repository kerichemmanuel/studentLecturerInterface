<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lecturer List - StudentLecturer Application </title>
    <s:url var="url_css" value="/static/css/style.css"/>
    <link href="${url_css}" rel="stylesheet" type="text/css"/>
    <s:url var="url_jqlib" value="/static/js/jquery-3.2.1.min.js"/>
    <script src="${url_jqlib}"></script>
    <script>
        function changeStatus(lid, lstatus) {
            //alert(userId+", "+loginStatus);
            $.ajax({
                url: 'change_lecturer_status',
                data: {lecturerId: lid, loginStatus: lstatus},
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
            <h3>List Of Lecturers</h3>
            <table border="1">
                <tr>
                    <th>SR</th>
                    <th>LECTURER ID</th>
                    <th>FIRST NAME</th>
                    <th>LAST NAME</th>
                    <th>FACULTY</th>
                    <th>DEPARTMENT</th>
                    <th>EMAIL</th>
                    <th>PHONE</th>
                    <th>CITATION</th>
                    <th>SPECIALIZATION</th>
                    <th>STATUS</th>
                </tr>
                <c:forEach var="l" items="${lecturerList}" varStatus="st">
                    <tr>
                        <td>${st.count}</td>
                        <td>${l.staffNo}</td>
                        <td>${l.firstName}</td>
                        <td>${l.lastName}</td>
                        <td>${l.faculty}</td>
                        <td>${l.department}</td>
                        <td>${l.email}</td>
                        <td>${l.phone}</td>
                        <td>${l.citation}</td>
                        <td>${l.specialization}</td>

                        <td>
                            <select id="id_${s.lecturerId}" onchange="changeStatus(${l.lecturerId},$(this).val())">
                                <option value="1">Active</option>
                                <option value="2">Block</option>
                            </select>
                            <script>
                                $('#id_${l.lecturerId}').val(${l.loginStatus});
                            </script>
                                <%-- ${u.loginStatus} --%>
                        </td>
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
