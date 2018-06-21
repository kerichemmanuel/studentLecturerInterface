package com.tapsileiTechnologies.service;

import com.tapsileiTechnologies.dao.BaseDAO;
import com.tapsileiTechnologies.dao.StudentDao;
import com.tapsileiTechnologies.domain.Student;
import com.tapsileiTechnologies.exception.UserBlockedException;
import com.tapsileiTechnologies.rm.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl extends BaseDAO implements StudentService {

    @Autowired
    private StudentDao studentDao;


    @Override
    public void register(Student student) {

        studentDao.save(student);
    }

    @Override
    public void update(Student s) {
        studentDao.update(s);
    }

    @Override
    public Student login(String regNo, String password) throws UserBlockedException {
        String sql ="SELECT studentId, regNo, firstName, lastName, otherName, " +
                "gender,faculty, department, email, phone, yearLevel,role,loginStatus FROM student " +
                "WHERE regNo=:rg AND password=:pw";
        Map m = new HashMap();
        m.put("rg", regNo);
        m.put("pw", password);
        try {
            Student stude = getNamedParameterJdbcTemplate().queryForObject(sql, m, new StudentRowMapper());
            if (stude.getLoginStatus().equals(StudentService.LOGIN_STATUS_BLOCKED)) {
                throw new UserBlockedException("Your account has been blocked. Contact Admin.");
            } else {
                System.out.println("3. Student Accepted");
                return stude;
            }
        } catch (EmptyResultDataAccessException ex) {
            System.out.println("3. just got you more times dude.....,No moving ahead please,without right details at StudentServiceImpl");
            return null;
        }

    }

    @Override
    public List<Student> getStudentList() {
        return studentDao.findByProperty("role", StudentService.ROLE_STUDENT);
    }

    @Override
    public void changeLoginStatus(Integer studentId, Integer loginStatus) {
        String sql = "UPDATE student SET loginStatus=:lst WHERE studentId=:sid";
        Map m = new HashMap();
        m.put("sid", studentId);
        m.put("lst", loginStatus);
        getNamedParameterJdbcTemplate().update(sql, m);

    }

    @Override
    public Boolean isStudentRegNoExist(String regNo) {
        String sql = "SELECT count(regNo) FROM student WHERE regNo=?";
        Integer count = getJdbcTemplate().queryForObject(sql, new String[]{regNo}, Integer.class);
        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Student findById(Integer studentId) {
        return studentDao.findById(studentId);
    }

    @Override
    public void delete(Student s) {
        studentDao.delete(s);
    }

    @Override
    public void delete(Integer studentId) {
        studentDao.delete(studentId);

    }
}
