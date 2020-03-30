package com.miaosha.product.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.miaosha.common.entity.ProductInfo;
import com.miaosha.product.service.ProductInfoService;

import java.util.List;

/**
 * Created by cdh on 2020/3/29.
 */
@RestController
@RequestMapping("productOutControl")
public class ProductOutController {

    @Autowired
    private ProductInfoService productInfoService;



    @RequestMapping(value = "listProductby",method = RequestMethod.POST)
    public List<ProductInfo> listProductby(int shopid,Model model){

            List<ProductInfo> list = productInfoService.listProductInfo(shopid);
            return list;
    }

    @RequestMapping(value = "findProductById",method = RequestMethod.POST)
    public ProductInfo findProductById(int id,Model model){

        ProductInfo productInfo = productInfoService.findProductById(id);
        return productInfo;
    }
}
