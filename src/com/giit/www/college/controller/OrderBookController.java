package com.giit.www.college.controller;

import com.giit.www.college.service.OrderBookBiz;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by c0de8ug on 16-2-13.
 */
//TODO URL我自己定义全小写
@RequestMapping("orderbook.do")
@Controller
public class OrderBookController {
    @Resource(name = "orderBookBizImpl")
    private OrderBookBiz orderBookBiz;

    @RequestMapping("orderbook.view")
    public String orderBookView(Model m, HttpSession httpSession) {
        String staffId = (String) httpSession.getAttribute("username");

        //TODO 这里的year应该从服务器端开课的地方拿,但是如何拿怎么拿有点不理解,先给它一个值
        List<String> courseList = orderBookBiz.findSelectedCourseTitle(staffId, "20162");
        int courseCount = courseList.size();
        m.addAttribute("selectedCourseList", courseList);
        m.addAttribute("courseCount", courseCount);
        return "/teacher/orderbook";
    }

    @RequestMapping("orderbook_review.view")
    public String orderBookReviewView(Model m) {
        return "/teacher/orderbook_review";
    }

    @RequestMapping("orderbook_add.view")
    public String orderBookAddView(Model m) {
        return "/teacher/orderbook_add";
    }

    @RequestMapping("orderbook_added.view")
    public String orderBookAddedView(Model m) {
        return "/teacher/orderbook_added";
    }


    @RequestMapping("add")
    public String add() {
        return "/orderbook.do/orderbook.view";
    }

}
