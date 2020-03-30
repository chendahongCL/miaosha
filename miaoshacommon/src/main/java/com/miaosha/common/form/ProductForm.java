package com.miaosha.common.form;

import com.miaosha.common.entity.ProductInfo;

/**
 * Created by cdh on 2020/3/20.
 */
public class ProductForm extends ProductInfo {
    private String productpriceParam;//原价


    public String getProductpriceParam() {
        return productpriceParam;
    }

    public void setProductpriceParam(String productpriceParam) {
        this.productpriceParam = productpriceParam;
    }
}
