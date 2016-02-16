package com.giit.www.student.service.Impl;

import com.giit.www.college.dao.TakesDao;
import com.giit.www.student.service.ElectiveBiz;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by c0de8ug on 16-2-16.
 */
@Service
public class ElectiveBizImpl implements ElectiveBiz {

    @Resource
    private TakesDao takesDao;

    public void add(int secId,int stdId) {
        takesDao.add(secId, stdId);
    }
}
