package com.miaosha.merchant.mapper;

import com.miaosha.common.entity.MerchantInfo;

/**
 * Created by cdh on 2020/3/29.
 */
public interface MerchantMapper {
    public MerchantInfo findMerchantInfoByid(int merchantid);
    public void saveMerchantInfo(MerchantInfo merchantfo);
    public MerchantInfo findMerchantInfoAccount(String account);
}
