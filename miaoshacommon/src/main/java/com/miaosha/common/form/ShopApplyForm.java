package com.miaosha.common.form;

/**
 * Created by cdh on 2020/3/29.
 */
public class ShopApplyForm {
    private int merchantid;
    private String shopName;
    private String shopDescription;
    private String shopBussinessScope;
    private String province;
    private String city;
    private String businessLicense;

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
}
