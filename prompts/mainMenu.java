package com.revature.prompts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;

import com.revature.beans.Person;


import com.revature.dao.PersonDao;
import com.revature.dao.PersonSerializer;

public class mainMenu   implements Prompt{

	
	
	@Override
	public Prompt run() {
		// TODO Auto-generated method stub
		
		/*
		 * Gets currently person logged
		 */
		
		PersonDao personDao = new PersonSerializer();
		Person customer =personDao.getCurrentlyLogged();
		//personDao.clearLoggedFile();
		System.out.println(customer);
		
		
		
		
		
		boolean exit=true;
		while(exit) {
		System.out.println("1: Make a deposit");
		System.out.println("2: Make a withdraw");
		System.out.println("3: View balance ");
		System.out.println("4: View all transaction");
		System.out.println("5: exit");

		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		switch (input) {
		case "1":
			  
			 customer.getAccnt().deposit( );
					 
			break;
		case "2":
			 
			  
			 customer.getAccnt().withdrawal();
			break;
		case "3":
			System.out.println("Your balance is :"+customer.getAccnt().getBalance());
			break;
		case "4":
			System.out.println("this are all the transactions ");
			customer.getAccnt().viewTransactionLog();
			break;
		case "5":
			System.out.println("Thanks for visiting Mega Bank  ");
			exit=false;
			System.exit(0);
			break;
		default:
			System.out.println("Invalid option");
			break;
		}
				
		}//end of while 
		return new Login();
	}
}	
		

	

