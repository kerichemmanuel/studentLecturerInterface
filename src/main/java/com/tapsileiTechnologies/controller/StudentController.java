package com.tapsileiTechnologies.controller;

import com.tapsileiTechnologies.command.LoginCommand;
import com.tapsileiTechnologies.command.StudentCommand;
import com.tapsileiTechnologies.domain.Student;
import com.tapsileiTechnologies.exception.UserBlockedException;
import com.tapsileiTechnologies.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = {"/", "/index"})
    public String index(Model m) {
        m.addAttribute("command", new LoginCommand());
        return "index"; //JSP - /WEB-INF/view/index.jsp
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session) {
        try {
            Student loggedInStudent = studentService.login(cmd.getLoginName(), cmd.getPassword());
            if (loggedInStudent == null) {
                //FAILED
                //add error message and go back to login-form
                m.addAttribute("err", "Login Failed! Enter valid credentials.");
                return "index";//JSP - Login FORM
            } else //SUCCESS
            //check the role and redirect to a appropriate dashboard
            {
                if (loggedInStudent.getRole().equals(StudentService.ROLE_ADMIN)) {
                    //add student detail in session (assign session to logged in user)
                    addStudentInSession(loggedInStudent, session);
                    return "redirect:admin/dashboard";
                } else if (loggedInStudent.getRole().equals(StudentService.ROLE_STUDENT)) {
                    //add user detail in session (assign session to logged in user)
                    addStudentInSession(loggedInStudent, session);
                    return "redirect:student/dashboard";
                } else {
                    //add error message and go back to login-form
                    m.addAttribute("err", "Invalid User ROLE");
                    return "index";//JSP - Login FORM
                }
            }
        } catch (UserBlockedException ex) {
            //add error message and go back to login-form
            m.addAttribute("err", ex.getMessage());
            return "index";//JSP - Login FORM
        }
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:index?act=lo";
    }

    @RequestMapping(value = "/student/dashboard")
    public String studentDashboard() {
        return "dashboard_student"; //JSP
    }

    @RequestMapping(value = "/admin/dashboard")
    public String adminDashboard() {
        return "dashboard_admin"; //JSP
    }

    @RequestMapping(value = "/admin/students")
    public String getStudentList(Model m) {
        m.addAttribute("studentList", studentService.getStudentList());
        return "students"; //JSP
    }

    @RequestMapping(value = "/studentregistration_form")
    public String registrationForm(Model m) {
        StudentCommand cmd = new StudentCommand();
        m.addAttribute("command", cmd);
        return "studentregistration_form";//JSP
    }

    @RequestMapping(value = "/register")
    public String registerUser(@ModelAttribute("command") StudentCommand cmd, Model m) {
        try {
            Student student = cmd.getStudent();
            student.setRole(StudentService.ROLE_STUDENT);
            student.setLoginStatus(StudentService.LOGIN_STATUS_ACTIVE);
            studentService.register(student);
            return "redirect:index?act=reg"; //Login Page
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            m.addAttribute("err", "Registration Number is already registered. Please select another RegNo.");
            return "studentregistration_form";//JSP
        }
    }

    private void addStudentInSession(Student s, HttpSession session) {
        session.setAttribute("student", s);
        session.setAttribute("studentId", s.getStudentId());
        session.setAttribute("role", s.getRole());
    }

    @RequestMapping(value = "/admin/change_status")
    @ResponseBody
    public String changeLoginStatus(@RequestParam Integer studentId, @RequestParam Integer loginStatus) {
        try {
            studentService.changeLoginStatus(studentId, loginStatus);
            return "SUCCESS: Status Changed successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: Unable to Change Status";
        }
    }

    @RequestMapping(value = "/check_avail")
    @ResponseBody
    public String checkAvailability(@RequestParam String regNo) {
        if (studentService.isStudentRegNoExist(regNo)) {
            return "This Registration Number is already taken. Choose another RegNo";
        } else {
            return "Yes! You can take this";
        }
    }

}
