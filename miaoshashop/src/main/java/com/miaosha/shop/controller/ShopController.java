package com.miaosha.shop.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miaosha.common.entity.ShopInfo;
import com.miaosha.common.form.ShopApplyForm;
import com.miaosha.common.form.ShopSearchForm;
import com.miaosha.shop.service.ShopService;

import java.util.List;

/**
 * Created by cdh on 2020/3/29.
 */
@Controller
@RequestMapping("shop")
public class ShopController {
	@Autowired
	private ShopService shopService;

	/**
	 * 商家申请店铺
	 * 
	 * @return
	 */
	@RequestMapping(value = "toApplyShop", method = RequestMethod.GET)
	public String toApplyShop() {

		return "toApplyShop";
	}

	@RequestMapping(value = "applyShop", method = RequestMethod.POST)
	public String registerUser(ShopApplyForm shopApplyForm, Model model) {
		if (StringUtils.isBlank(shopApplyForm.getShopName())) {
			model.addAttribute("error", "店铺名称不能为空");
			return "toApplyShop";
		}
		if (StringUtils.isBlank(shopApplyForm.getShopBussinessScope())) {
			model.addAttribute("error", "店铺经营范围不能为空");
			return "toApplyShop";
		}
		if (StringUtils.isBlank(shopApplyForm.getBusinessLicense())) {
			model.addAttribute("error", "店铺营业执照不能为空");
			return "toApplyShop";
		}
		try {
			shopService.saveShopInfo(shopApplyForm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "viewMerchant";
	}

	/**
	 * 管理员查询页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "toSearchShop", method = RequestMethod.GET)
	public String toSearchShop() {

		return "toSearchShop";
	}

	/**
	 * 管理员查询所有的店铺
	 * 
	 * @return
	 */
	@RequestMapping(value = "searchShop", method = RequestMethod.POST)
	public String searchShop(ShopSearchForm shopSearchForm, Model model) {
		List<ShopInfo> listShop = shopService.listShopInfoBy(shopSearchForm);
		model.addAttribute("listShop", listShop);
		return "listShop";
	}

	/**
	 * 管理员更新商铺状态
	 * 
	 * @return
	 */
	@RequestMapping(value = "updateState", method = RequestMethod.GET)
	public String searchShop(int state, int id) {
		ShopInfo shopInfo = new ShopInfo();
		shopInfo.setId(id);
		shopInfo.setState(state);
		shopService.updateInfoBy(shopInfo);
		return "listShop";
	}

}
