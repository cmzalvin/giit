package com.giit.www.college.controller;

import com.giit.www.college.service.SectionBiz;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by c0de8ug on 16-2-12.
 */
@Controller
public class SectionController {
    @Resource(name = "sectionBizImpl")
    private SectionBiz sectionBiz;


}
