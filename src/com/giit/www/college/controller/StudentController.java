package com.giit.www.college.controller;

import com.giit.www.college.service.StudentBiz;
import com.giit.www.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by c0de8ug on 16-2-12.
 */
@Controller
@RequestMapping("student.do")
public class StudentController {

    @Resource(name = "studentBizImpl")
    StudentBiz studentBiz;

    @RequestMapping("student.view")
    public String studentView(Model m) {
        //TODO 将biz命名为和业务有关的函数方法,不知道是否正确留个吭
        m.addAttribute("studentList", studentBiz.studentView());
        return "/admin/college/student";
    }

    @RequestMapping("student_add.view")
    public String studentAddView(Model m) {

        return "/admin/college/student_add";
    }

    @RequestMapping("student_update.view")
    public String studentUpdateView(Model m) {

        return "/admin/college/student_update";
    }

    @RequestMapping("student_elective.view")
    public String studentElectiveView() {
        return "/student/elective";
    }

    @RequestMapping("add")
    public String add(Model m, Student student) {
        studentBiz.add(student);
        return "/student.do/student.view";
    }

    @RequestMapping("delete")
    public String delete(Model m, int studentId) {
        studentBiz.delete(studentId);
        return "/student.do/student.view";
    }

}
