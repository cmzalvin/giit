package com.giit.www.college.controller;

import com.giit.www.college.service.ClazzBiz;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by c0de8ug on 16-2-11.
 */
@Controller
@RequestMapping("clazz.do")
public class ClazzController {

    @Resource(name = "clazzBizImpl")
    private ClazzBiz clazzBiz;

    @RequestMapping("add")
    public String add(String deptName, String specName, String year) {
        clazzBiz.add(deptName, specName, year);
        return "redirect:/class.do/findAll";
    }

    @RequestMapping("delete")
    public String delete(int clazzId) {
        clazzBiz.delete(clazzId);
        return "redirect:/clazz.do/findAll";
    }

    @RequestMapping("findAll")
    public String findAll(Model m) {
        m.addAttribute("clazzList", clazzBiz.findAll());
        return "/college/clazz";
    }

    @RequestMapping("findDeptAndSpec")
    public String findDeptAndSpec(Model m) {
        m.addAttribute("deptAndSpec", clazzBiz.findDeptAndSpec());
        return "/college/clazz_add";
    }
}
