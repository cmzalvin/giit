package com.giit.www.college.controller;

import com.giit.www.college.service.OrderBookBiz;
import com.giit.www.entity.Section;
import com.giit.www.entity.custom.ChangedItems;
import com.giit.www.entity.custom.OrderBookReviewVo;
import com.giit.www.entity.custom.OrderBookVo;
import com.giit.www.util.TermContainer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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
        //而且对于一个老师上多门相同的课区分也有问题
        List<Section> sectionList = orderBookBiz.findSelectedSection(staffId, TermContainer.now());
        int courseCount = sectionList.size();
        m.addAttribute("selectedSectionList", sectionList);
        m.addAttribute("courseCount", courseCount);
        return "/teacher/orderbook";
    }

    @RequestMapping("orderbook_review.view")
    public String orderBookReviewView(Model m, HttpSession session) {
        //TODO 放到SESSION方便处理
        session.setAttribute("notReviewedBookList", orderBookBiz.findAllNotReviewedBook());
        return "/teacher/orderbook_review";
    }

    @RequestMapping("orderbook_add.view")
    public String orderBookAddView(Model m) {
        return "/teacher/orderbook_add";
    }

    @RequestMapping("orderbook_added.view")
    public String orderBookAddedView(Model m, HttpSession session) {
        String staffId = (String) session.getAttribute("username");
        m.addAttribute("addedBookInfoList", orderBookBiz.findAddedBookInfoList(staffId));
        return "/teacher/orderbook_added";
    }


    @RequestMapping("add")
    public String add(HttpServletRequest request, HttpSession session) {
        Map map = request.getParameterMap();
        OrderBookVo orderBookVo = new OrderBookVo();
        orderBookVo.setStaffId((String) session.getAttribute("username"));
        orderBookVo.setMap(map);
        orderBookBiz.add(orderBookVo);
        return "redirect:/orderbook.do/orderbook.view";
    }

    @RequestMapping("update")
    @ResponseStatus(value = HttpStatus.OK)
    public void update(@RequestBody ChangedItems changedItems, HttpSession session) {
        orderBookBiz.update(changedItems, (String) session.getAttribute("username"));
    }

    @RequestMapping("audit")
    public String audit(HttpSession session) {
        List<OrderBookReviewVo> orderBookReviewVoList = (List<OrderBookReviewVo>) session.getAttribute("notReviewedBookList");
        orderBookBiz.audit(orderBookReviewVoList);
        return "orderbook.do/orderbook_review.view"
    }
}
