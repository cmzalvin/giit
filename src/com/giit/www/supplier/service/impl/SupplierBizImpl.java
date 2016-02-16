package com.giit.www.supplier.service.impl;

import com.giit.www.college.dao.OrderBookDao;
import com.giit.www.college.dao.TakesDao;
import com.giit.www.entity.custom.OrderBookReviewVo;
import com.giit.www.entity.custom.OrderBookVo;
import com.giit.www.entity.custom.ReviewedBookVo;
import com.giit.www.supplier.service.SupplierBiz;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

/**
 * Created by c0de8ug on 16-2-16.
 */
@Service
public class SupplierBizImpl implements SupplierBiz {

    @Resource
    private OrderBookDao orderBookDao;


    //TODO 这个代码偷懒了！！！！！要多烂有多烂直接拷贝的。。
    public List<ReviewedBookVo> findAllReviewedBook() {
        List<ReviewedBookVo> reviewedBookVoList = orderBookDao.findAllReviewedBook();

        Iterator iterator = reviewedBookVoList.iterator();
        while (iterator.hasNext()) {
            ReviewedBookVo reviewedBookVo = (ReviewedBookVo) iterator.next();
            List countList = reviewedBookVo.getCountList();
            int amount = 0;
            for (int i = 0; i < countList.size(); i++) {
                amount = amount + (Integer) countList.get(i);
            }
            reviewedBookVo.setAmount(amount);
        }

        return reviewedBookVoList;
    }

}
