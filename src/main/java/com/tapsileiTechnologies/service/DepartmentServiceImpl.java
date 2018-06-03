package com.tapsileiTechnologies.service;

import com.tapsileiTechnologies.dao.BaseDAO;
import com.tapsileiTechnologies.dao.DepartmentDao;
import com.tapsileiTechnologies.domain.Department;
import com.tapsileiTechnologies.rm.DepartmentRowMapper;
import com.tapsileiTechnologies.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DepartmentServiceImpl extends BaseDAO implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public void save(Department dept) {
        departmentDao.save(dept);

    }

    @Override
    public void update(Department dept) {
        departmentDao.update(dept);

    }

    @Override
    public void delete(Integer deptId) {
        departmentDao.delete(deptId);

    }

    @Override
    public void delete(Integer[] deptIds) {
        String ids = StringUtil.toCommaSeparatedString(deptIds);
        String sql = "DELETE FROM department WHERE departmentId IN(" + ids + ")";
        getJdbcTemplate().update(sql);

    }

    @Override
    public Department findById(Integer deptIds) {

        return departmentDao.findById(deptIds);
    }

    @Override
    public List<Department> findDepartment(Integer deptIds) {
       return departmentDao.findByProperty("deptIds", deptIds);
    }

    @Override
    public List<Department> findDepartment(Integer deptIds, String txt) {
        String sql = "SELECT departmentId, departmentCode,departmentFaculty, departmentName FROM department WHERE deptIds=? AND (departmentCode LIKE '%" + txt + "%' OR departmentFaculty LIKE '%" + txt + "%' OR departmentName LIKE '%" + txt + "%')";
        return getJdbcTemplate().query(sql, new DepartmentRowMapper(), deptIds);
    }
}
