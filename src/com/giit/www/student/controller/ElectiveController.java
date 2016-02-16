package com.giit.www.student.controller;

import com.giit.www.student.service.ElectiveBiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by c0de8ug on 16-2-16.
 */
@Controller
@RequestMapping("elective.do")
public class ElectiveController {
    @Resource(name = "electiveBizImpl")
    private ElectiveBiz electiveBiz;


    @RequestMapping("elective.view")
    public String electiveView() {
        return "/student/elective";
    }


    @RequestMapping("add")
    public String add(int secId, HttpSession session) {
        String stdId = (String) session.getAttribute("username");
        electiveBiz.add(secId, stdId);
        return "/elective.do/elective_view";
    }
}
