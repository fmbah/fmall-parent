package com.fmbah.fmall.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class HkCrad implements Serializable {

    private Long id;
    private String name;
    private String cardNum;
    private String type;

}
