package com.revature.beans;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.revature.dao.AccountDao;
import com.revature.dao.AccountSerializer;
import com.revature.dao.PersonDao;
import com.revature.dao.PersonSerializer;

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
		 this.balance=accntDao.getBlance(this.accntNumber);
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
	
	
	public String getLog() {
		return log;
	}
	public void setLog(String log) {
		this.log = log;
	}
	/*
	 * Deposit
	 */
	
	public void deposit( ){

 		AccountDao accntDao =new AccountSerializer();
 		
 		/*
 		 * Gets Balance from file Balance.txt
 		 */

        this.balance=accntDao.getBlance(this.accntNumber);
	 
		Scanner scan = new Scanner(System.in);
		String input =""; 
		
		 System.out.println("How much would you like to deposit?");
		 input = scan.nextLine();
		 
		 /*
	 	  * Verifies Input
	 	 */
		 
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
			this.depositAmount = (Math.round(this.depositAmount*100.0)/100.0);
			this.balance = (Math.round(this.balance)*100.0/100.0);
			this.balance= this.balance+this.depositAmount ;
			
			accntDao.saveBalance(this.balance, this.accntNumber);
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
		 
		AccountDao accntDao =new AccountSerializer();
		this.balance=accntDao.getBlance(this.accntNumber);
		 
		 
		
		Scanner scan = new Scanner(System.in);
		String input =""; 
		
		
		
		if (this.balance  >0 ) {
			
			System.out.println("How mush would you like to withdraw?");
			 input = scan.nextLine();
			 
			 /*
		 	  * Verifies Input
		 	 */
			  
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
				  this.withdrawAmount = (Math.round(this.withdrawAmount)*100.0/100.0);
				  this.balance = (Math.round(this.balance)*100.0/100.0);
				  this.balance= this.balance-this.withdrawAmount;
				  
				  System.out.println("Your remaining balance id "+ this.balance);
				  accntDao.saveBalance(this.balance, this.accntNumber);
				  this.addTransactionLog("withdrawal");		
				  
				   
				   
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
			if(logs==null) {
				
				System.out.println("no transactions available  ");
			}else {
				for (String l:logs) {
					
					
					
					System.out.println(l);
					
				}
			}
		}
		
		
		 
	
	
	@Override
	public String toString() {
		AccountDao accntDao =new AccountSerializer();
		this.balance=accntDao.getBlance(this.accntNumber);
		return "Account [accntNumber=" + accntNumber + ", balance=" + this.balance + "]";
	}
	
	
	
	
	
	
	

}
