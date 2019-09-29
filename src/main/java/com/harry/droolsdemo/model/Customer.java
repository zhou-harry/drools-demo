package com.harry.droolsdemo.model;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhong
 * @version 1.0
 * @title: Customer
 * @description: TODO
 * @date 2019/9/27 17:43
 */
@Data
@Builder
public class Customer extends RuleBase{

    private String name;
    private String group;
    private String companyCode;
    private String saleArea;


    @Override
    public RuleModel buildModel() {
        Map<String,String>properties=new HashMap<>();
        properties.put("companyCode",companyCode);
        properties.put("saleArea",saleArea);

        return RuleModel.builder()
                .id(name)
                .a(group)
                .c(properties)
                .build();
    }
}
