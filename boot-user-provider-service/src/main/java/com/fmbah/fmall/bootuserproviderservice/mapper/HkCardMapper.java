package com.fmbah.fmall.bootuserproviderservice.mapper;

import com.fmbah.fmall.bean.HkCrad;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HkCardMapper {
    public void insertHkCard(@Param("hkCrad") HkCrad hkCrad);
}
