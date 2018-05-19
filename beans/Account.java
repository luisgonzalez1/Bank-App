package com.revature.beans;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Account {
	
	
	private int accntNumber;
	private double balance;
	private double withdrawAmount;
	private double depositAmount;
	
	
	
	
	private List<String> logList =new ArrayList<String>();
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
		
		 System.out.println("How much would you like to deposit?");
		 input = scan.nextLine();
		 this.depositAmount =Double.parseDouble(input);
		 
		if(this.depositAmount <=0d ) {
			
			System.out.println("incorrect amount ");
		
		}else {
			this.balance= this.balance+this.depositAmount;
			System.out.println("Your new balance is " + this.balance);
			this.addTransactionLog("deposit");
			
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
				  
				  System.out.println("insufficient balance");	
				   
				  
			  }else {
				  this.balance= this.balance-this.withdrawAmount;
				  System.out.println("Your remaining balance id "+ this.balance);
				  this.addTransactionLog("withdrawal");
				  
			  }
		  
		}else {
			
			System.out.println("accnt doesn't have sufficient funds ");
			
		}
			
	}	
		 
	
	public void addTransactionLog (String type) {
		
		 Date dNow = new Date( );
		  
		 String log;
	     SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
	     
			      if(type.equals("deposit")) {
		          
			      log=("Time: " + ft.format(dNow)+ " Deposit amount : "+this.depositAmount+" Remaining Balance :" + this.balance);
			      logList.add(log);
			      
			      }else if (type.equals("withdrawal")){
			    	  
			    	  log=("Time: " + ft.format(dNow)+ " Withdrawal amount : -"+this.withdrawAmount+" Remaining Balance :" + this.balance);
			    	  logList.add(log);
			      }else 
			    	  System.out.println("incorrect type entered , data not save in log ");
	      
	      
	}
		 
		public void viewTransactionLog () {
			
			if(this.logList.isEmpty()) {
				
				System.out.println("no transactions available  ");
			}else {
				for (String l:this.logList) {
					
					System.out.println(l);
				}
			}
		}
		
		
		 
	
	
	@Override
	public String toString() {
		return "Account [accntNumber=" + accntNumber + ", balance=" + balance + "]";
	}
	
	
	
	
	
	
	

}
