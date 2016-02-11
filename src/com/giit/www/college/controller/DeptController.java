package com.giit.www.college.controller;

import com.giit.www.college.service.DeptBiz;
import com.giit.www.entity.Dept;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by c0de8ug on 16-2-10.
 */

@Controller
@RequestMapping("dept.do")
public class DeptController {

    @Resource(name = "deptBizImpl")
    private DeptBiz deptBiz;

    @RequestMapping("findAll")
    public String findAll(Model m) {
        m.addAttribute("departments", deptBiz.findAll());
        return "/college/dept";
    }

    @RequestMapping("add")
    public String add(String deptName) {
        deptBiz.add(deptName);
        return "redirect:/dept.do/findAll";
    }

    @RequestMapping("update")
    public String update(Dept dept) {
        deptBiz.update(dept);
        return "redirect:/dept.do/findAll";
    }

    @RequestMapping("delete")
    public String delete(int deptId) {
        deptBiz.delete(deptId);
        return "redirect:/dept.do/findAll";
    }

}
