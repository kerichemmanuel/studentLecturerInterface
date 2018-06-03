package com.tapsileiTechnologies.dao;

import com.tapsileiTechnologies.domain.Department;
import com.tapsileiTechnologies.rm.DepartmentRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DepartmentDaoImpl extends BaseDAO implements DepartmentDao {
    @Override
    public void save(Department d) {
        String sql = "INSERT INTO department(departmentId, departmentCode, facultyName, departmentName) " +
                "VALUES(:departmentId, :departmentCode, :facultyName, :departmentName)";
        Map m = new HashMap();
        m.put("departmentId", d.getDepertmentId());
        m.put("departmentCode",d.getDepertmentCode());
        m.put("facultyName",d.getDepertmentName());
        m.put("departmentName", d.getDepertmentName());

        SqlParameterSource ps = new MapSqlParameterSource(m);
        KeyHolder kh = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(sql, ps, kh);
        d.setDepertmentId(kh.getKey().intValue());
    }

    @Override
    public void update(Department d) {

        String sql = "UPDATE courseunit SET departmentCode=:departmentCode, facultyName=:facultyName, departmentName=:departmentName WHERE unitId=:unitId";
        Map m = new HashMap();
        m.put("departmentCode",d.getDepertmentCode());
        m.put("facultyName",d.getDepertmentName());
        m.put("departmentName", d.getDepertmentName());
        getNamedParameterJdbcTemplate().update(sql, m);
    }

    @Override
    public void delete(Department d) {
 this.delete(d.getDepertmentId());
    }

    @Override
    public void delete(Integer departmentId) {

        String sql = "DELETE FROM department WHERE departmentId=?";
        getJdbcTemplate().update(sql, departmentId);
    }

    @Override
    public Department findById(Integer departmentId) {
        String sql = "SELECT departmentId, departmentCode, departmentName FROM department WHERE departmentId=?";
        return getJdbcTemplate().queryForObject(sql, new DepartmentRowMapper(), departmentId);
    }

    @Override
    public List<Department> findAll() {
        String sql = "SELECT departmentId, departmentCode, departmentName FROM department";
        return getJdbcTemplate().query(sql, new DepartmentRowMapper());
    }

    @Override
    public List<Department> findByProperty(String propName, Object propValue) {
        String sql = "SELECT departmentId, departmentCode, departmentName FROM department WHERE " + propName + "=?";
        return getJdbcTemplate().query(sql, new DepartmentRowMapper(), propValue);
    }
}
