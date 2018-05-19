package com.revature.beans;

import java.util.Scanner;

public class Account {
	
	
	private int accntNumber;
	private double balance;
	private double withdrawAmount;
	private double depositAmount;
	Scanner scan = new Scanner(System.in);
		String input ="";  
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
	public double getWithdrawAmount() {
		return withdrawAmount;
	}
	public void setWithdrawAmount(double withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}
	public double getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}
	
	public void deposit( ){
		
		 System.out.println("How mush would you like to deposit?");
		 input = scan.nextLine();
		 this.depositAmount =Double.parseDouble(input);
		 
		if(this.depositAmount <=0d ) {
			
			System.out.println("incorrect amount ");
		
		}else {
			this.balance= this.balance+this.depositAmount;
			System.out.println("Your new balance is " + this.balance);
		}
	
	} 
	/*
	 * if the balance >0 
	 * if the amount > balance  
	 * newBalance is equals to  balance - amount 
	 */
	public void withdrawal ( ) {
		
		if (this.balance  >0 ) {
			
			System.out.println("How mush would you like to withdraw?");
			 input = scan.nextLine();
			 this.withdrawAmount = Double.parseDouble(input);
			
			  if ( this.withdrawAmount > this.balance ) {
				  
				  System.out.println("not sufficient  balance");	
				   
				  
			  }else {
				  this.balance= this.balance-this.withdrawAmount;
				  System.out.println("Your remaining balance id "+ this.balance);
				  
			  }
		  
		}else {
			
			System.out.println("accnt doesn't have sufficient funds ");
			
		}
			
	}	
		 
	
	public void transactionLog () {
		
		
		
	}
		 
		
		
	
	
	@Override
	public String toString() {
		return "Account [accntNumber=" + accntNumber + ", balance=" + balance + "]";
	}
	
	
	
	
	
	
	

}
