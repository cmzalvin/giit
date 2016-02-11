package com.giit.www.college.controller;

import com.giit.www.college.service.ClassBiz;
import com.giit.www.college.service.impl.ClassBizImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by c0de8ug on 16-2-11.
 */
@Controller
@RequestMapping("class.do")
public class ClassController {

    @Resource(name = "classBizImpl")
    private ClassBiz classBiz;

    public String add(Class clazz) {
        classBiz.add(clazz);
        return "redirect:/class.do/findAll";
    }

    public String delete(int classId) {
        classBiz.delete(classId);
        return "redirect:/class.do/findAll";
    }

    public String findAll(Model m) {
        m.addAttribute("classList", classBiz.findAll());
        return "/college/class";
    }
}
