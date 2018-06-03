package com.tapsileiTechnologies.dao;

import com.tapsileiTechnologies.domain.CourseUnit;
import com.tapsileiTechnologies.rm.CourseUnitRowMapper;
import com.tapsileiTechnologies.rm.LecturerRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CourseUnitDaoImpl extends BaseDAO implements CourseUnitDao {
    @Override
    public void save(CourseUnit cu) {
        String sql = "INSERT INTO courseunit(unitId, unitCode, unitName, unitFaculty, " +
                "unitDepartment, unitYearOffered,unitSemesterOffered) VALUES(:unitId, :unitCode," +
                " :unitName, :unitFaculty, :unitDepartment, :unitYearOffered,:unitSemesterOffered)";
        Map m = new HashMap();
        m.put("unitId", cu.getUnitId());
        m.put("unitCode", cu.getUnitCode());
        m.put("unitName",cu.getUnitName());
        m.put("unitFaculty", cu.getUnitFaculty());
        m.put("unitDepartment", cu.getUnitDepertment());
        m.put("unitYearOffered", cu.getUnitYearOffered());
        m.put("unitSemesterOffered", cu.getUnitSemesterOffered());
        SqlParameterSource ps = new MapSqlParameterSource(m);
        KeyHolder kh = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(sql, ps, kh);
        cu.setUnitId(kh.getKey().intValue());
    }

    @Override
    public void update(CourseUnit cu) {

        String sql = "UPDATE courseunit SET unitCode=:unitCode, unitName=:unitName, unitFaculty=:unitFaculty," +
                "unitDepartment=:unitDepartment,unitYearOffered=:unitYearOffered," +
                "unitSemesterOffered=:unitSemesterOffered WHERE unitId=:unitId";
        Map m = new HashMap();
        m.put("unitCode", cu.getUnitCode());
        m.put("unitName",cu.getUnitName());
        m.put("unitFaculty", cu.getUnitFaculty());
        m.put("unitDepartment", cu.getUnitDepertment());
        m.put("unitYearOffered", cu.getUnitYearOffered());
        m.put("unitSemesterOffered", cu.getUnitSemesterOffered());
        getNamedParameterJdbcTemplate().update(sql, m);

    }

    @Override
    public void delete(CourseUnit cu) {
                   this.delete(cu.getUnitId());
    }

    @Override
    public void delete(Integer unitId) {
        String sql = "DELETE FROM courseunit WHERE unitId=?";
        getJdbcTemplate().update(sql, unitId);

    }

    @Override
    public CourseUnit findById(Integer unitId) {
        String sql = "SELECT unitId, unitCode, unitName, unitFaculty, unitDepartment, unitYearOffered, " +
                "unitSemesterOffered FROM courseunit WHERE unitId=?";
        return getJdbcTemplate().queryForObject(sql, new CourseUnitRowMapper(), unitId);
    }

    @Override
    public List<CourseUnit> findAll() {
        String sql = "SELECT unitId, unitCode, unitName, unitFaculty, unitDepartment, unitYearOffered," +
                "unitSemesterOffered FROM courseunit";
        return getJdbcTemplate().query(sql, new CourseUnitRowMapper());
    }

    @Override
    public List<CourseUnit> findByProperty(String propName, Object propValue) {
        String sql = "SELECT unitId, unitCode, unitName, unitFaculty, unitDepartment, unitYearOffered,\" +\n" +
                "                \"unitSemesterOffered FROM courseunit WHERE " + propName + "=?";
        return getJdbcTemplate().query(sql, new CourseUnitRowMapper(), propValue);
    }
}
