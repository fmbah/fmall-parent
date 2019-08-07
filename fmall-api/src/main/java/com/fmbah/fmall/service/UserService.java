package com.fmbah.fmall.service;

import com.fmbah.fmall.bean.UserAddress;

import java.util.List;

public interface UserService {

    List<UserAddress> listUserAddress(String userId);

}
