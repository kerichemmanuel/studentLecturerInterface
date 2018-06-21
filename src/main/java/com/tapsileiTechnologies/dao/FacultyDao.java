package com.tapsileiTechnologies.dao;
import com.tapsileiTechnologies.domain.Faculty;

import java.util.List;

public interface FacultyDao {
    public void save(Faculty f);

    public void update(Faculty f);

    public void delete(Faculty f);

    public void delete(Integer facultyId);

    public Faculty findById(Integer facultyId);

    public List<Faculty> findAll();

    public List<Faculty> findByProperty(String propName, Object propValue);
}
