package com.revature.beans;

import java.io.Serializable;

public class Person implements Serializable {
	
	
	private   String name;
	private   String lastname;
	private   int ssn;
	private   Account accnt;
	
	
	
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String name, String lastname, int ssn) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.ssn = ssn;
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
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	
	public Account getAccnt() {
		return accnt;
	}
	public Person(String name, String lastname, int ssn, Account accnt) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.ssn = ssn;
		this.accnt = accnt;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", lastname=" + lastname + ", ssn=" + ssn + ", accnt=" + this.accnt.getAccntNumber() + "]";
	}
	
	

}
