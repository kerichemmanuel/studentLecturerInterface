package com.tapsileiTechnologies.dao;


import com.tapsileiTechnologies.domain.Department;

import java.util.List;

public interface DepartmentDao {

    public void save(Department d);

    public void update(Department d);

    public void delete(Department d);

    public void delete(Integer departmentId);

    public Department findById(Integer departmentId);

    public List<Department> findAll();

    public List<Department> findByProperty(String propName, Object propValue);
}
