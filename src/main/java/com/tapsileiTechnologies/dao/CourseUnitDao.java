package com.tapsileiTechnologies.dao;

import com.tapsileiTechnologies.domain.CourseUnit;

import java.util.List;

public interface CourseUnitDao {
    public void save(CourseUnit cu);

    public void update(CourseUnit cu);

    public void delete(CourseUnit cu);

    public void delete(Integer unitId);

    public CourseUnit findById(Integer unitId);

    public List<CourseUnit> findAll();

    public List<CourseUnit> findByProperty(String propName, Object propValue);
}
