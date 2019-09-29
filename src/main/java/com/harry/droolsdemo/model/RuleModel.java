package com.harry.droolsdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kie.api.definition.rule.All;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhong
 * @version 1.0
 * @title: RuleModel
 * @description: TODO
 * @date 2019/9/27 15:45
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RuleModel {

    /**
     * 当前记录key
     */
    private String id;

    /**
     * Agenda
     */
    private String a;
    /**
     * 当前记录属性
     * Map<属性名称, 属性值>
     */
    private Map<String, String> c;
    /**
     * 校验状态
     */
    private Boolean s;
    /**
     * 校验结果
     * Map<属性名称, 校验结果>
     */
    private final Map<String, String> r = new HashMap<>();

    public void setR(String k, String v) {
        r.put(k, v);
    }

    @Override
    public String toString() {
        return "RuleModel{" +
                "id='" + id + '\'' +
                ", s=" + s +
                ", r=" + r +
                '}';
    }
}
