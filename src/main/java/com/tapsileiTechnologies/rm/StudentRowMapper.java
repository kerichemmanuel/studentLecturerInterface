package com.tapsileiTechnologies.rm;

import com.tapsileiTechnologies.domain.Lecturer;
import com.tapsileiTechnologies.domain.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


    public class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int i) throws SQLException {

            Student s = new Student();

            s.setStudentId(rs.getInt("studentId"));
            s.setRegNo(rs.getString("regNo"));
            s.setFirstName(rs.getString("firstName"));
            s.setLastName(rs.getString("lastName"));
            s.setOtherName(rs.getString("otherName"));
            s.setGender(rs.getString("gender"));
            s.setFaculty(rs.getString("faculty"));
            s.setDepartment(rs.getString("department"));
            s.setYearLevel(rs.getString("yearLevel"));
            s.setPhone(rs.getString("phone"));
            s.setEmail(rs.getString("email"));
            s.setRole(rs.getInt("role"));
            s.setLoginStatus(rs.getInt("loginStatus"));
            return s;
        }
    }

