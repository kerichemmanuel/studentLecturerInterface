package com.tapsileiTechnologies.controller;

import com.tapsileiTechnologies.domain.Department;
import com.tapsileiTechnologies.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    //Requesting a form to register Department
    @RequestMapping(value = "/admin/department_registration_form")
    public String departmentRegistrationForm(Model m) {
        Department cmd = new Department();
        m.addAttribute("command", cmd);
        return "department_registration_form";//JSP form view
    }

    //Department SAVE/EDIT
    @RequestMapping(value = "/admin/save_department")
    public String saveOrUpdateDepartment(@ModelAttribute("command") Department department, Model m,HttpSession session) {
        Integer departmentId = (Integer) session.getAttribute("aDepartmentId");

        if (departmentId == null){     //Update Operation
            try {
                departmentService.save(department);
                return "redirect:departments?act=sv";//redirect user to faculty list url
            } catch (DuplicateKeyException e) {
                e.printStackTrace();
                m.addAttribute("err", "Department With that Code is already registered. Please select another Code.");
                return "department_registration_form";
            }
        }else {
            try {
                department.setDepertmentId(departmentId);
                departmentService.update(department);
                return "redirect:departments?act=ed";//redirect user to faculty list url
            } catch (DuplicateKeyException e) {
                e.printStackTrace();
                m.addAttribute("err", "Could Not Update Department.Department with Such Details Exist");
                return "department_registration_form";
            }

        }
    }


    //Getting all Faculties
    @RequestMapping(value = "/admin/departments")
    public String getDepartmentList(Model m) {
        m.addAttribute("departmentList", departmentService.findDepartments());
        return "departments"; //JSP
    }

    //Search Faculty
    /*@RequestMapping(value = "/admin/faculty_search")
    public String facultySearch(Model m, HttpSession session, @RequestParam("freeText") String freeText,Faculty f) {
        Integer facultyId = (Integer) session.getAttribute("aFacultyId");
        System.out.println(facultyId);
        m.addAttribute("facultyList", facultyService.findFacultyIntensively(facultyId, freeText));
        return "faculties"; //JSP
    }*/

    //Edit Department
    @RequestMapping(value = "/admin/edit_department")
    public String editDepartment(@RequestParam("did") Integer departmentId, Model m,HttpSession session) {
        try {
            session.setAttribute("aDepartmentId", departmentId);
            Department d = departmentService.findById(departmentId);
            m.addAttribute("command",d);
            return "department_registration_form";//Jsp for registering faculty
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("err", "Failed to Edit Department");
            return "department_registration_form";
        }
    }

    //Delete Department
    @RequestMapping(value = "/admin/del_department")
    public String deleteDepartment(@RequestParam("did") Integer departmentId, Model m) {

        try {
            departmentService.delete(departmentId);
            return "redirect:departments?act=del";//redirect user to contact list url
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("err", "Failed to Edit Department");
            return "department_registration_form";
        }
    }

    //Bulk Deletion
    @RequestMapping(value = "/admin/bulk_department_delete")
    public String deleteBulkDepartments(@RequestParam("did") Integer[] departmentIds,Model m,HttpSession session) {
        /*Integer facultyId = (Integer) session.getAttribute("aFacultyId");*/
       try {
           departmentService.delete(departmentIds);
           return "redirect:departments?act=del";//redirect user to contact list url
       }catch (Exception e){
           e.printStackTrace();
           m.addAttribute("err", "Nothing Was Selected To Be Deleted");
           return "redirect:departments";

       }
    }
}
