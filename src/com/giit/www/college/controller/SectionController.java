package com.giit.www.college.controller;

import com.giit.www.college.service.SectionBiz;
import com.giit.www.entity.Section;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by c0de8ug on 16-2-12.
 */
@Controller
@RequestMapping("section.do")
public class SectionController {
    @Resource(name = "sectionBizImpl")
    private SectionBiz sectionBiz;

    @RequestMapping("section.view")
    public String sectionView(Model m) {
        m.addAttribute("sectionList", sectionBiz.findAllCustom());

        return "/college/section";
    }

    @RequestMapping("section_add.view")
    public String sectionAddView(Model m) {
        m.addAttribute("courseTitleList", sectionBiz.findAllCourseTitle());
        m.addAttribute("teacherNameList", sectionBiz.findAllTeacherName());
        return "/college/section_add";
    }


    @RequestMapping("add")
    public String add(Section section) {
        sectionBiz.add(section);
        return "redirect:section.view";
    }

    @RequestMapping("delete")
    public String delete(int sectionId) {
        sectionBiz.delete(sectionId);
        return "redirect:section.view";
    }
}
