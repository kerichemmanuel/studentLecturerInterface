package com.tapsileiTechnologies.service;

import com.tapsileiTechnologies.domain.Contact;
import com.tapsileiTechnologies.domain.Faculty;

import java.util.List;

public interface FacultyService {

    public void save(Faculty f);

    public void update(Faculty f);

    public void delete(Integer facultyId);

    /**
     * Bulk delete
     *
     * @param facultyIds
     * */
    public void delete(Integer[] facultyIds);

    public Faculty findById(Integer facultyId);

    /**
     * This method returns Faculty (To Admins only).
     *
     * @param
     * @return
     */
    public List<Faculty> findFaculties();

    /**
     * The method search faculty for faculty(facultyId) based on given
     * free-text-criteria (txt)
     *
     * @param facultyId User who is logged in
     * @param txt    criteria used to search - free text search criteria
     * @return
     */
    public List<Faculty> findFacultyIntensively(Integer facultyId, String txt);
}
