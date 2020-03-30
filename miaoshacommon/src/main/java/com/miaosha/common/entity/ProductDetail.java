package com.miaosha.common.entity;

/**
 * Created by cdh on 2020/3/29.
 */
public class ProductDetail {
    private int id;
    private int productid;
    private String productpalce;
    private String productbrand;
    private String productdecsrption;
    private String productWeight;
    private String productdetailPcitureUrl;
    private String specificationAndPack;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductpalce() {
        return productpalce;
    }

    public void setProductpalce(String productpalce) {
        this.productpalce = productpalce;
    }

    public String getProductbrand() {
        return productbrand;
    }

    public void setProductbrand(String productbrand) {
        this.productbrand = productbrand;
    }

    public String getProductdecsrption() {
        return productdecsrption;
    }

    public void setProductdecsrption(String productdecsrption) {
        this.productdecsrption = productdecsrption;
    }

    public String getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(String productWeight) {
        this.productWeight = productWeight;
    }

    public String getProductdetailPcitureUrl() {
        return productdetailPcitureUrl;
    }

    public void setProductdetailPcitureUrl(String productdetailPcitureUrl) {
        this.productdetailPcitureUrl = productdetailPcitureUrl;
    }

    public String getSpecificationAndPack() {
        return specificationAndPack;
    }

    public void setSpecificationAndPack(String specificationAndPack) {
        this.specificationAndPack = specificationAndPack;
    }
}
