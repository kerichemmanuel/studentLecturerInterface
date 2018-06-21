package com.tapsileiTechnologies.rm;

import com.tapsileiTechnologies.domain.Faculty;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultyRowMapper implements RowMapper<Faculty> {
    @Override
    public Faculty mapRow(ResultSet rs, int i) throws SQLException {
        Faculty f = new Faculty();
        f.setFacultyId(rs.getInt("facultyId"));
        f.setFacultyCode(rs.getString("facultyCode"));
        f.setFacultyName(rs.getString("facultyName"));
        return f;
    }
}
