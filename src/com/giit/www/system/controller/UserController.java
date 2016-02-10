package com.giit.www.system.controller;

import com.giit.www.system.service.UserBiz;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by c0de8ug on 16-2-9.
 */

@Controller
@RequestMapping("user")
public class UserController {

    @Resource(name = "userBizImpl")
    private UserBiz userBiz;

    @RequestMapping("findAll")
    public String findAll(Model m) {
        m.addAttribute("userList", userBiz.findAll());
        return "system/user";
    }

}
