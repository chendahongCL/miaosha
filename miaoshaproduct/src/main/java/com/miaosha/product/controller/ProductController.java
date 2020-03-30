package com.miaosha.product.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miaosha.common.entity.ProductInfo;
import com.miaosha.common.form.ProductForm;
import com.miaosha.product.service.ProductDetailService;
import com.miaosha.product.service.ProductInfoService;

import java.util.List;

/**
 * Created by cdh on 2020/3/29.
 */
@Controller
@RequestMapping("productControl")
public class ProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductDetailService productDetailService;

    @RequestMapping(value = "toApplyProduct",method = RequestMethod.GET)
    public String toApplyProduct(){

        return "toApplyProduct";
    }


    @RequestMapping(value = "applyProduct",method = RequestMethod.POST)
    public String applyProduct(ProductForm productForm, Model model){
        if(StringUtils.isBlank(productForm.getProductname())){
            model.addAttribute("error","商品名称不能为空");
            return "toRegisterUser";
        }
        if(StringUtils.isBlank(productForm.getProducttitle())){
            model.addAttribute("error","商品标题不能为空");
            return "toRegisterUser";
        }
        if(StringUtils.isBlank(productForm.getProductpriceParam())){
            model.addAttribute("error","商品价格不能为空");
            return "toRegisterUser";
        }
        try {
            productInfoService.saveProductInfo(productForm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "viewUser";
    }


    @RequestMapping(value = "listProduct",method = RequestMethod.GET)
    public String listProduct(Model model){
        try {
            List<ProductInfo> list = productInfoService.listProductInfo(-1);
            model.addAttribute("list",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "listproduct";
    }

    @RequestMapping(value = "updateState",method = RequestMethod.GET)
    public String updateState(int id ,int state,Model model){
        try {
            ProductInfo productInfo =  new ProductInfo();
            productInfo.setId(id);
            productInfo.setState(state);
            productInfoService.updateProductInfo(productInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "listproduct";
    }
}
