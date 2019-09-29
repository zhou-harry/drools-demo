package com.harry.droolsdemo;

import com.harry.droolsdemo.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DroolsDemoApplicationTests {

    @Resource
    private KieSession kieSession;

    @Test
    public void contextLoads() {
        // 构建KieServices
        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        // 获取kmodule.xml中配置中名称为ksession-rule的session，默认为有状态的。
        KieSession kSession = kieContainer.newKieSession("ksession-rule");

        Product product = new Product();
        product.setType(Product.GOLD);

        kSession.insert(product);
        int count = kSession.fireAllRules();
        System.out.println("命中了" + count + "条规则！");
        System.out.println("商品" + product.getType() + "的商品折扣为" + product.getDiscount() + "%。");
    }

    @Test
    public void ksessionDrl() {

        Product product = new Product();
        product.setType(Product.GOLD);
        //全局的接收对象
        List<String> results =new ArrayList<>();
        kieSession.getAgenda().getAgendaGroup("product").setFocus();
        kieSession.setGlobal("listRules", results);
        kieSession.insert(product);
        int count = kieSession.fireAllRules();
        System.out.println("命中了" + count + "条规则！");
        System.out.println("商品" + product.getType() + "的商品折扣为" + product.getDiscount() + "%。");
    }

}
