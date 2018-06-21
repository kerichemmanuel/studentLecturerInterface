package com.tapsileiTechnologies.service;

import com.tapsileiTechnologies.domain.Department;

import java.util.List;


public interface DepartmentService {

    public void save(Department dept);

    public void update(Department dept);

    public void delete(Integer deptId);

    /**
     * Bulk delete
     *
     * @param deptIds
     */
    public void delete(Integer[] deptIds);

    public Department findById(Integer deptIds);

    public List<Department> findDepartments();


    /**
     * This method returns all User Contact (user who is logged in).
     *
     * @param deptIds
     * @return
     */
    public List<Department> findDepartment(Integer deptIds);

    /**
     * The method search contact for user(userId) based on given
     * free-text-criteria (txt)
     *
     * @param deptIds User who is logged in
     * @param txt    criteria used to search - free text search criteria
     * @return
     */

    public List<Department> findDepartment(Integer deptIds, String txt);
}
