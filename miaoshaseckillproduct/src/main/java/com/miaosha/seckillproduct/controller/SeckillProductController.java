package com.miaosha.seckillproduct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miaosha.common.entity.ProductInfo;
import com.miaosha.common.entity.SeckillProductInfo;
import com.miaosha.common.form.SeckillForm;
import com.miaosha.seckillproduct.feigninterface.ProductFeign;
import com.miaosha.seckillproduct.service.SeckillProductService;

@Controller
@RequestMapping(value = "seckKillProduct")
public class SeckillProductController {
	@Autowired
	private ProductFeign productFeign;

	@Autowired
	private SeckillProductService seckillProductService;

	@RequestMapping(value = "listShopProduct", method = RequestMethod.GET)
	public String listShopProduct(int shopId, Model model) {
		List<ProductInfo> list = productFeign.listProductby(shopId);
		model.addAttribute("list", list);
		return "listproduct";
	}

	@RequestMapping(value = "preSaveSeckillProduct", method = RequestMethod.GET)
	public String preSaveSeckillProduct(int id, Model model) {
		ProductInfo productInfo = productFeign.findProductById(id);
		model.addAttribute("productInfo", productInfo);
		return "preSaveSeckill";
	}

	@RequestMapping(value = "saveSeckillProduct", method = RequestMethod.POST)
	public String saveSeckillProduct(SeckillForm seckillForm, Model model) {
		seckillProductService.saveSeckillProduct(seckillForm);
		return "seckillSaveSuccess";
	}

	@RequestMapping(value = "listSeckillProductAll", method = RequestMethod.GET)
	public String listSeckillProductAll(int shopid, Model model) {
		SeckillForm seckillForm = new SeckillForm();
		seckillForm.setShopid(shopid);
		List<SeckillProductInfo> list = seckillProductService.listSeckillInfo(seckillForm);
		model.addAttribute("list", list);
		return "listSeckillProductInfo";
	}

	@RequestMapping(value = "updateState", method = RequestMethod.GET)
	public String updateState(int id, int state, Model model) {
		seckillProductService.updateSeckillInfoState(id, state);
		return "seckillUpdateSuccess";
	}

	@RequestMapping(value = "listSeckillProductByState", method = RequestMethod.GET)
	public String listSeckillProductByState(Model model) {
		SeckillForm seckillForm = new SeckillForm();
		seckillForm.setState(3);
		List<SeckillProductInfo> list = seckillProductService.listSeckillInfo(seckillForm);
		model.addAttribute("list", list);
		return "seckillPortal";
	}

}
