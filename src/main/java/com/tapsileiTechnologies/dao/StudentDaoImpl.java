package com.tapsileiTechnologies.dao;

import com.tapsileiTechnologies.domain.Student;
import com.tapsileiTechnologies.rm.StudentRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentDaoImpl extends BaseDAO implements StudentDao {


    @Override
    public void save(Student s) {

        String sql = "INSERT INTO student(regNo, firstName,lastName,otherName,gender,faculty," +
                "department,email,phone,yearLevel,role,password,loginStatus) " +
                "VALUES(:regNo, :firstName, :lastName,:otherName,:gender,:faculty," +
                ":department,:email,:phone,:yearLevel,:role,:password,:loginStatus)";
        Map m = new HashMap();
        m.put("regNo",s.getRegNo());
        m.put("firstName",s.getFirstName());
        m.put("lastName", s.getLastName());
        m.put("otherName", s.getOtherName());
        m.put("gender", s.getGender());
        m.put("faculty", s.getFaculty());
        m.put("department", s.getDepartment());
        m.put("email", s.getEmail());
        m.put("phone", s.getPhone());
        m.put("yearLevel", s.getYearLevel());
        m.put("role", s.getRole());
        m.put("password", s.getPassword());
        m.put("loginStatus", s.getLoginStatus());

        SqlParameterSource ps = new MapSqlParameterSource(m);
        KeyHolder kh = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(sql, ps, kh);
        s.setStudentId(kh.getKey().intValue());
    }

    @Override
    public void update(Student s) {


        String sql = "UPDATE student SET " +
                "regNo=:regNo, " +
                "firstName=:firstName, " +
                "lastName=:lastName," +
                "otherName=:otherName," +
                "gender=:gender," +
                "faculty=:faculty," +
                "department=:department, " +
                "email=:email," +
                "phone=:phone," +
                "yearLevel=:yearLevel," +
               /* "loginStatus=:loginStatus," +*/
                "password=:password " +
                "WHERE studentId=:studentId";
        Map m = new HashMap();
        m.put("studentId",s.getStudentId());
        m.put("regNo",s.getRegNo());
        m.put("firstName",s.getFirstName());
        m.put("lastName", s.getLastName());
        m.put("otherName", s.getOtherName());
        m.put("gender", s.getGender());
        m.put("faculty", s.getFaculty());
        m.put("department", s.getDepartment());
        m.put("email", s.getEmail());
        m.put("phone", s.getPhone());
        m.put("yearLevel", s.getYearLevel());
        m.put("password", s.getPassword());
        m.put("loginStatus", s.getLoginStatus());
        getNamedParameterJdbcTemplate().update(sql, m);
    }

    @Override
    public void delete(Student s) {

        this.delete(s.getStudentId());
    }

    @Override
    public void delete(Integer studentId) {
        String sql = "DELETE FROM student WHERE studentId=?";
        getJdbcTemplate().update(sql, studentId);

    }

    @Override
    public Student findById(Integer studentId) {
        String sql = "SELECT studentId, regNo, firstName, lastName, otherName,  " +
                "gender,faculty, department, email, phone, yearLevel,role,loginStatus FROM student WHERE studentId=?";
        return getJdbcTemplate().queryForObject(sql, new StudentRowMapper(), studentId);
    }

    @Override
    public List<Student> findAll() {

        String sql = "SELECT studentId, regNo, firsName, lastName, otherName, " +
                "gender,faculty, department, email, phone, yearLevel,role,loginStatus FROM student";
        return getJdbcTemplate().query(sql, new StudentRowMapper());
    }

    @Override
    public List<Student> findByProperty(String propName, Object propValue) {
        String sql = "SELECT  studentId, regNo, firstName, lastName, otherName," +
                "gender,faculty, department, email, phone, yearLevel,role,loginStatus FROM student WHERE " + propName + "=?";
        return getJdbcTemplate().query(sql, new StudentRowMapper(), propValue);
    }
}
