package com.tapsileiTechnologies.dao;


import com.tapsileiTechnologies.domain.Student;

import java.util.List;

public interface StudentDao {

    public void save(Student s);

    public void update(Student s);

    public void delete(Student s);

    public void delete(Integer studentId);

    public Student findById(Integer studentId);

    public List<Student> findAll();

    public List<Student> findByProperty(String propName, Object propValue);
}
