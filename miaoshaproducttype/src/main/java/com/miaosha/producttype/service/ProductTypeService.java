package com.miaosha.producttype.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaosha.common.entity.ProductTypeInfo;
import com.miaosha.producttype.mapper.ProductTypeMapper;

/**
 * Created by li on 2019/2/2.
 */
@Service
public class ProductTypeService {
    @Autowired
    private ProductTypeMapper productTypeMapper;

    public void saveProductType(ProductTypeInfo productTypeInfo){
        productTypeMapper.saveProductType(productTypeInfo);
    }
}
