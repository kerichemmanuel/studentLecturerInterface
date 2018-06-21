package com.tapsileiTechnologies.dao;

import com.tapsileiTechnologies.domain.Lecturer;
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
public class LecturerDaoImpl extends  BaseDAO implements LecturerDao {
    @Override
    public void save(Lecturer l) {
        String sql = "INSERT INTO lecturer(staffNo,firstName,lastName,otherName,gender,faculty," +
                "department,email,phone,citation,specialization,password,role,loginStatus) " +
                "VALUES(:staffNo, :firstName, :lastName,:otherName,:gender,:faculty,:department," +
                ":email,:phone,:citation,:specialization,:password,:role,:loginStatus)";
        Map m = new HashMap();
        m.put("staffNo",l.getStaffNo());
        m.put("firstName",l.getFirstName());
        m.put("lastName", l.getLastName());
        m.put("otherName", l.getOtherName());
        m.put("gender", l.getGender());
        m.put("faculty", l.getFaculty());
        m.put("department", l.getDepartment());
        m.put("email", l.getEmail());
        m.put("phone", l.getPhone());
        m.put("citation", l.getCitation());
        m.put("specialization", l.getSpecialization());
        m.put("password", l.getPassword());
        m.put("role", l.getRole());
        m.put("loginStatus", l.getLoginStatus());

        SqlParameterSource ps = new MapSqlParameterSource(m);
        KeyHolder kh = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(sql, ps, kh);
        l.setLecturerId(kh.getKey().intValue());
    }

    @Override
    public void update(Lecturer l) {


        String sql = "UPDATE lecturer SET staffNo=:staffNo, firstName=:firstName, lastName=:lastName," +
                "otherName=:otherName,gender=:gender,faculty=:faculty,department=:department, email=:email," +
                "phone=:phone,citation=:citation,loginStatus=:loginStatus,password=:password WHERE lecturerId=:lecturerId";
        Map m = new HashMap();
        m.put("staffNo",l.getStaffNo());
        m.put("firstName",l.getFirstName());
        m.put("lastName", l.getLastName());
        m.put("otherName", l.getOtherName());
        m.put("gender", l.getGender());
        m.put("faculty", l.getFaculty());
        m.put("department", l.getDepartment());
        m.put("email", l.getEmail());
        m.put("phone", l.getPhone());
        m.put("citation", l.getCitation());
        m.put("specialization", l.getSpecialization());
        m.put("loginStatus", l.getLoginStatus());
        m.put("password", l.getPassword());
        getNamedParameterJdbcTemplate().update(sql, m);
    }

    @Override
    public void delete(Lecturer l) {

        this.delete(l.getLecturerId());
    }

    @Override
    public void delete(Integer lecturerId) {
        String sql = "DELETE FROM lecturer WHERE lecturerId=?";
        getJdbcTemplate().update(sql, lecturerId);

    }

    @Override
    public Lecturer findById(Integer lecturerId) {
        String sql = "SELECT lecturerId, staffNo, firstName, lastName, otherName, " +
                "gender,faculty, department, email, phone, citation, specialization,role,loginStatus FROM lecturer WHERE lecturerId=?";
        return getJdbcTemplate().queryForObject(sql, new LecturerRowMapper(), lecturerId);
    }

    @Override
    public List<Lecturer> findAll() {
        String sql = "SELECT lecturerId, staffNo, firsName, lastName, otherName, " +
                "gender,faculty, department, email, phone, citation, specialization,role,loginStatus FROM lecturer";
        return getJdbcTemplate().query(sql, new LecturerRowMapper());
    }

    @Override
    public List<Lecturer> findByProperty(String propName, Object propValue) {
        String sql = "SELECT  lecturerId, staffNo, firstName, lastName, otherName," +
                "gender,faculty, department, email, phone, citation, specialization,role,loginStatus FROM lecturer WHERE " + propName + "=?";
        return getJdbcTemplate().query(sql, new LecturerRowMapper(), propValue);
    }
}
