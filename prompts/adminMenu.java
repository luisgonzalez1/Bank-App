package com.revature.prompts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Person;
import com.revature.dao.PersonDao;
import com.revature.dao.PersonSerializer;

public class adminMenu implements Prompt {

	@Override
	public Prompt run() {
		
		
		PersonDao personDao = new PersonSerializer();
		Scanner scan = new Scanner(System.in); 
		Person admin =personDao.getCurrentlyLogged();
		List<Person> customers = new ArrayList<>();
		personDao.clearLoggedFile();
		customers = personDao.findAll();
		
		
		boolean exitAdmin=true;
		while(exitAdmin) {
		System.out.println("Welcome admin ");
		System.out.println("What would you like to do ");
		System.out.println("1: See all Users ");
		System.out.println("2: See all users transactions");
		System.out.println("3: exit ");
		
		String option =scan.nextLine();
		
		
		
			switch(option) {
			
			case "1":
				
				
				for (Person p: customers ) {
					
					 
					System.out.println(p);
					
				}
				
				
				break;
			case "2":
				
				for (Person p: customers ) {
					
					System.out.println(p.getName());
					System.out.println("=================================");
					System.out.println(p.getAccnt());
					System.out.println("=================================");
					p.getAccnt().viewTransactionLog();
					System.out.println("");
				}
				 
				
				break;
				
			case "3":
				System.out.println("Thanks for visiting Mega Bank");
				System.exit(0);
				exitAdmin=false;
				
				
				break;
			
			
				
			default:
				System.out.println("invalid option");
				
				break;
			
			}	
		}//end while
		
		
		 
		return this;
		
		
		
	}//end run

}//end
