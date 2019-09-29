package com.harry.droolsdemo.controller;

import com.harry.droolsdemo.function.XLSFunction;
import com.harry.droolsdemo.model.Customer;
import com.harry.droolsdemo.model.InsuranceRulesModel;
import com.harry.droolsdemo.model.Product;
import com.harry.droolsdemo.model.RuleModel;
import com.harry.droolsdemo.response.ApiResponse;
import com.harry.droolsdemo.utils.KieSessionUtils;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author zhouhong
 * @version 1.0
 * @title: InsuranceRulesController
 * @description: TODO
 * @date 2019/9/26 11:19
 */
@RequestMapping("insurance")
@RestController
public class InsuranceRulesController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private KieSession kieSession;
    @Autowired
    private XLSFunction function;

    @PostMapping("/resolverExcel")
    public List<ApiResponse> resolverExcel(@RequestBody List<InsuranceRulesModel> params) {
        List<ApiResponse> response = new ArrayList<>();

        String templateUrl = "D:\\Documents\\Downloads\\workspace\\drools-demo\\src\\main\\resources\\rules\\excel\\insuranceRules.xls";
        //获取kiesession
        KieSession kieSession = null;
        long start = System.currentTimeMillis();
        try {
            kieSession = KieSessionUtils.getKieSessionFromXLS(templateUrl);
            kieSession.getAgenda().getAgendaGroup("sign").setFocus();
        } catch (Exception e) {
            logger.info("模板编写异常，请仔细核对！{}", e);
            ApiResponse<String> r = new ApiResponse<>();
            r.setCode(500);
            r.setFail();
            r.setMsg("模板编写错误，请仔细核对！错误信息如下：" + e);
            response.add(r);
            return response;
        }
        logger.info("获取kiesession耗时：{}", (System.currentTimeMillis() - start));

        //全局的接收对象
        List<String> results = new ArrayList<>();
        kieSession.setGlobal("listRules", results);
        for (InsuranceRulesModel model : params) {
            kieSession.insert(model);
        }
        //返回结果
        int rules_count = kieSession.fireAllRules();
        if (rules_count == 0 && results.size() == 0) {
            ApiResponse<String> r = new ApiResponse<>();
            r.setSuccess();
            r.setMsg("触发了" + rules_count + "条规则,校验结果：校验通过！");
            response.add(r);
        } else {
            //规范返回校验结果
            List<String> listRules_standard = new ArrayList<>();
            if (rules_count > 0) {
                for (int i = 0; i < results.size(); i++) {
                    listRules_standard.add((i + 1) + "：" + results.get(i));
                }
            }
            ApiResponse<String> r = new ApiResponse<>();
            r.setFail();
            r.setMsg("触发了" + rules_count + "条规则,校验结果集合：" + listRules_standard);
            response.add(r);
        }

        return response;
    }

    @PostMapping("/resolverRules")
    public List<ApiResponse> resolverRules(@RequestBody List<InsuranceRulesModel> params) {
        List<ApiResponse> response = new ArrayList<>();
        //全局的接收对象
        List<String> results = new ArrayList<>();
        kieSession.getAgenda().getAgendaGroup("sign").setFocus();
        kieSession.setGlobal("listRules", results);
        for (InsuranceRulesModel model : params) {
            kieSession.insert(model);
        }
        //返回结果
        int rules_count = kieSession.fireAllRules();
        if (rules_count == 0 && results.size() == 0) {
            ApiResponse<String> r = new ApiResponse<>();
            r.setSuccess();
            r.setMsg("触发了" + rules_count + "条规则,校验结果：校验通过！");
            response.add(r);
        } else {
            //规范返回校验结果
            List<String> listRules_standard = new ArrayList<>();
            if (rules_count > 0) {
                for (int i = 0; i < results.size(); i++) {
                    listRules_standard.add((i + 1) + "：" + results.get(i));
                }
            }
            ApiResponse<String> r = new ApiResponse<>();
            r.setFail();
            r.setMsg("触发了" + rules_count + "条规则,校验结果集合：" + listRules_standard);
            response.add(r);
        }
        return response;
    }

    @GetMapping("/resolverProduct")
    public ApiResponse resolverProduct() {
        Product product = new Product();
        product.setType(Product.GOLD);
        //全局的接收对象
        List<String> results = new ArrayList<>();
        kieSession.getAgenda().getAgendaGroup("product").setFocus();
        kieSession.setGlobal("listRules", results);
        kieSession.insert(product);
        int count = kieSession.fireAllRules();

        System.out.println("命中了" + count + "条规则！");
        System.out.println("商品" + product.getType() + "的商品折扣为" + product.getDiscount() + "%。");
        ApiResponse<Object> response = new ApiResponse<>();
        response.setSuccess();
        response.setMsg("商品" + product.getType() + "的商品折扣为" + product.getDiscount() + "%。");
        System.out.println("====" + results.size());
        return response;
    }

    @GetMapping("/resolverMap")
    public String resolverMap() {
        Map<String, String> c = new HashMap<>();
        c.put("companyCode", "tplhk");
        RuleModel model = new RuleModel();
        model.setId("harry");
        model.setC(c);

        kieSession.getAgenda().getAgendaGroup("map").setFocus();
        kieSession.insert(model);
        int count = kieSession.fireAllRules();

        System.out.println("命中了" + count + "条规则！");
        if (count > 0) {
            System.out.println(model);
        }
        return model.toString();
    }

    @PostMapping("/resolverMapExcel")
    public ApiResponse<List<RuleModel>> resolverMapExcel(@RequestBody List<Customer> params) {

        ApiResponse response = function.resolver(params);

        return response;
    }
}
