package com.miaosha.user.mapper;

import com.miaosha.common.entity.UserInfo;

public interface UserMapper {
	 public UserInfo findUserByid(int userid);
	 public void saveUserInfo(UserInfo userinfo);
	 public UserInfo findUserByAccount(String account);
}
