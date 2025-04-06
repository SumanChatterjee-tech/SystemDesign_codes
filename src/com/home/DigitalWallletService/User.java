package com.home.DigitalWallletService;

import java.util.ArrayList;
import java.util.List;

public class User {

	String id;
	String name;
	String email;
	String enycpPwd;
	List<Account> accs;
	List<PaymentMethod> payMethod;
	public User(String id, String name, String email, String enycpPwd, List<Account> accs) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.enycpPwd = enycpPwd;
		this.accs = accs;
		this.payMethod = new ArrayList<>();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEnycpPwd() {
		return enycpPwd;
	}
	public void setEnycpPwd(String enycpPwd) {
		this.enycpPwd = enycpPwd;
	}
	public List<Account> getAccs() {
		return accs;
	}
	public void setAccs(List<Account> accs) {
		this.accs = accs;
	}
	public List<PaymentMethod> getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(List<PaymentMethod> payMethod) {
		this.payMethod = payMethod;
	}
}
