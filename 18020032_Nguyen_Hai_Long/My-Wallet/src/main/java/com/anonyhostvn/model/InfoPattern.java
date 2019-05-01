package com.anonyhostvn.model;

public class InfoPattern {
	private int ID ; 
	private String name ; 
	private String email ; 
	private String phone ; 
	private int balance ;
	private boolean status ;
	private String password ; 
	
	public InfoPattern (int ID , String name , String email , String phone , int balance , boolean status) {
		this.ID = ID ; 
		this.name = name; 
		this.email = email ; 
		this.phone = phone ; 
		this.balance = balance ; 
		this.status = status ; 
		
		this.password = "123456" ; 
	}
	
	public boolean Submoney (int money) {
		if (this.balance < money) return false ; 
		this.balance -= money ; 
		return true ; 
	}
	
	public boolean PlusMoney (int money) {
		this.balance += money ; 
		return true ;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	} 
}

