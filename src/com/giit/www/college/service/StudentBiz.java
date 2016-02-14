package com.giit.www.college.service;

import com.giit.www.entity.Student;

import java.util.List;

/**
 * Created by c0de8ug on 16-2-13.
 */

public interface StudentBiz {
    public List<Student> studentView();

    public void add(Student student);

    public void update(Student student);

    public void delete(int studentId);
}
