package com.home.PaymentGateWay_Design_LLD;

public class UserController {

	UserService userService;
	
	public UserDO addUser(UserDO userDO) {
		return userService.addUser(userDO);
	}
	
	public UserDO getUser(int userID) {
		return userService.getUser(userID);
	}
}
