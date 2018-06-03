package com.tapsileiTechnologies.service;

import com.tapsileiTechnologies.domain.CourseUnit;

import java.util.List;

public interface CourseUnitService {

    public void save(CourseUnit cunt);

    public void update(CourseUnit cunt);

    public void delete(Integer cuntId);

    /**
     * Bulk delete
     *
     * @param cuntIds
     */
    public void delete(Integer[] cuntIds);

    public CourseUnit findById(Integer cuntId);

    /**
     * This method returns all User Contact (user who is logged in).
     *
     * @param cuntId
     * @return
     */
    public List<CourseUnit> findCourseUnit(Integer cuntId);

    /**
     * The method search contact for user(userId) based on given
     * free-text-criteria (txt)
     *
     * @param cuntId User who is logged in
     * @param txt    criteria used to search - free text search criteria
     * @return
     */
    public List<CourseUnit> findCourseUnit(Integer cuntId, String txt);
}
