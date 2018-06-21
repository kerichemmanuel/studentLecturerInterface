<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lecturer Registration - StudentLecturer Application </title>
    <s:url var="url_css" value="/static/css/style.css"/>
    <link href="${url_css}" rel="stylesheet" type="text/css"/>
    <s:url var="url_jqlib" value="/static/js/jquery-3.2.1.min.js"/>
    <script src="${url_jqlib}"></script>
    <script>
        //Checking to see wheather such lecturer exists in the database
        $(document).ready(function () {
            $("#id_check_avail").click(function () {
                $.ajax({
                    url: '/check_lecturer_avail',
                    data: {staffNo: $("#id_lecturerStaffNo").val()},
                    success: function (data) {
                        $("#id_res_div").html(data);
                    }
                });
            });
        });
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
            <h3>Lecturer Registration</h3>
            <c:if test="${err!=null}">
                <p class="error">${err}</p>
            </c:if>
            <s:url var="url_lecReg" value="/registerLecturer"/>
            <f:form action="${url_lecReg}" modelAttribute="command">
                <table border="1" align="center">
                    <tr>
                        <td>Staff No:</td>
                        <td><f:input id="id_lecturerStaffNo" path="staffNo"/>
                            <button type="button" id="id_check_avail">Check Availability</button>
                            <div id="id_res_div" class="error"></div>
                        <td><f:errors path="staffNo" cssClass="error"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>First Name</td>
                        <td><f:input path="firstName"/></td>
                        <td><f:errors path="firstName" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><f:input path="lastName"/></td>
                        <td><f:errors path="lastName" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Sur Name</td>
                        <td><f:input path="otherName"/></td>
                        <td><f:errors path="otherName" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Gender</td>
                        <td><f:input path="gender"/></td>
                        <td><f:errors path="gender" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Faculty</td>
                        <td><f:input path="faculty"/></td>
                        <td><f:errors path="faculty" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Department</td>
                        <td><f:input  path="department"/></td>
                        <td><f:errors path="department" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><f:input path="email"/></td>
                        <td><f:errors path="email" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Phone</td>
                        <td><f:input path="phone"/></td>
                        <td><f:errors path="phone" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Citation</td>
                        <td><f:input path="citation"/></td>
                        <td><f:errors path="citation" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Specialization</td>
                        <td><f:input path="specialization"/></td>
                        <td><f:errors path="specialization" cssClass="error"/></td>
                    </tr>
                        <%-- <tr>
                             <td>Year Level</td>
                             <td><f:input path="lecturer.citation"/></td>
                         </tr>--%>
                    <tr>
                        <td>Password</td>
                        <td><f:password path="password"/></td>
                        <td><f:errors path="password" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <button>Submit</button>
                            <br/>
                        </td>
                    </tr>
                </table>
            </f:form>
        </td>
    </tr>
    <%-- Footer --%>
    <div class="footer">
        <jsp:include page="include/footer.jsp"/>
    </div>
</body>
</html>
