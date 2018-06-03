package com.tapsileiTechnologies.rm;

import com.tapsileiTechnologies.domain.CourseUnit;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CourseUnitRowMapper implements RowMapper<CourseUnit> {
    @Override
    public CourseUnit mapRow(ResultSet rs, int i) throws SQLException {
        CourseUnit cu = new CourseUnit();

        cu.setUnitId(rs.getInt("unitId"));
        cu.setUnitCode(rs.getString("unitCode"));
        cu.setUnitName(rs.getString("unitName"));
        cu.setUnitFaculty(rs.getString("unitFaculty"));
        cu.setUnitDepertment(rs.getString("unitDepertment"));
        cu.setUnitYearOffered(rs.getString("unitYearOffered"));
        cu.setUnitSemesterOffered(rs.getString("unitSemesterOffered"));
        return cu;
    }
}
