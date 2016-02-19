package com.giit.www.college.service.impl;

import com.giit.www.college.dao.StudentDao;
import com.giit.www.college.service.StudentBiz;
import com.giit.www.entity.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by c0de8ug on 16-2-13.
 */
@Service
public class StudentBizImpl implements StudentBiz {
    @Resource
    private StudentDao studentDao;

    public List<Student> studentView() {
        return studentDao.findAll();
    }

    public void add(Student student) {
        studentDao.add(student);
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    public void delete(int studentId) {
        studentDao.delete(studentId);
    }

}
