package com.uetcodecamp.vuvanhoc.objects;

public class User {
	private  int id ;
	private String name;
	private String email;
	private String phone;
	private int balance;

	public User(String name, String email, String phone, int balance) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.balance = balance;
	}

	public User() {

	}

	public int getId() {
		return id;
	}

	public  void setId(int id) {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}
