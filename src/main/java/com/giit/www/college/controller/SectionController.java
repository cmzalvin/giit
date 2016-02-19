package com.giit.www.college.controller;

import com.giit.www.college.service.SectionBiz;
import com.giit.www.entity.Section;
import com.giit.www.entity.Timetable;
import com.giit.www.util.TermContainer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.Timeable;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
        return "/admin/college/section";
    }

    @RequestMapping("section_add.view")
    public String sectionAddView(Model m) {
        m.addAttribute("courseTitleList", sectionBiz.findAllCourseTitle());
        m.addAttribute("staffList", sectionBiz.findAllStaff());
        m.addAttribute("termList", TermContainer.getTermList());
        return "/admin/college/section_add";
    }

    @RequestMapping("section_timetable_add.view")
    public String sectionTimetableAdd(Model m) {
        return "/admin/college/section_timetable_add";
    }

    @RequestMapping("add")
    public String add(Section section, HttpSession session) {
        String staffId = (String) session.getAttribute("username");
        sectionBiz.add(section, staffId);
        return "redirect:section.view";
    }

    @RequestMapping("addTimetable")
    public String addTimetable(Timetable timetable) {
        sectionBiz.addTimetable(timetable);
        return "redirect:section.view";
    }


    @RequestMapping("delete")
    public String delete(int secId) {
        sectionBiz.delete(secId);
        return "redirect:section.view";
    }
}
