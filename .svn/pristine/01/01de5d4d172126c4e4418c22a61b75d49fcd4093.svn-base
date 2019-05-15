package com.zhongz.rental.common.utils;

import com.zhongz.rental.domain.ZhongzOrder;
import com.zhongz.rental.domain.ZhongzServiceOrder;
import com.zhongz.rental.mapper.ZhongzOrderMapper;
import com.zhongz.rental.mapper.ZhongzServiceOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class OrderUtils {

    @Autowired
    private ZhongzOrderMapper zhongzOrderMapper;
    @Autowired
    private ZhongzServiceOrderMapper zhongzServiceOrderMapper;

    public ZhongzOrder generateOrder(String title,Integer orderType) {
        ZhongzOrder order = new ZhongzOrder();
        Integer dayMaxOrder = zhongzOrderMapper.selectZhongzOrderDayMaxOrder(orderType);
        if(dayMaxOrder == null) {
            dayMaxOrder = 1;
        }else {
            dayMaxOrder += 1;
        }
        order.setOrderDayOrder(dayMaxOrder);
        String stringOrder = "" + dayMaxOrder;
        if(stringOrder.length() == 1) {
            stringOrder = "00" + stringOrder;
        }else if(stringOrder.length() == 2) {
            stringOrder = "0" + stringOrder;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        order.setOrderId(title + format.format(new Date()) + stringOrder);
        return order;
    }

    public ZhongzServiceOrder generateServiceOrder(String title, Integer orderType) {
        ZhongzServiceOrder order = new ZhongzServiceOrder();
        Integer dayMaxOrder = zhongzServiceOrderMapper.selectZhongzServiceOrderDayMaxOrder(orderType);
        if(dayMaxOrder == null) {
            dayMaxOrder = 1;
        }else {
            dayMaxOrder += 1;
        }
        order.setOrderDayOrder(dayMaxOrder);
        String stringOrder = "" + dayMaxOrder;
        if(stringOrder.length() == 1) {
            stringOrder = "00" + stringOrder;
        }else if(stringOrder.length() == 2) {
            stringOrder = "0" + stringOrder;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        order.setOrderId(title + format.format(new Date()) + stringOrder);
        return order;
    }
}
