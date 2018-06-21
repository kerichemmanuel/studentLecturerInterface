package com.tapsileiTechnologies.service;

import com.tapsileiTechnologies.dao.BaseDAO;
import com.tapsileiTechnologies.dao.FacultyDao;
import com.tapsileiTechnologies.domain.Faculty;
import com.tapsileiTechnologies.rm.FacultyRowMapper;
import com.tapsileiTechnologies.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FacultyServiceImpl extends BaseDAO implements FacultyService{


    @Autowired
    private FacultyDao facultyDao;

    @Override
    public void save(Faculty f) {
        facultyDao.save(f);
    }

    @Override
    public void update(Faculty f) {
        facultyDao.update(f);

    }

    @Override
    public void delete(Integer facultyId) {

        facultyDao.delete(facultyId);
    }

    @Override
    public void delete(Integer[] facultyIds) {
        String ids = StringUtil.toCommaSeparatedString(facultyIds);
        String sql = "DELETE FROM faculty WHERE facultyId IN(" + ids + ")";
        getJdbcTemplate().update(sql);

    }

    @Override
    public Faculty findById(Integer facultyId) {
        return facultyDao.findById(facultyId);
    }

    @Override
    public List<Faculty> findFaculties() {

        return facultyDao.findAll();
    }

    @Override
    public List<Faculty> findFacultyIntensively(Integer facultyId, String txt) {
        System.out.println("findFacultyIntesively = "+facultyId);
        String sql = "SELECT facultyId, facultyCode, facultyName FROM faculty WHERE (facultyCode LIKE '%" + txt + "%' OR facultyName LIKE '%" + txt + "%' )";
        return getJdbcTemplate().query(sql, new FacultyRowMapper(), facultyId);
    }
}
