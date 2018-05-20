package com.revature.beans;

import java.io.Serializable;

public class Person implements Serializable {
	
	
	private   String name;
	private   String lastname;
	private   Account accnt;
	private   String userName;
	private   String passWord;
	
	
	
	
	
	
	
	 

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String name, String lastname, int ssn) {
		super();
		this.name = name;
		this.lastname = lastname;
		 
	}
	
	public void setAccnt(Account accnt) {
		this.accnt = accnt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	 	
	public Account getAccnt() {
		return accnt;
	}
	public Person(String name, String lastname, int ssn, Account accnt) {
		super();
		this.name = name;
		this.lastname = lastname;		 
		this.accnt = accnt;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", lastname=" + lastname +", accnt=" + this.accnt.getAccntNumber() + "]";
	}
	
	

}
