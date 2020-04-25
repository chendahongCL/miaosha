package com.miaosha.seckillproduct.mapper;

import java.util.List;

import com.miaosha.common.entity.SeckillProductInfo;
import com.miaosha.common.vo.SeckillProductInfoVo;

/**
 * Created by cdh on 2020/4/25.
 */
public interface SeckillProductMapper {
	public void saveSeckillProduct(SeckillProductInfo seckillProductInfo);

	List<SeckillProductInfo> listSeckillInfo(SeckillProductInfoVo seckillProductInfoVo);

	public void updateSeckillInfoState(SeckillProductInfo seckillProductInfo);

}
