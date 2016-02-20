package com.giit.www.college.service.impl;

import com.giit.www.college.dao.StudentDao;
import com.giit.www.college.service.StudentBiz;
import com.giit.www.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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

    public void add(Student student, MultipartFile pic) throws IOException {

        if (pic.getSize() != 0) {
            String originalFilename = pic.getOriginalFilename();

            String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFilename = UUID.randomUUID() + fileType;

            //TODO 这里的路径分配应该放到环境变量
            String path = "/home/c0de8ug/software/apache-tomcat-8.0.28/pic/";

            File dest = new File(path + newFilename);
            pic.transferTo(dest);

            student.setPicPath(newFilename);
        }

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
