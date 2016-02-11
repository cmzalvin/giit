package com.giit.www.college.service.impl;

import com.giit.www.college.dao.ClassDao;
import com.giit.www.college.service.ClassBiz;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by c0de8ug on 16-2-11.
 */
@Service
public class ClassBizImpl implements ClassBiz {

    @Resource
    private ClassDao classDao;

    public void add(Class clazz) {
        classDao.add(clazz);
    }

    public void delete(int classId) {
        classDao.delete(classId);
    }

    public List<Class> findAll() {
        return classDao.findAll();
    }

}
