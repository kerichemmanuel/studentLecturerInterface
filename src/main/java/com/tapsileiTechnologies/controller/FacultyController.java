package com.tapsileiTechnologies.controller;

import com.tapsileiTechnologies.domain.Faculty;
import com.tapsileiTechnologies.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    //Requesting a form to register faculty
    @RequestMapping(value = "/admin/faculty_registration_form")
    public String facultyRegistrationForm(Model m) {
        Faculty cmd = new Faculty();
        m.addAttribute("command", cmd);
        return "faculty_registration_form";//JSP form view
    }

    //Faculty SAVE/EDIT
    @RequestMapping(value = "/admin/save_faculty")
    public String saveOrUpdateFaculty(@Valid @ModelAttribute("command") Faculty faculty, BindingResult result, Model m, HttpSession session) {

        if (result.hasErrors()){  //Validation Operation
            return "faculty_registration_form";
        }else {
            Integer facultyId = (Integer) session.getAttribute("aFacultyId");
            System.out.println(facultyId);
            if (facultyId == null) {     //Save Operation
                try {
                    facultyService.save(faculty);
                    return "redirect:faculties?act=sv";//redirect user to faculty list url
                } catch (DuplicateKeyException e) {
                    e.printStackTrace();
                    m.addAttribute("err", "Faculty With that Code is already registered. Please select another Code.");
                    return "faculty_registration_form";
                }
            } else {  //Update Operation
                try {
                    faculty.setFacultyId(facultyId);
                    facultyService.update(faculty);
                    return "redirect:faculties?act=ed";//redirect user to faculty list url
                } catch (DuplicateKeyException e) {
                    e.printStackTrace();
                    m.addAttribute("err", "Could Not Update Faculty.Faculty with Such Details Exist");
                    return "faculty_registration_form";
                }

            }
        }
    }


    //Getting all Faculties
    @RequestMapping(value = "/admin/faculties")
    public String getFacultyList(Model m) {
        m.addAttribute("facultyList", facultyService.findFaculties());
        return "faculties"; //JSP
    }

    //Search Faculty
  /*  @RequestMapping(value = "/admin/faculty_search")
    public String facultySearch(Model m, HttpSession session, @RequestParam("freeText") String freeText,Faculty f) {
      *//*  Integer facultyId = (Integer) session.getAttribute("aFacultyId");*//*
        System.out.println(facultyId);
        m.addAttribute("facultyList", facultyService.findFacultyIntensively(facultyId, freeText));
        return "faculties"; //JSP
    }*/

    //Edit Faculty
    @RequestMapping(value = "/admin/edit_faculty")
    public String editFaculty(@RequestParam("fid") Integer facultyId, Model m,HttpSession session) {
        try {
            session.setAttribute("aFacultyId", facultyId);
            Faculty f = facultyService.findById(facultyId);
            m.addAttribute("command",f);
            return "faculty_registration_form";//Jsp for registering faculty
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("err", "Failed to Edit contact");
            return "faculty_registration_form";
        }
    }

    //Delete Faculty
    @RequestMapping(value = "/admin/del_faculty")
    public String deleteFaculty(@RequestParam("fid") Integer facultyId, Model m) {

        try {
            facultyService.delete(facultyId);
            return "redirect:faculties?act=del";//redirect user to contact list url
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("err", "Failed to Edit contact");
            return "faculty_registration_form";
        }
    }

    //Bulk Deletion
    @RequestMapping(value = "/admin/bulk_faculty_delete")
    public String deleteBulkFaculties(@RequestParam("fid") Integer[] facultyIds,Model m,HttpSession session) {
        /*Integer facultyId = (Integer) session.getAttribute("aFacultyId");*/
       try {
           facultyService.delete(facultyIds);
           return "redirect:faculties?act=del";//redirect user to contact list url
       }catch (Exception e){
           e.printStackTrace();
           m.addAttribute("err", "Nothing Was Selected To Be Deleted");
           return "redirect:faculties";

       }
    }
}
