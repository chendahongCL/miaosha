package com.miaosha.seckillproduct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaosha.common.entity.ProductInfo;
import com.miaosha.common.entity.SeckillProductInfo;
import com.miaosha.common.form.SeckillForm;
import com.miaosha.common.utils.DateUtils;
import com.miaosha.common.vo.SeckillProductInfoCondition;
import com.miaosha.common.vo.SeckillProductInfoVo;
import com.miaosha.seckillproduct.feigninterface.ProductFeign;
import com.miaosha.seckillproduct.mapper.SeckillProductMapper;

import java.util.Date;
import java.util.List;

/**
 * Created by cdh on 2020/4/25.
 */
@Service
public class SeckillProductService {
	@Autowired
	private SeckillProductMapper seckillProductMapper;
	@Autowired
	private ProductFeign productFeign;

	public void saveSeckillProduct(SeckillForm seckillForm) {
		SeckillProductInfo seckillProductInfo = new SeckillProductInfo();
		if (seckillForm != null) {
			seckillProductInfo.setProductid(seckillForm.getProductid());
			seckillProductInfo.setSeckillnum(0);
			seckillProductInfo.setSeckillprice(seckillForm.getSeckillPrice());
			ProductInfo productInfo = productFeign.findProductById(seckillForm.getProductid());
			seckillProductInfo.setSeckillInventory(productInfo.getProductInventory());
			seckillProductInfo.setCreatetime(new Date());
			String formatString = "yyyy-MM-dd hh:mm:ss";
			Date startTime = DateUtils.tranferTimeBy(seckillForm.getStartTime(), formatString);
			Date endTime = DateUtils.tranferTimeBy(seckillForm.getEndTime(), formatString);
			seckillProductInfo.setStarttime(startTime);
			seckillProductInfo.setEndtime(endTime);
			seckillProductInfo.setShopid(productInfo.getShopId());
			seckillProductInfo.setState(0);
			seckillProductInfo.setProductName(seckillForm.getProductName());
			seckillProductInfo.setProductTitle(seckillForm.getProductTitle());
			seckillProductInfo.setProductprice(seckillForm.getProductPrice());
		}
		seckillProductMapper.saveSeckillProduct(seckillProductInfo);
	}

	public List<SeckillProductInfo> listSeckillInfo(SeckillForm seckillForm) {
		SeckillProductInfoVo seckillProductInfoVo = new SeckillProductInfoVo();//
		if (seckillForm != null) {
			// 加上条件
			SeckillProductInfoCondition seckillProductInfoCondition = new SeckillProductInfoCondition();
			if (seckillForm.getShopid() != -1) {
				seckillProductInfoCondition.setShopid(seckillForm.getShopid());
			}
			if (seckillForm.getState() != -1) {
				seckillProductInfoCondition.setState(seckillForm.getState());
			}
			seckillProductInfoVo.setSeckillProductInfoCondition(seckillProductInfoCondition);
		}

		return seckillProductMapper.listSeckillInfo(seckillProductInfoVo);
	}

	public void updateSeckillInfoState(int id, int state) {
		SeckillProductInfo seckillProductInfo = new SeckillProductInfo();
		seckillProductInfo.setId(id);
		seckillProductInfo.setState(state);
		if (state == 1 || state == 2) {
			seckillProductInfo.setApproveTime(new Date());
		}
		seckillProductMapper.updateSeckillInfoState(seckillProductInfo);
	}

}
