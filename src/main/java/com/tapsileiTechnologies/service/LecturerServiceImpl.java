package com.tapsileiTechnologies.service;

import com.tapsileiTechnologies.dao.BaseDAO;
import com.tapsileiTechnologies.dao.LecturerDao;
import com.tapsileiTechnologies.domain.Lecturer;
import com.tapsileiTechnologies.exception.UserBlockedException;
import com.tapsileiTechnologies.rm.LecturerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LecturerServiceImpl extends BaseDAO implements LecturerService {

    @Autowired
    private LecturerDao lecturerDao;


    @Override
    public void register(Lecturer lecturer) {

        lecturerDao.save(lecturer);
    }

    @Override
    public Lecturer login(String staffNo, String password) throws UserBlockedException {
        String sql ="SELECT lecturerId,staffNo, firstName, lastName, otherName, " +
                "gender,faculty, department, email, phone, citation, specialization,role,loginStatus FROM lecturer " +
                "WHERE staffNo=:sn And password=:pw";
        Map m = new HashMap();
        m.put("sn", staffNo);
        m.put("pw", password);
        try {
            Lecturer lec = getNamedParameterJdbcTemplate().queryForObject(sql, m, new LecturerRowMapper());
            if (lec.getLoginStatus().equals(LecturerService.LOGIN_STATUS_BLOCKED)) {
                throw new UserBlockedException("Your account has been blocked. Contact to admin.");
            } else {
                System.out.println("2. Lecturer Accepted");
                return lec;
            }
        } catch (EmptyResultDataAccessException ex) {
            System.out.println("2. just got you again dude.....,No moving ahead please,without right details at LecturerServiceImpl");
            return null;
        }
    }

    @Override
    public List<Lecturer> getLecturerList() {
        return lecturerDao.findByProperty("role", LecturerService.ROLE_LECTURER);
    }

    @Override
    public void changeLoginStatus(Integer lecturerId, Integer loginStatus) {

        String sql = "UPDATE lecturer SET loginStatus=:lst WHERE lecturerId=:lid";
        Map m = new HashMap();
        m.put("lid", lecturerId);
        m.put("lst", loginStatus);
        getNamedParameterJdbcTemplate().update(sql, m);
    }

    @Override
    public Boolean isLecturerStaffNoExist(String staffNo) {
        String sql = "SELECT count(staffNo) FROM lecturer WHERE staffNo=?";
        Integer count = getJdbcTemplate().queryForObject(sql, new String[]{staffNo}, Integer.class);
        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }
}
