package com.giit.www.college.service.impl;

import com.giit.www.college.dao.OrderBookDao;
import com.giit.www.college.dao.SectionDao;
import com.giit.www.college.service.OrderBookBiz;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by c0de8ug on 16-2-13.
 */
@Service
public class OrderBookBizImpl implements OrderBookBiz {

    @Resource
    OrderBookDao orderBookDao;

    @Resource
    SectionDao sectionDao;

    @Override
    public List<String> findSelectedCourseTitle(String staffId, String year) {
        return sectionDao.findSelectedCourseTitle(staffId, year);
    }
}
