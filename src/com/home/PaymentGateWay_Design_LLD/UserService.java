package com.home.PaymentGateWay_Design_LLD;

import java.util.*;

public class UserService {

	static List<User> userList = new ArrayList<>(); //static memory will act as a DB
	
	public UserDO addUser(UserDO userDO) {
		User user = new User();
		user.setUserName(userDO.getName());
		user.setUserid(userDO.getUserId());
		user.setEmail(userDO.getMail());
		
		userList.add(user);
		
		return userDO;
	}
	
	public UserDO getUser(int userId) {
		for(User u: userList) {
			if(u.getUserid() == userId) {
				UserDO udo = new UserDO();
				udo.setUserId(u.getUserid());
				udo.setName(u.getUserName());
				return udo;
			}
		}
		return null;
	}
}
