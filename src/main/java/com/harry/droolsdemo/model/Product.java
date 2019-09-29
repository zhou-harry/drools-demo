package com.harry.droolsdemo.model;

/**
 * @author zhouhong
 * @version 1.0
 * @title: Product
 * @description: TODO
 * @date 2019/9/24 17:20
 */
public class Product {

    public static final String DIAMOND = "DIAMOND"; // 钻石

    public static final String GOLD = "GOLD"; // 黄金

    private String type;

    private int discount;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
