package com.giit.www.college.service;

import java.util.List;

/**
 * Created by c0de8ug on 16-2-11.
 */
public interface ClassBiz {
    public void add(Class clazz);

    public void delete(int clazzId);

    public List<Class> findAll();

}
