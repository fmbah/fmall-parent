package com.fmbah.fmall.bootorderconsumerservice.service;

import com.fmbah.fmall.bean.UserAddress;

import java.util.List;

public interface OrderService {

    List<UserAddress> initOrder(String userId);

}
