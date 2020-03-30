package com.miaosha.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaosha.common.entity.UserInfo;
import com.miaosha.common.form.UserRegisterForm;
import com.miaosha.common.utils.Md5Util;
import com.miaosha.user.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;

	public UserInfo findUserByid(int userid) {
		return userMapper.findUserByid(userid);
	}

	public void saveUserInfo(UserRegisterForm userRegisterForm) throws Exception {
		UserInfo userInfo = new UserInfo();
		userInfo.setAccount(userRegisterForm.getAccount());
		userInfo.setBirthday(userRegisterForm.getBirthday());
		userInfo.setTelphone(userRegisterForm.getTelphone());
		userInfo.setQq(userRegisterForm.getQq());
		userInfo.setWeixin(userRegisterForm.getWeinxin());
		String password = userRegisterForm.getPassword();
		userInfo.setOriginalPassword(password);
		userInfo.setEncryptionPassword(Md5Util.md5(password, Md5Util.md5key));
		userMapper.saveUserInfo(userInfo);
	}

	public boolean verifyUserAccount(UserRegisterForm userRegisterForm) throws Exception {
		String account = userRegisterForm.getAccount();
		String password = userRegisterForm.getPassword();
		UserInfo userInfo = userMapper.findUserByAccount(account);
		String encryptionPassword = userInfo.getEncryptionPassword();
		return Md5Util.verify(password, Md5Util.md5key, encryptionPassword);
	}

}
