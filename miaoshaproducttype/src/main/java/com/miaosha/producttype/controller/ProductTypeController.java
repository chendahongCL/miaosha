package com.miaosha.producttype.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miaosha.common.entity.ProductTypeInfo;
import com.miaosha.producttype.service.ProductTypeService;

/**
 * Created by cdh on 2020/3/29.
 */
@Controller
@RequestMapping("productType")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @RequestMapping(value = "toAddProductTypeInfo",method = RequestMethod.GET)
    public String toAddProductTypeInfo(){

        return "toAddProductTypeInfo";
    }


    @RequestMapping(value = "addProductTypeInfo",method = RequestMethod.POST)
    public String addProductTypeInfo(ProductTypeInfo productTypeInfo, Model model){
        if(StringUtils.isBlank(productTypeInfo.getProducttypeName())){
            model.addAttribute("error","商品类别名称不能为空");
            return "toAddProductTypeInfo";
        }
        try {
            productTypeService.saveProductType(productTypeInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "AddProductTypeInfoSuccess";
    }





}
