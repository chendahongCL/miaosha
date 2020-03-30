package com.miaosha.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaosha.common.entity.ProductInfo;
import com.miaosha.common.form.ProductForm;
import com.miaosha.common.vo.ProductInfoCondition;
import com.miaosha.common.vo.ProductInfoVo;
import com.miaosha.product.mapper.ProductInfoMapper;

import java.util.Date;
import java.util.List;

/**
 * Created by cdh on 2020/3/29.
 */
@Service
public class ProductInfoService {
    @Autowired
    private ProductInfoMapper productInfoMapper;

    public void saveProductInfo(ProductForm productForm){
        ProductInfo productInfo = new ProductInfo();
        Double productprice = Double.valueOf(productForm.getProductpriceParam());
        productInfo.setProductprice(productprice);
        productInfo.setProductname(productForm.getProductname());
        productInfo.setProducttitle(productForm.getProducttitle());
        productInfo.setMechantId(productForm.getMechantId());
        productInfo.setProductInventory(productForm.getProductInventory());
        productInfo.setProductdiscounts(productForm.getProductdiscounts());
        productInfo.setProductTypeid(productForm.getProductTypeid());
        productInfo.setProductpictureurl(productForm.getProductpictureurl());
        productInfo.setCreateTime(new Date());
        productInfo.setState(0);
        productInfoMapper.saveProductInfo(productInfo);
    }

    public List<ProductInfo> listProductInfo(int shopid){
        ProductInfoVo productInfoVo = new ProductInfoVo();
        if(shopid != -1){
            ProductInfoCondition productInfoCondition = new ProductInfoCondition();
            productInfoCondition.setShopId(shopid);
            productInfoCondition.setState(1);
            productInfoVo.setProductInfoCondition(productInfoCondition);
        }

        return productInfoMapper.listProductInfo(productInfoVo);
    }

    public void updateProductInfo(ProductInfo productInfo){
        productInfo.setUpdateTime(new Date());
        if(productInfo.getState()==1||productInfo.getState()==2){
            productInfo.setApproveTime(new Date());
        }
        productInfoMapper.updateProductInfo(productInfo);
    }


    public ProductInfo findProductById(int id){
        return productInfoMapper.findProductById(id);
    }
}
