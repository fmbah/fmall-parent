package com.fmbah.fmall.bootuserproviderservice.service.impl;


import com.fmbah.fmall.bean.UserAddress;
import com.fmbah.fmall.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {

    public List<UserAddress> listUserAddress(String userId) {

        UserAddress userAddress0 = new UserAddress();
        userAddress0.setAddress("黑龙江省");
        userAddress0.setContactName("赵志噶");
        userAddress0.setId(1);
        userAddress0.setPhone("13766363636");


        UserAddress userAddress1 = new UserAddress();
        userAddress1.setAddress("黑龙江省");
        userAddress1.setContactName("赵志噶");
        userAddress1.setId(1);
        userAddress1.setPhone("13766363636");

        return Arrays.asList(userAddress0, userAddress1);
    }
}
