package com.tapsileiTechnologies.controller;

import com.tapsileiTechnologies.command.LoginCommand;
import com.tapsileiTechnologies.command.UserCommand;
import com.tapsileiTechnologies.domain.Lecturer;
import com.tapsileiTechnologies.domain.Student;
import com.tapsileiTechnologies.domain.User;
import com.tapsileiTechnologies.exception.UserBlockedException;
import com.tapsileiTechnologies.service.LecturerService;
import com.tapsileiTechnologies.service.StudentService;
import com.tapsileiTechnologies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LecturerService lecturerService;

    @Autowired
    private StudentService studentService;

    private User loggedInAdmin;
    private Lecturer loggedInLecturer;
    private Student loggedInStudent;

    @RequestMapping(value = {"/", "/index"})
    public String index(Model m) {
        m.addAttribute("command", new LoginCommand());
        return "index"; //JSP - /WEB-INF/view/index.jsp
    }

     @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session) {

        try {
            if ((loggedInAdmin = userService.login(cmd.getLoginName(), cmd.getPassword())) != null){
                //add user detail in session (assign session to logged in user)
                System.out.println("Successfully Verified Administrator LogIn");
                addAdminInSession(loggedInAdmin,session);
                return "redirect:/admin/dashboard";
            }else if((loggedInLecturer = lecturerService.login(cmd.getLoginName(), cmd.getPassword())) != null){
                //add user detail in session (assign session to logged in user)
                System.out.println("Successfully Verified Lecturer LogIn");
                addLecturerInSession(loggedInLecturer,session);
                return "redirect:/lecturer/dashboard";
            }else if((loggedInStudent = studentService.login(cmd.getLoginName(), cmd.getPassword())) != null){
                //add user detail in session (assign session to logged in user)
                System.out.println("Successfully verified Student LogIn");
                addStudentInSession(loggedInStudent,session);
                return "redirect:/student/dashboard";
            }else {
                //FAILED
                //add error message and go back to login-form
                m.addAttribute("err", "Login Failed! Enter valid credentials.");
                System.out.println("Nothing was entered");
                return "index";//JSP - Login FORM
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

    @RequestMapping(value = "/admin/dashboard")
    public String adminDashboard() {
        return "dashboard_admin"; //JSP
    }


    @RequestMapping(value = "/lecturer/dashboard")
    public String lecturerDashboard() {
        return "dashboard_lecturer"; //JSP
    }

    @RequestMapping(value = "/student/dashboard")
    public String studentDashboard() {
        return "dashboard_student"; //JSP
    }


    //Getting all users
    @RequestMapping(value = "/admin/users")
    public String getUserList(Model m) {
        m.addAttribute("userList", userService.getUserList());
        return "users"; //JSP
    }

    //Getting all Students
    @RequestMapping(value = "/admin/students")
    public String getStudentList(Model m) {
        m.addAttribute("studentList", studentService.getStudentList());
        return "students"; //JSP
    }
    //Getting all Lecturers
    @RequestMapping(value = "/admin/lecturers")
    public String getLecturerList(Model m) {
        m.addAttribute("lecturerList", lecturerService.getLecturerList());
        return "lecturers"; //JSP
    }


 //Requesting a student form to fill details
    @RequestMapping(value = "/student_registration_form")
    public String studentRegistrationForm(Model m) {
        System.out.println("/student_registration_form");
        Student cmd = new Student();
        m.addAttribute("command", cmd);
        return "student_registration_form";//JSP
    }

    //Requesting a student form to fill details from Admin Panel
    @RequestMapping(value = "/admin_student_registration_form")
    public String studentRegistrationFormAdmin(Model m) {
        System.out.println("/admin_student_registration_form");
        Student cmd = new Student();
        m.addAttribute("command", cmd);
        return "admin_student_registration_form";//JSP
    }

    //Requesting a Lecturer form to fill details
    @RequestMapping(value = "/lecturer_registration_form")
    public String lecturerRegistrationForm(Model m) {
        Lecturer cmd = new Lecturer();
        m.addAttribute("command", cmd);
        return "lecturer_registration_form";//JSP
    }

    //Administrator Registration
    @RequestMapping(value = "/register")
    public String registerUser(@ModelAttribute("command") UserCommand cmd, Model m) {
        try {
            User user = cmd.getUser();
            user.setRole(UserService.ROLE_ADMIN);
            user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
            userService.register(user);
            return "redirect:index?act=reg"; //Login Page
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            m.addAttribute("err", "Username is already registered. Please select another username.");
            return "reg_form";//JSP
        }
    }

    //Student Registration
    @RequestMapping(value = "/registerStudent")
    public String registerStudent(@Valid @ModelAttribute("command") Student student, BindingResult result, Model m) {

        if (result.hasErrors()){
            return "student_registration_form";//JSP
        }else {
            try {
                student.setRole(StudentService.ROLE_STUDENT);
                student.setLoginStatus(StudentService.LOGIN_STATUS_ACTIVE);
                System.out.println("Was called to register Student");
                studentService.register(student);
                return "redirect:index?act=reg"; //Login Page
            } catch (DuplicateKeyException e) {
                e.printStackTrace();
                m.addAttribute("err", "Student is already registered. Please select another RegNo.");
                return "student_registration_form";//JSP
            }
        }
    }
   /* //Student Registration from Admin Panel
    @RequestMapping(value = "/admin/registerStudent")
    public String adminRegisterStudent(@Valid @ModelAttribute("command") Student student, BindingResult result, Model m) {

        if (result.hasErrors()){
            return "student_registration_form";//JSP
        }else {
            try {
                student.setRole(StudentService.ROLE_STUDENT);
                student.setLoginStatus(StudentService.LOGIN_STATUS_ACTIVE);
                System.out.println("Was called to register Student");
                studentService.register(student);
                return "redirect:/admin/students?act=regStud"; //Login Page
            } catch (DuplicateKeyException e) {
                e.printStackTrace();
                m.addAttribute("err", "Student is already registered. Please select another RegNo.");
                return "student_registration_form";//JSP
            }
        }
    }*/

    //Student SAVE/EDIT from Admin Panel
    @RequestMapping(value = "/admin/registerStudent")
    public String saveOrUpdateStudent(@Valid @ModelAttribute("command") Student student, BindingResult result, Model m, HttpSession session) {

        if (result.hasErrors()){  //Validation Operation
            return "admin_student_registration_form";//JSP
        }else {
            Integer studentId = (Integer) session.getAttribute("aStudentId");
            System.out.println(studentId);
            if (studentId == null) {     //Save Operation
                try {
                    studentService.register(student);
                    return "redirect:students?act=sv";//redirect user to faculty list url
                } catch (DuplicateKeyException e) {
                    e.printStackTrace();
                    m.addAttribute("err", "This Student is already registered...");
                    return "admin_student_registration_form";
                }
            } else {  //Update Operation
                try {
                    student.setStudentId(studentId);
                    studentService.update(student);
                    return "redirect:students?act=ed";//redirect user to faculty list url
                } catch (DuplicateKeyException e) {
                    e.printStackTrace();
                    m.addAttribute("err", "Could Not Update Student.Such Student Already Exist With Us");
                    return "admin_student_registration_form";
                }

            }
        }
    }

    //Edit Student
    @RequestMapping(value = "/admin/edit_student")
    public String editFaculty(@RequestParam("sid") Integer studentId, Model m,HttpSession session) {
        try {
            session.setAttribute("aStudentId", studentId);
            Student s = studentService.findById(studentId);
            m.addAttribute("command",s);
            return "admin_student_registration_form";//Jsp
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("err", "Failed to Edit contact");
            return "admin_student_registration_form";
        }
    }
    //Delete Student
    @RequestMapping(value = "/admin/del_student")
    public String deleteStudent(@RequestParam("sid") Integer studentId, Model m) {

        try {
            studentService.delete(studentId);
            return "redirect:students?act=del";//redirect user to contact list url
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("err", "Failed to Delete Student");
            return "admin_student_registration_form";
        }
    }

   /* //Bulk Deletion
    @RequestMapping(value = "/admin/bulk_student_delete")
    public String deleteBulkStudents(@RequestParam("fid") Integer[] studentIds,Model m,HttpSession session) {
        *//*Integer facultyId = (Integer) session.getAttribute("aFacultyId");*//*
        try {
            facultyService.delete(facultyIds);
            return "redirect:faculties?act=del";//redirect user to contact list url
        }catch (Exception e){
            e.printStackTrace();
            m.addAttribute("err", "Nothing Was Selected To Be Deleted");
            return "redirect:faculties";

        }
    }*/

    //Lecturer Registration
    @RequestMapping(value = "/registerLecturer")
    public String registerLecturer(@Valid @ModelAttribute("command") Lecturer lecturer,BindingResult result, Model m) {

        if (result.hasErrors()){
            return "lecturer_registration_form";//JSP

        }else {
            try {
                lecturer.setRole(LecturerService.ROLE_LECTURER);
                lecturer.setLoginStatus(LecturerService.LOGIN_STATUS_ACTIVE);
                System.out.println("registerLecturer method Was called to register Lecturer");
                lecturerService.register(lecturer);
                return "redirect:/admin/lecturers?act=lectReg"; //Lecturers Page
            } catch (DuplicateKeyException e) {
                e.printStackTrace();
                m.addAttribute("err", "Lecturer is already registered. Please select another StaffNo.");
                return "lecturer_registration_form";//JSP
            }
        }
    }

    private void addAdminInSession(User u, HttpSession session) {
        session.setAttribute("user", u);
        session.setAttribute("userId", u.getUserId());
        session.setAttribute("role", u.getRole());
    }

    //Adding Lecturer object,id and role in session
    private void addLecturerInSession(Lecturer l, HttpSession session) {
        session.setAttribute("lecturer", l);
        session.setAttribute("lecturerId", l.getLecturerId());
        session.setAttribute("role", l.getRole());
    }

    //Adding Student object,id and role in session
    private void addStudentInSession(Student s, HttpSession session) {
        session.setAttribute("student", s);
        session.setAttribute("studentId", s.getStudentId());
        session.setAttribute("role", s.getRole());
    }

    //Blocking or Unblocking Admins..
    @RequestMapping(value = "/admin/change_status")
    @ResponseBody
    public String changeLoginStatus(@RequestParam Integer userId, @RequestParam Integer loginStatus) {
        try {
            userService.changeLoginStatus(userId, loginStatus);
            return "SUCCESS: User Status Changed";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: Unable to Change User Status";
        }
    }
    //Blocking or Unblocking Students..
    @RequestMapping(value = "/admin/change_student_status")
    @ResponseBody
    public String changeStudentLoginStatus(@RequestParam Integer studentId, @RequestParam Integer loginStatus) {
        try {
            studentService.changeLoginStatus(studentId, loginStatus);
            return "SUCCESS: Status Changed successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: Unable to Change Student Status";
        }
    }
    //Blocking or Unblocking Lecturers..
    @RequestMapping(value = "/admin/change_lecturer_status")
    @ResponseBody
    public String changeLecturerLoginStatus(@RequestParam Integer lecturerId, @RequestParam Integer loginStatus) {
        try {
            lecturerService.changeLoginStatus(lecturerId, loginStatus);
            return "SUCCESS: Status Changed successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: Unable to Change Lecturer Status";
        }
    }


    //Checking Administrator Availability in the system
    @RequestMapping(value = "/check_avail")
    @ResponseBody
    public String checkAvailability(@RequestParam String username) {
        if (userService.isUsernameExist(username)) {
            return "This username is already taken. Choose another name";
        } else {
            return "Yes! You can take this";
        }
    }

    //Checking Student Availability in the system
    @RequestMapping(value = "/check_student_avail")
    @ResponseBody
    public String checkStudentAvailability(@RequestParam String regNo) {
        if (studentService.isStudentRegNoExist(regNo)) {
            return "This regNo is already taken. Choose another regNo";
        } else {
            return "Yes! You can take this";
        }
    }

    //Checking Lecturer Availability in the system
    @RequestMapping(value = "check_lecturer_avail")
    @ResponseBody
    public String checkLecturerAvailability(@RequestParam String staffNo) {
        if (lecturerService.isLecturerStaffNoExist(staffNo)) {
            return "This staffNo is already taken. Choose another staffNo";
        } else {
            return "Yes! You can take this";
        }
    }

}
