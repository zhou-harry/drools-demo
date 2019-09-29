package com.harry.droolsdemo.function;

import com.harry.droolsdemo.model.RuleBase;
import com.harry.droolsdemo.model.RuleModel;
import com.harry.droolsdemo.response.ApiResponse;

import java.util.List;

/**
 * @author zhouhong
 * @version 1.0
 * @title: RFunction
 * @description: TODO
 * @date 2019/9/27 17:32
 */
public interface RFunction<T extends RuleBase> {

    ApiResponse<List<RuleModel>> resolver(List<T> input);
}
