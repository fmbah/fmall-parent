package com.fmbah.fmall.service.impl;

import com.fmbah.fmall.bean.HkCrad;
import com.fmbah.fmall.service.HkCardService;

public class HkCardServiceStub implements HkCardService {

    private final HkCardService hkCardService;

    /**
     * Dubbo注入远程对象
     * @param hkCardService
     */
    public HkCardServiceStub(HkCardService hkCardService) {
        this.hkCardService = hkCardService;
    }


    @Override
    public void insertHkCard(HkCrad hkCrad) {
        System.out.println("本地存根方式调用.............");
        if(null != hkCrad) {
            hkCardService.insertHkCard(hkCrad);
        }
    }
}
