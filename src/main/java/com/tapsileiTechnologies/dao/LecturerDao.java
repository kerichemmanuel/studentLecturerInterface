package com.tapsileiTechnologies.dao;

import com.tapsileiTechnologies.domain.Lecturer;

import java.util.List;

public interface LecturerDao {
    public void save(Lecturer l);

    public void update(Lecturer l);

    public void delete(Lecturer l);

    public void delete(Integer lecturerId);

    public Lecturer findById(Integer lecturerId);

    public List<Lecturer> findAll();

    public List<Lecturer> findByProperty(String propName, Object propValue);
}
