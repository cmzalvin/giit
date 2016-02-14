package com.giit.www.college.controller;

import com.giit.www.college.service.StudentBiz;
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
        return "/college/student";
    }

    @RequestMapping("student_add.view")
    public String studentAddView(Model m) {

        return "/college/student_add";
    }

    @RequestMapping("student_elective.view")
    public String studentElectiveView() {
        return "/college/student_elective";
    }
}
