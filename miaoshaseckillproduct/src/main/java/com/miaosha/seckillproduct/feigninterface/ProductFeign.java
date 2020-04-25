package com.miaosha.seckillproduct.feigninterface;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.miaosha.common.entity.ProductInfo;

@FeignClient(value = "miaosha-product")
public interface ProductFeign {
	  @RequestMapping(value = "/productOut/listProductby",method = RequestMethod.POST)
	    public List<ProductInfo> listProductby(@RequestParam(value = "shopid") int shopid);

	    @RequestMapping(value = "/productOut/findProductById",method = RequestMethod.POST)
	    public ProductInfo findProductById(@RequestParam(value = "id") int id);

}
