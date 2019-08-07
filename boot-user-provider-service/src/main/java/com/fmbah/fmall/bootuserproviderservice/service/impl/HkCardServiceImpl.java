package com.fmbah.fmall.bootuserproviderservice.service.impl;

import com.fmbah.fmall.bean.HkCrad;
import com.fmbah.fmall.bootuserproviderservice.mapper.HkCardMapper;
import com.fmbah.fmall.service.HkCardService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(version = "1.0.0", timeout = 5000)
public class HkCardServiceImpl implements HkCardService {

    @Autowired
    private HkCardMapper mapper;

    @Override
    public void insertHkCard(HkCrad hkCrad) {
        mapper.insertHkCard(hkCrad);
    }

}
