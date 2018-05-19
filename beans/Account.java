package com.revature.beans;

public class Account {
	
	
	private int accntNumber;
	private double balance;
	public Account(int accntNumber, double d) {
		super();
		this.accntNumber = accntNumber;
		this.balance = d;
	}
	public int getAccntNumber() {
		return accntNumber;
	}
	public void setAccntNumber(int accntNumber) {
		this.accntNumber = accntNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double amount){
		
		if(amount <=0d ) {
			
			System.out.println("incorrect amount ");
		
	}else {
		this.balance= this.balance+amount;
		
	}
	
	 
	/*
	 * if the balance >0 
	 * if the amount > balance  
	 * newBalance is equals to  balance - amount 
	 */
	public void withdrawal (double amount) {
		
		if (balance >0 ) {
			
			  if ( amount > balance ) {
				  
				  this.balance= this.balance-amount;
				  System.out.println("Your remaining balance id "+ this.balance);
				   
				  
			  }else {
				  
				  System.out.println("not sufficient  balance");
			  }
		  
		}else {
			
			System.out.println("accnt doesn have balance ");
			
		}
			
	}	
		 
		
		
		 
		
		
	
	
	@Override
	public String toString() {
		return "Account [accntNumber=" + accntNumber + ", balance=" + balance + "]";
	}
	
	
	
	
	
	
	

}
