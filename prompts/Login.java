package com.revature.prompts;

import java.util.Scanner;

import com.revature.beans.Account;

import com.revature.beans.Person;
import com.revature.dao.PersonDao;
import com.revature.dao.PersonSerializer;

public class Login implements Prompt {

 
	
	@Override
	public Prompt run() { 
		PersonDao personDao = new PersonSerializer();
//		Account accnt1 = new Account(0001,100.00);
//		Person admin = new Person("Admin", "Admin", accnt1, "Admin", "1234");
		
		
		 
//		try {
//		personDao.save(admin);
//		} catch (NumberFormatException e) {
//		System.out.println("Invalid Input, try again");
//		}
//		
//		System.out.println(admin);
		//Account accnt = new Account(0001,100.00);
		//Person customer = new Person("Carlos","Acevedo",accnt);
		
		//personDao.currentLoggedPerson();
		//System.out.println("Presiona cualquire para pasar al main menu ");
		Scanner scan = new Scanner(System.in);
		//String input = scan.nextLine();
		// TODO Auto-generated method stub
		System.out.println("i'm in loggin");
		
		boolean exit=true;
		while(exit) {
		System.out.println("Welcome to the bank");
		System.out.println("What would you like to do  ");
		System.out.println("1: Register ");
		System.out.println("2: Login");
		System.out.println("3: exit");

		 scan = new Scanner(System.in);
		String input = scan.nextLine();
		switch (input) {
		case "1":
			
			return new CreateUser();
			
			//break;
		
		
		case "2":
		
		 ////////////////////////////////////////
		boolean correct=true;
		while(correct) {
		System.out.println("Please enter Username ");
		
		String userName = scan.nextLine();
		
		System.out.println("Please enter Password ");
		
	    String Password = scan.nextLine();
	    
	     
	     if(personDao.FindByUserAndPass(userName, Password)) {
	    	 
	    	 System.out.println("user found");
	    	 
	    	 Person loggedUser=personDao.getByUserAndPass(userName, Password);
	    	 
	    	personDao.setCurrentlyLogged(loggedUser);
	    	 
	    	 correct=false;
	    	 return new mainMenu() ;
	     }else 
	    	 System.out.println("not found try again");
	     }
		
		break;
		
		case "3":
			
			System.out.println("Thaks for visiting our bank");
			exit=false;
		
		
		default:
		System.out.println("Invalid option");
		break;
		
		}//end switch
		
		}//end while
		return new mainMenu() ;
	}

}
