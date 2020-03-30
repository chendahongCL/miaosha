package com.miaosha.shop.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaosha.common.entity.ShopInfo;
import com.miaosha.common.form.ShopApplyForm;
import com.miaosha.common.form.ShopSearchForm;
import com.miaosha.common.vo.ShopInfoCondition;
import com.miaosha.common.vo.ShopInfoVo;
import com.miaosha.shop.mapper.ShopMapper;

/**
 * Created by cdh on 2020/3/29.
 */
@Service
public class ShopService {
	@Autowired
	private ShopMapper shopMapper;

	public void saveShopInfo(ShopApplyForm shopApplyForm) {
		ShopInfo shopInfo = new ShopInfo();
		shopInfo.setMerchantid(shopApplyForm.getMerchantid());
		shopInfo.setProvince(shopApplyForm.getProvince());
		shopInfo.setCity(shopApplyForm.getCity());
		shopInfo.setBusinessLicense(shopApplyForm.getBusinessLicense());
		shopInfo.setShopName(shopApplyForm.getShopName());
		shopInfo.setShopDescription(shopApplyForm.getShopDescription());
		shopInfo.setShopBussinessScope(shopApplyForm.getShopBussinessScope());
		shopInfo.setState(0);
		shopInfo.setCreateTime(new Date());
		shopMapper.saveShopInfo(shopInfo);
	}

	public List<ShopInfo> listShopInfoBy(ShopSearchForm shopSearchForm) {

		ShopInfoVo shopInfoVo = new ShopInfoVo();
		ShopInfoCondition shopInfoCondition = new ShopInfoCondition();
		if (StringUtils.isNotBlank(shopSearchForm.getShopName())) {
			shopInfoCondition.setShopName(shopSearchForm.getShopName());
		}
		if (StringUtils.isNotBlank(shopSearchForm.getState())) {
			shopInfoCondition.setState(Integer.valueOf(shopSearchForm.getState().trim()));
		}
		shopInfoVo.setShopInfoCondition(shopInfoCondition);
		return shopMapper.listShopInfoBy(shopInfoVo);
	}

	public void updateInfoBy(ShopInfo shopInfo) {
		shopMapper.updateInfoBy(shopInfo);
	}

}
