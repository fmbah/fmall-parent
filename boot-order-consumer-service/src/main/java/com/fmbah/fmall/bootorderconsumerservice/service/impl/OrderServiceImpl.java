package com.fmbah.fmall.bootorderconsumerservice.service.impl;

import com.fmbah.fmall.bean.UserAddress;
import com.fmbah.fmall.bootorderconsumerservice.service.OrderService;
import com.fmbah.fmall.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Reference(version = "1.0.0")
    UserService userService;

    public List<UserAddress> initOrder(String userId) {
        List<UserAddress> userAddressList = userService.listUserAddress(userId);
        userAddressList.forEach(e->System.out.println(e.getAddress()));
        return userAddressList;
    }


}
