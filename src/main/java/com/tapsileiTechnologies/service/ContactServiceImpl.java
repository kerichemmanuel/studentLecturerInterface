package com.tapsileiTechnologies.service;

import com.tapsileiTechnologies.dao.BaseDAO;
import com.tapsileiTechnologies.dao.ContactDAO;
import com.tapsileiTechnologies.domain.Contact;
import com.tapsileiTechnologies.rm.ContactRowMapper;
import com.tapsileiTechnologies.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContactServiceImpl extends BaseDAO implements ContactService {

    @Autowired
    private ContactDAO contactDAO;

    @Override
    public void save(Contact c) {
        contactDAO.save(c);
    }

    @Override
    public void update(Contact c) {
        contactDAO.update(c);
    }

    @Override
    public void delete(Integer cotactId) {
        contactDAO.delete(cotactId);
    }

    @Override
    public void delete(Integer[] cotactIds) {
        String ids = StringUtil.toCommaSeparatedString(cotactIds);
        String sql = "DELETE FROM contact WHERE contactId IN(" + ids + ")";
        getJdbcTemplate().update(sql);
    }

    @Override
    public List<Contact> findUserContact(Integer userId) {
        return contactDAO.findByProperty("userId", userId);
    }

    @Override
    public List<Contact> findUserContact(Integer userId, String txt) {
        String sql = "SELECT contactId, userId, name, phone, email, address, remark FROM contact WHERE userId=? AND (name LIKE '%" + txt + "%' OR address LIKE '%" + txt + "%' OR phone LIKE '%" + txt + "%' OR email LIKE '%" + txt + "%' OR remark LIKE '%" + txt + "%')";
        return getJdbcTemplate().query(sql, new ContactRowMapper(), userId);
    }

    @Override
    public Contact findById(Integer cotactId) {
        return contactDAO.findById(cotactId);
    }

}
