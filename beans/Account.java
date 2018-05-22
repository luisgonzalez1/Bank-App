package com.revature.beans;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.revature.dao.AccountDao;
import com.revature.dao.AccountSerializer;

public class Account implements Serializable {
	
	
	private int accntNumber;
	private double balance;
	private double withdrawAmount;
	private double depositAmount;
	private String log;
    //private List<String> logs;
	
	
	
	
	//private List<String> logList =new ArrayList<String>();
//	Scanner scan = new Scanner(System.in);
//	String input ="";  
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
		
		AccountDao accntDao =new AccountSerializer();
		Account account =accntDao.FindByAccntNumber(this.accntNumber);
		this.balance=account.balance;
		return this.balance;
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
	/*
	 * adding log setter getter 
	 */
	
	public String getLog() {
		return log;
	}
	public void setLog(String log) {
		this.log = log;
	}
	
	public void deposit( ){
		AccountDao accntDao =new AccountSerializer();
		Account account =accntDao.FindByAccntNumber(this.accntNumber);
		this.balance=account.balance;
		Scanner scan = new Scanner(System.in);
		String input =""; 
		
		 System.out.println("How much would you like to deposit?");
		 input = scan.nextLine();
		 
		 
		 try {
			 this.depositAmount =Double.parseDouble(input);
		 }
		 
		 catch(NumberFormatException e) {
			 
			 System.out.println("This is not a number");
	         System.out.println(e.getMessage());
		 } 		 
		 
		if(this.depositAmount <=0d ) {
			
			System.out.println("incorrect amount ");
		
		}else {
			this.balance= this.balance+this.depositAmount;
			System.out.println("Your new balance is " + this.balance);
			
			this.addTransactionLog("deposit");
			account.balance=this.balance;
			accntDao.save(account);
		}
	
	} 
	
	/*
	 * if the balance >0 
	 * if the amount > balance  
	 * newBalance is equals to  balance - amount 
	 */
	public void withdrawal ( ) {
		AccountDao accntDao =new AccountSerializer();
		Account account =accntDao.FindByAccntNumber(this.accntNumber);
		this.balance=account.balance;
		
		Scanner scan = new Scanner(System.in);
		String input =""; 
		
		
		
		if (this.balance  >0 ) {
			
			System.out.println("How mush would you like to withdraw?");
			 input = scan.nextLine();
			 
			 ///////TEST INPUT FROM USER //////////
			  
					 try {
						 this.withdrawAmount = Double.parseDouble(input);
					 }
					 
					 catch(NumberFormatException e) {
						 
						 System.out.println("This is not a number");
				         System.out.println(e.getMessage());
					 }  
					   if (this.withdrawAmount <=0) {
									  
					   System.out.println("incorrect amount");
						}	 
					 
					   else if( this.withdrawAmount > this.balance  ) {
						  
						  System.out.println("insufficient balance");	
						   
						  
					  }else {
				  this.balance= this.balance-this.withdrawAmount;
				  System.out.println("Your remaining balance id "+ this.balance);
				  this.addTransactionLog("withdrawal");		
				  
				  account.balance=this.balance;
				  accntDao.save(account);
			  }		  
		}else {
			
			System.out.println("accnt doesn't have sufficient funds ");
			
		}
			
	}	
		 
	
	public void addTransactionLog (String type) {
		AccountDao accntDao =new AccountSerializer();
		 Date dNow = new Date( );
		  
		// String log;
	     SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
	     
			      if(type.equals("deposit")) {
		          
			      this.log=("Time: " + ft.format(dNow)+ " Deposit amount : "+this.depositAmount+" Remaining Balance :" + this.balance);
			      //logList.add(log);
			      
			      accntDao.saveLog(this.log,this.accntNumber );
			      }else if (type.equals("withdrawal")){
			    	  
			    	  this.log=("  Time: " + ft.format(dNow)+ " Withdrawal amount : -"+this.withdrawAmount+" Remaining Balance :" + this.balance);
			    	  //logList.add(log);
			    	  accntDao.saveLog(this.log,this.accntNumber);
			    	  
			    	  /*
			    	   * Here goes saving log into file
			    	   */
			    	  
			    	  
			    	  
			    	  
			      }else 
			    	  System.out.println("incorrect type entered , data not save in log ");
	      
	      
	}
		 
		public void viewTransactionLog () {
			AccountDao accntDao =new AccountSerializer();
			List<String> logs = new ArrayList<>();
			logs=accntDao.findAllLogs(this.accntNumber);
			if(logs.isEmpty()) {
				
				System.out.println("no transactions available  ");
			}else {
				for (String l:logs) {
					
					
					
					System.out.println(l);
					
				}
			}
		}
		
		
		 
	
	
	@Override
	public String toString() {
		return "Account [accntNumber=" + accntNumber + ", balance=" + balance + "]";
	}
	
	
	
	
	
	
	

}
