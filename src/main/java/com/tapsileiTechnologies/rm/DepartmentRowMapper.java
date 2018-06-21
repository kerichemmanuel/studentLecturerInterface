package com.tapsileiTechnologies.rm;

import com.tapsileiTechnologies.domain.Department;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


    public class DepartmentRowMapper implements RowMapper<Department> {
        @Override
        public Department mapRow(ResultSet rs, int i) throws SQLException {
            Department d = new Department();
            d.setDepertmentId(rs.getInt("departmentId"));
           d.setFacultyId(rs.getInt("facultyId"));
            d.setDepartmentCode(rs.getString("departmentCode"));
            d.setDepartmentName(rs.getString("departmentName"));

            return d;
        }
}
