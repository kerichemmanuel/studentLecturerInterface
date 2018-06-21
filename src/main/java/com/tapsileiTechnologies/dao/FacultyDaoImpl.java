package com.tapsileiTechnologies.dao;

import com.tapsileiTechnologies.domain.Faculty;
import com.tapsileiTechnologies.rm.FacultyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class FacultyDaoImpl extends BaseDAO implements FacultyDao {

    @Override
    public void save(Faculty f) {
        System.out.println("I was called from FacultyController");

        String sql = "INSERT INTO faculty(facultyId, facultyCode, facultyName)" +
                " VALUES(:facultyId, :facultyCode, :facultyName)";
        Map m = new HashMap();
        m.put("facultyId", f.getFacultyId());
        m.put("facultyCode", f.getFacultyCode());
        m.put("facultyName", f.getFacultyName());
        SqlParameterSource ps = new MapSqlParameterSource(m);
        KeyHolder kh = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(sql, ps, kh);
        f.setFacultyId(kh.getKey().intValue());
    }

    @Override
    public void update(Faculty f) {

        String sql = "UPDATE faculty SET facultyCode=:facultyCode, facultyName=:facultyName WHERE facultyId=:facultyId";
        Map m = new HashMap();
        m.put("facultyId", f.getFacultyId());
        m.put("facultyCode", f.getFacultyCode());
        m.put("facultyName", f.getFacultyName());
        getNamedParameterJdbcTemplate().update(sql, m);

    }

    @Override
    public void delete(Faculty f) {
        this.delete(f.getFacultyId());

    }

    @Override
    public void delete(Integer facultyId) {
        String sql = "DELETE FROM faculty WHERE facultyId=?";
        getJdbcTemplate().update(sql, facultyId);

    }

    @Override
    public Faculty findById(Integer facultyId) {
        String sql = "SELECT facultyId, facultyCode, facultyName FROM faculty WHERE facultyId=?";
        return getJdbcTemplate().queryForObject(sql, new FacultyRowMapper(), facultyId);
    }

    @Override
    public List<Faculty> findAll() {
        String sql = "SELECT facultyId, facultyCode, facultyName FROM faculty";
        return getJdbcTemplate().query(sql, new FacultyRowMapper());
    }

    @Override
    public List<Faculty> findByProperty(String propName, Object propValue) {
        String sql = "SELECT facultyId, facultyCode, facultyName FROM faculty WHERE " + propName + "=?";
        return getJdbcTemplate().query(sql, new FacultyRowMapper(), propValue);
    }
}
