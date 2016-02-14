package com.giit.www.college.service;

import java.util.List;

/**
 * Created by c0de8ug on 16-2-13.
 */
public interface OrderBookBiz {
    public List<String> findSelectedCourseTitle(String staffId, String year);
}
