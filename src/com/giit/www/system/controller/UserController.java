package com.giit.www.system.controller;

import com.giit.www.entity.User;
import com.giit.www.system.service.UserBiz;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by c0de8ug on 16-2-9.
 */

@Controller
@RequestMapping("user.do")
public class UserController {

    @Resource(name = "userBizImpl")
    private UserBiz userBiz;

    @RequestMapping("findAll")
    public String findAll(Model m) {
        m.addAttribute("userList", userBiz.findAll());
        return "system/userinfo/user";
    }

    @RequestMapping("findById")
    public String findById(String id, Model m) {
        //todo 这里要做非空判断
        m.addAttribute("user", userBiz.findById(id));
        return "system/userinfo/user_update";
    }

    @RequestMapping("update")
    public String update(User user) {
        userBiz.update(user);
        return "redirect:/user.do/findAll";
    }

    @RequestMapping("add")
    public String add(User user) {
        userBiz.add(user);
        return "redirect:/user.do/findAll";
    }

    @RequestMapping("delete")
    public String delete(String id) {
        userBiz.delete(id);
        return "redirect:/user.do/findAll";
    }

}
