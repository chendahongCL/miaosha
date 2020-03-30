package com.miaosha.product.mapper;


import java.util.List;

import com.miaosha.common.entity.ProductInfo;
import com.miaosha.common.vo.ProductInfoVo;

/**
 * Created by cdh on 2020/3/29.
 */
public interface ProductInfoMapper {
    public void saveProductInfo(ProductInfo productInfo);
    List<ProductInfo> listProductInfo(ProductInfoVo productInfoVo);
    void updateProductInfo(ProductInfo productInfo);
    public ProductInfo findProductById(int id);
}
