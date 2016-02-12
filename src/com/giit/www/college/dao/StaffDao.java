package com.giit.www.college.dao;

import java.util.List;

/**
 * Created by c0de8ug on 16-2-12.
 */
public interface StaffDao {
    public List<String> findAllName();

    public String findIdByName(String staffId);
}
