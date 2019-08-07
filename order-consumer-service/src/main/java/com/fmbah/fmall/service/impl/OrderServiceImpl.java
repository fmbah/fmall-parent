package com.fmbah.fmall.service.impl;

import com.fmbah.fmall.bean.UserAddress;
import com.fmbah.fmall.service.OrderService;
import com.fmbah.fmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    UserService userService;

    public void initOrder(String userId) {
        List<UserAddress> userAddressList = userService.listUserAddress(userId);
        userAddressList.forEach(e->System.out.println(e.getAddress()));
    }


}
