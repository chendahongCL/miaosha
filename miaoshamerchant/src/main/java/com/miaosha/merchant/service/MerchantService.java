package com.miaosha.merchant.service;

import com.miaosha.common.entity.MerchantInfo;
import com.miaosha.common.form.MerchantCheckInForm;
import com.miaosha.common.utils.Md5Util;
import com.miaosha.merchant.mapper.MerchantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by li on 2019/2/2.
 */
@Service
public class MerchantService {
	@Autowired
	private MerchantMapper merchantMapper;
    public MerchantInfo findMerchantByid(int merchantid){
        return merchantMapper.findMerchantInfoByid(merchantid);
    }

    public void saveMerchantInfo(MerchantCheckInForm merchantCheckInForm) throws Exception {
        MerchantInfo merchantinfo = new MerchantInfo();
        merchantinfo.setCreatetime(new Date());
        merchantinfo.setAccount(merchantCheckInForm.getAccount());
        merchantinfo.setTelphone(merchantCheckInForm.getTelphone());
        merchantinfo.setAddress(merchantCheckInForm.getAddress());
        merchantinfo.setCity(merchantCheckInForm.getCity());
        merchantinfo.setProvince(merchantCheckInForm.getProvince());
        merchantinfo.setName(merchantCheckInForm.getName());
        String password = merchantCheckInForm.getPassword();
        merchantinfo.setOriginalPassword(password);
        merchantinfo.setEncryptionPassword(Md5Util.md5(password,Md5Util.md5key));
        merchantMapper.saveMerchantInfo(merchantinfo);
    }

    public boolean verifyMerchantAccount(MerchantCheckInForm merchantCheckInForm) throws Exception {
        String account = merchantCheckInForm.getAccount();
        String password = merchantCheckInForm.getPassword();
        MerchantInfo merchantInfo = merchantMapper.findMerchantInfoAccount(merchantCheckInForm.getAccount());
        if(merchantInfo ==null){
            return false;
        }
        String encryptionPassword = merchantInfo.getEncryptionPassword();
        return Md5Util.verify(password,Md5Util.md5key,encryptionPassword);
    }
}
