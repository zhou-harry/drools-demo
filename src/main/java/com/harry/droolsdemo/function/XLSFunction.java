package com.harry.droolsdemo.function;

import com.harry.droolsdemo.model.Customer;
import com.harry.droolsdemo.model.RuleBase;
import com.harry.droolsdemo.model.RuleModel;
import com.harry.droolsdemo.response.ApiResponse;
import com.harry.droolsdemo.utils.KieSessionUtils;
import org.apache.poi.ss.formula.functions.T;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouhong
 * @version 1.0
 * @title: XLSFunction
 * @description: TODO
 * @date 2019/9/27 17:42
 */
@Component
public class XLSFunction<T extends RuleBase> implements RFunction<T>{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public ApiResponse<List<RuleModel>> resolver(List<T> input) {
        ApiResponse<List<RuleModel>> response = new ApiResponse<>();
        String templateUrl = "D:\\Documents\\Downloads\\workspace\\drools-demo\\src\\main\\resources\\rules\\excel\\mapRules.xls";
        //获取kiesession
        KieSession kieSession = null;
        long start = System.currentTimeMillis();
        try {
            System.out.println(KieSessionUtils.getDRL(templateUrl));

            kieSession = KieSessionUtils.getKieSessionFromXLS(templateUrl);
            kieSession.getAgenda().getAgendaGroup("map").setFocus();
        } catch (Exception e) {
            logger.info("模板编写异常，请仔细核对！{}", e);
            response.setCode(500);
            response.setFail();
            response.setMsg("模板编写错误，请仔细核对！错误信息如下：" + e);
            return response;
        }
        logger.info("获取kiesession耗时：{}", (System.currentTimeMillis() - start));
        List<RuleModel> models=new ArrayList<>();
        for (T model : input) {
            RuleModel ruleModel = model.buildModel();
            kieSession.insert(ruleModel);
            models.add(ruleModel);
        }
        //返回结果
        int count = kieSession.fireAllRules();
        response.setSuccess();
        response.setMsg("触发了" + count + "条规则,校验结果：校验通过！");
        response.setData(models);

        return response;
    }

}
