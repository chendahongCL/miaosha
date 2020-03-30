package com.miaosha.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaosha.common.entity.ProductDetail;
import com.miaosha.product.mapper.ProductDetailMapper;

/**
 * Created by cdh on 2020/3/29.
 */
@Service
public class ProductDetailService {
    @Autowired
    private ProductDetailMapper productDetailMapper;

    public void saveProductDetail(ProductDetail productDetail){
        productDetailMapper.saveProductDetail(productDetail);
    }
}
