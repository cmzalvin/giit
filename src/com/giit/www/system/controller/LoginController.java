package com.giit.www.system.controller;

import com.giit.www.entity.User;
import com.giit.www.system.service.AccountBiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by c0de8ug on 16-2-14.
 */
@Controller
@RequestMapping("login.do")
public class LoginController {

    @Resource(name = "accountBizImpl")
    private AccountBiz accountBiz;

    @RequestMapping("login")
    public String login(HttpSession session, String username, String password) {
        User user;
        user = accountBiz.findByIdAndPassword(username, password);
        if (user != null) {
            session.setAttribute("username", username);
            String authority = user.getAuthority();
            switch (authority) {
                case "0":
                    return "/admin/main";
                case "1":
                    return "/teacher/main";
                case "2":
                    return "/student/main";
            }
        }
        return "redirect:/login.jsp";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login.jsp";
    }
}
