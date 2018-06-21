<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>

<s:url var="url_css" value="/static/bootstrap-dist/css/bootstrap.css"/>
<link href="${url_css}" rel="stylesheet" type="text/css"/>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<s:url var="url_logout" value="/logout"/>
<%--Home dashboard Menu--%>
<c:if test="${sessionScope.userId==null && sessionScope.lecturerId==null && sessionScope.studentId==null}">
    <%-- User is not yet logged in : Guest Menu --%>
    <s:url var="url_reg_form" value="/student_registration_form"/>
    <s:url var="url_index" value="/index"/>

    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="${url_admin_home}">StudentLecturerInterface</a>
            </div>
            <ul class="nav navbar-nav">
               <%-- <li><a href="${url_reg_form}">Register</a></li>--%>
                <li><a href="#">About</a></li>
                <li><a href="#">Help</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${url_reg_form}"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a href="${url_index}"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul>
        </div>
    </nav>

</c:if>


<%--Admin dashboard Menu--%>
<c:if test="${sessionScope.userId!=null && sessionScope.role == 1}">
    <%-- Admin is logged in : Admin Menu --%>
    <s:url var="url_admin_home" value="/admin/dashboard"/>
    <s:url var="url_admin_user_list" value="/admin/users"/>
    <s:url var="url_admin_student_reg_form" value="/admin_student_registration_form"/>
    <s:url var="url_admin_student_list" value="/admin/students"/>
    <s:url var="url_admin_lecturer_reg_form" value="/lecturer_registration_form"/>
    <s:url var="url_admin_lecturer_list" value="/admin/lecturers"/>
    <s:url var="url_admin_faculty_reg_form" value="/admin/faculty_registration_form"/>
    <s:url var="url_admin_faculty_list_form" value="/admin/faculties"/>
    <s:url var="url_admin_department_reg_form" value="/admin/department_registration_form"/>
    <s:url var="url_admin_department_list_form" value="/admin/departments"/>


    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="${url_admin_home}">StudentLecturerInterface</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Administrator
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Add Administrator</a></li>
                        <li><a href="${url_admin_user_list}">User List</a></li>
                        <li><a href="#">JavaScript</a></li>
                    </ul>
                </li>
            </ul>

            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Lecturer
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${url_admin_lecturer_reg_form}">Add Lecturer</a></li>
                        <li><a href="${url_admin_lecturer_list}">Lecturer List</a></li>
                        <li><a href="#">JavaScript</a></li>
                    </ul>
                </li>
            </ul>

            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Student
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${url_admin_student_reg_form}">Add Student</a></li>
                        <li><a href="${url_admin_student_list}">Student List</a></li>
                        <li><a href="#">JavaScript</a></li>
                    </ul>
                </li>
            </ul>

            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Faculty
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${url_admin_faculty_reg_form}">Add Faculty</a></li>
                        <li><a href="${url_admin_faculty_list_form}">Faculty List</a></li>
                        <li><a href="#">JavaScript</a></li>
                    </ul>
                </li>
            </ul>

            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Department
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${url_admin_department_reg_form}">Add Department</a></li>
                        <li><a href="${url_admin_department_list_form}">Department List</a></li>
                        <li><a href="#">JavaScript</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${url_logout}"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
            </ul>
        </div>
    </nav>


</c:if>

<%--Lecturer dashboard Menu--%>
<c:if test="${sessionScope.lecturerId!=null && sessionScope.role == 3}">
    <%-- Lecturer is logged in : Lecturer Menu --%>
    <s:url var="url_lecturer_home" value="/lecturer/dashboard"/>
    <a href="${url_lecturer_home}">Home</a> |
    <a href="${url_logout}">Logout</a>
</c:if>

<%--Student dashboard Menu--%>
<c:if test="${sessionScope.studentId!=null && sessionScope.role == 4}">
    <%-- Student is logged in : Student Menu --%>
    <s:url var="url_student_home_page" value="/student/dashboard"/>
    <a href="${url_student_home_page}">Home</a> |
    <a href="${url_logout}">Logout</a>
</c:if>




