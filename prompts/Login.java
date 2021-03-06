package com.revature.prompts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;

import com.revature.beans.Person;
import com.revature.dao.AccountDao;
import com.revature.dao.AccountSerializer;
import com.revature.dao.PersonDao;
import com.revature.dao.PersonSerializer;

public class Login implements Prompt {

 
	
	@Override
	public Prompt run() { 
		PersonDao personDao = new PersonSerializer();		 
		Scanner scan = new Scanner(System.in);
		
		
		/*
		 * Displaying Customers list for testing 
		 */
		List<Person> customers =new ArrayList<Person>(); 	 
	    customers = personDao.findAll();
	    AccountDao accntDao =new AccountSerializer();
	    for(Person p:customers) {
		
		System.out.println(p);
		}
	    /*
		 * over writing admin user
		 */
		 //accntDao.saveLog("Administrator no transaction to view",0);
		//accntDao.saveBalance(0, 0);
	    
		boolean exit=true;
		while(exit) {
		System.out.println("Welcome to the Mega Bank");
		System.out.println("What would you like to do  ");
		System.out.println("1: Register ");
		System.out.println("2: Login");
		System.out.println("3: Exit");

		scan = new Scanner(System.in);
		String input = scan.nextLine();
		switch (input) {
		case "1":
			 /*
			 * redirects to CreatUser Prompt
			 */
			return new CreateUser();
			
			//break;
		
		
		case "2":
		
			/*
			 * login
			 */
		boolean correct=true;
		while(correct) {
		System.out.println("Please enter Username ");
		
		String userName = scan.nextLine();
		
		System.out.println("Please enter Password ");
		
	    String Password = scan.nextLine();
	    
	    /*
		 * Verifies that user exist
		 */
	     if(personDao.FindByUserAndPass(userName, Password)) {
	    	 
	    	 System.out.println("user found");
	    	 
	    	 Person loggedUser=personDao.getByUserAndPass(userName, Password);
	    	 
	    	 /*
			  * Saves Logged user in txt CurrentlyLogged.txt 
			  */
	    	 
	    	 personDao.setCurrentlyLogged(loggedUser);
	    	 
	    	 correct=false;
	    	 /*
	    	  * verifies if the user retrieved is an Admin 
	    	  */ 
	    	 if(loggedUser.getUserName().equals("Admin")){
	    		  
	    		   		  
	    		  return new adminMenu();
	    	  }
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	    	
	    	 return new mainMenu() ;
	     }else 
	    	 System.out.println("not found try again");
	     }
		
		break;
		
		case "3":
			
			System.out.println("Thanks for visiting Mega Bank");
			exit=false;
		    System.exit(0);
		
		default:
		System.out.println("Invalid option");
		break;
		
		}//end switch
		
		}//end while
		return new mainMenu() ;
	}

}
