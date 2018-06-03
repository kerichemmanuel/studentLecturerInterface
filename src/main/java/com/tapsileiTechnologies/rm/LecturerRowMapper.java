package com.tapsileiTechnologies.rm;

import com.tapsileiTechnologies.domain.Lecturer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

    public class LecturerRowMapper implements RowMapper<Lecturer> {
        @Override
        public Lecturer mapRow(ResultSet rs, int i) throws SQLException {
            Lecturer l = new Lecturer();

            l.setLecturerId(rs.getInt("lecturerId"));
            l.setStaffNo(rs.getString("staffNo"));
            l.setLecFName(rs.getString("lecFName"));
            l.setLecLName(rs.getString("lecLName"));
            l.setLecOName(rs.getString("lecOName"));
            l.setGender(rs.getString("gender"));
            l.setFaculty(rs.getString("faculty"));
            l.setDepartment(rs.getString("department"));
            l.setCitation(rs.getString("citation"));
            l.setSpecialization(rs.getString("specialization"));
            l.setPhone(rs.getString("phone"));
            l.setEmail(rs.getString("email"));
            l.setRole(rs.getInt("role"));
            l.setLoginStatus(rs.getInt("loginStatus"));
            return l;
        }
}
