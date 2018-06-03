package com.tapsileiTechnologies.service;

import com.tapsileiTechnologies.dao.BaseDAO;
import com.tapsileiTechnologies.dao.CourseUnitDao;
import com.tapsileiTechnologies.domain.CourseUnit;
import com.tapsileiTechnologies.rm.CourseUnitRowMapper;
import com.tapsileiTechnologies.rm.DepartmentRowMapper;
import com.tapsileiTechnologies.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseunitServiceImpl extends BaseDAO implements CourseUnitService {

   @Autowired
    private CourseUnitDao courseUnitDao;


    @Override
    public void save(CourseUnit cunt) {
        courseUnitDao.save(cunt);
    }

    @Override
    public void update(CourseUnit cunt) {
        courseUnitDao.update(cunt);

    }

    @Override
    public void delete(Integer cuntId) {
        courseUnitDao.delete(cuntId);

    }

    @Override
    public void delete(Integer[] cuntIds) {
        String ids = StringUtil.toCommaSeparatedString(cuntIds);
        String sql = "DELETE FROM courseunit WHERE unitId IN(" + ids + ")";
        getJdbcTemplate().update(sql);

    }

    @Override
    public CourseUnit findById(Integer cuntId) {

     return courseUnitDao.findById(cuntId);
    }

    @Override
    public List<CourseUnit> findCourseUnit(Integer cuntId) {
        return courseUnitDao.findByProperty("cuntId",cuntId);
    }

    @Override
    public List<CourseUnit> findCourseUnit(Integer cuntId, String txt) {
        String sql = "SELECT unitId,unitCode, unitName, unitFaculty, unitDepartment, unitYearOffered,\" +\n" +
                "                \"unitSemesterOffered FROM courseunit WHERE unitId=? AND " +
                "(unitCode LIKE '%" + txt + "%' OR unitName LIKE '%" + txt + "%' OR unitFaculty LIKE '%" + txt + "%'" +
                "OR unitDepartment LIKE '%\" + txt + \"%' OR unitYearOffered LIKE '%\" + txt + \"%' " +
                "OR unitSemesterOffered LIKE '%\" + txt + \"%')";
        return getJdbcTemplate().query(sql, new CourseUnitRowMapper(), cuntId);
    }
}
