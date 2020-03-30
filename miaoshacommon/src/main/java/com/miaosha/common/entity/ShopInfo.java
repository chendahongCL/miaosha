package com.miaosha.common.entity;

import java.util.Date;

/**
 * Created by cdh on 2020/3/29 .
 */
public class ShopInfo {

    private int id;
    private int merchantid;
    private String shopName;
    private String shopDescription;
    private String shopBussinessScope;
    private String province;
    private String city;
    private String businessLicense;
    private Date createTime;
    private int state;//0申请中 1申请通过 2退回 3商铺下架

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(int merchantid) {
        this.merchantid = merchantid;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopDescription() {
        return shopDescription;
    }

    public void setShopDescription(String shopDescription) {
        this.shopDescription = shopDescription;
    }

    public String getShopBussinessScope() {
        return shopBussinessScope;
    }

    public void setShopBussinessScope(String shopBussinessScope) {
        this.shopBussinessScope = shopBussinessScope;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
