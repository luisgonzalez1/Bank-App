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
		
		System.out.println("Welcome admin "+ admin.getName()  );
		System.out.println("What would you like to do ");
		System.out.println("1: See all Users ");
		System.out.println("2: exit ");
		
		String option =scan.nextLine();
		boolean exitAdmin=true;
		
		while(exitAdmin) {
			switch(option) {
			
			case "1":
				
				
				for (Person p: customers ) {
					
					System.out.println(p);
					
				}
				
				
				break;
			case "2":
				 
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
