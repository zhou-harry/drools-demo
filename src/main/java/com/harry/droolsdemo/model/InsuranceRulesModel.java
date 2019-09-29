package com.harry.droolsdemo.model;

/**
 * @author zhouhong
 * @version 1.0
 * @title: InsuranceRulesModel
 * @description: 保费规则模型对象
 * @date 2019/9/26 11:04
 */
public class InsuranceRulesModel {

    private String companyCode;//保险公司
    private String planCode;//方案代码
    private String channelId;//渠道号
    private String saleArea;//销售区域(1：不限 2……n:具体城市名称或者code)
    private String insuranceAge;//投保年龄(格式：传数字 如 2岁：2)
    private String insurancePeriod;//保险期间(单位:年)
    private String payPeriod;//缴费期间(单位：年)
    private String payType;//缴费方式(1:趸交  2：年交)
    private String guaranteeType;//保障类型(1:不限  2…n:具体的类型)
    private String waitingPeriod;//等待期(单位：天)
    private String pausePeriod;//犹豫期(单位：天)
    private String careerType;//职业类型
    private String totalAmount;//总保额限制(单位：万)
    private String deductibles;//免赔额(单位：万)
    private String mainRiskAmount;//主险保额(单位：万)
    private String mainRiskPremium;//主险保费(单位：分)
    private String additionRiskAmount;//附加险保额(单位：万)
    private String additionRiskPremium;//附加险保费
    private String relationShipApplicant;//与投保人关系
    private String relationShipInsured;//与被保人关系
    private String sex;//性别(1：男  2：女)
    private String documentType;//证件
    private String totalpremium;//保费
    private String param24;//保额

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getSaleArea() {
        return saleArea;
    }

    public void setSaleArea(String saleArea) {
        this.saleArea = saleArea;
    }

    public String getInsuranceAge() {
        return insuranceAge;
    }

    public void setInsuranceAge(String insuranceAge) {
        this.insuranceAge = insuranceAge;
    }

    public String getInsurancePeriod() {
        return insurancePeriod;
    }

    public void setInsurancePeriod(String insurancePeriod) {
        this.insurancePeriod = insurancePeriod;
    }

    public String getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(String payPeriod) {
        this.payPeriod = payPeriod;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getGuaranteeType() {
        return guaranteeType;
    }

    public void setGuaranteeType(String guaranteeType) {
        this.guaranteeType = guaranteeType;
    }

    public String getWaitingPeriod() {
        return waitingPeriod;
    }

    public void setWaitingPeriod(String waitingPeriod) {
        this.waitingPeriod = waitingPeriod;
    }

    public String getPausePeriod() {
        return pausePeriod;
    }

    public void setPausePeriod(String pausePeriod) {
        this.pausePeriod = pausePeriod;
    }

    public String getCareerType() {
        return careerType;
    }

    public void setCareerType(String careerType) {
        this.careerType = careerType;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDeductibles() {
        return deductibles;
    }

    public void setDeductibles(String deductibles) {
        this.deductibles = deductibles;
    }

    public String getMainRiskAmount() {
        return mainRiskAmount;
    }

    public void setMainRiskAmount(String mainRiskAmount) {
        this.mainRiskAmount = mainRiskAmount;
    }

    public String getMainRiskPremium() {
        return mainRiskPremium;
    }

    public void setMainRiskPremium(String mainRiskPremium) {
        this.mainRiskPremium = mainRiskPremium;
    }

    public String getAdditionRiskAmount() {
        return additionRiskAmount;
    }

    public void setAdditionRiskAmount(String additionRiskAmount) {
        this.additionRiskAmount = additionRiskAmount;
    }

    public String getAdditionRiskPremium() {
        return additionRiskPremium;
    }

    public void setAdditionRiskPremium(String additionRiskPremium) {
        this.additionRiskPremium = additionRiskPremium;
    }

    public String getRelationShipApplicant() {
        return relationShipApplicant;
    }

    public void setRelationShipApplicant(String relationShipApplicant) {
        this.relationShipApplicant = relationShipApplicant;
    }

    public String getRelationShipInsured() {
        return relationShipInsured;
    }

    public void setRelationShipInsured(String relationShipInsured) {
        this.relationShipInsured = relationShipInsured;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getTotalpremium() {
        return totalpremium;
    }

    public void setTotalpremium(String totalpremium) {
        this.totalpremium = totalpremium;
    }

    public String getParam24() {
        return param24;
    }

    public void setParam24(String param24) {
        this.param24 = param24;
    }
}
