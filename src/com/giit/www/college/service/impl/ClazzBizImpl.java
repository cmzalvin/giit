package com.giit.www.college.service.impl;

import com.giit.www.college.dao.ClazzDao;
import com.giit.www.college.dao.DeptDao;
import com.giit.www.college.dao.SpecDao;
import com.giit.www.college.service.ClazzBiz;
import com.giit.www.entity.Clazz;
import com.giit.www.entity.custom.DeptAndSpec;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by c0de8ug on 16-2-11.
 */
@Service
public class ClazzBizImpl implements ClazzBiz {

    @Resource
    private ClazzDao clazzDao;
    @Resource
    private DeptDao deptDao;
    @Resource
    private SpecDao specDao;

    public void add(String deptName, String specName, String year) {
        Clazz clazz = new Clazz();
        clazz.setClazzId(year.substring(2) + deptDao.findIdByName(deptName) + specDao.findIdByName(specName) + clazzDao.getClassCount(specName, year));


        clazzDao.add(clazz);
    }

    public void delete(int clazzId) {
        clazzDao.delete(clazzId);
    }

    public List<Class> findAll() {
        return clazzDao.findAll();
    }

    @Override
    public List<DeptAndSpec> findDeptAndSpec() {
        return specDao.findDeptAndSpec();
    }

}
