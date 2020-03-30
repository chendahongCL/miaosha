package com.miaosha.shop.mapper;

import java.util.List;

import com.miaosha.common.entity.ShopInfo;
import com.miaosha.common.vo.ShopInfoVo;

/**
 * Created by li on 2019/2/23.
 */
public interface ShopMapper {
    public void saveShopInfo(ShopInfo shopInfo);
    List<ShopInfo> listShopInfoBy(ShopInfoVo shopInfoVo);
    public void updateInfoBy(ShopInfo shopInfo);
}
