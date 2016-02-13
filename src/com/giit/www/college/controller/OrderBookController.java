package com.giit.www.college.controller;

import com.giit.www.college.service.OrderBookBiz;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by c0de8ug on 16-2-13.
 */
@Controller
public class OrderBookController {
    @Resource(name = "orderBookBizImpl")
    private OrderBookBiz orderBookBiz;


}
