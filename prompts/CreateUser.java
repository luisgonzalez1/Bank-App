package com.revature.prompts;

import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Person;
import com.revature.dao.PersonDao;
import com.revature.dao.PersonSerializer;

public class CreateUser implements Prompt {
	
	
		@Override
		public Prompt run() {
			
			PersonDao personDao = new PersonSerializer();
			List<Person> list = personDao.findAll();
			
			for (Person p : list) {
				
				System.out.println(p);
				System.out.println("accnt info" + p.getAccnt().toString());
			}
			 
			 
			
			
			Scanner scan =new Scanner(System.in);
			System.out.println("please add the following information");
			
			System.out.println("Please enter your name");
			String name = scan.nextLine();
			
			System.out.println("Please enter your Last Name");
			String lastName = scan.nextLine();
			
			System.out.println("Please enter your Username");
			String userName = scan.nextLine();
			
			System.out.println("Please enter your password");
			String passWord = scan.nextLine();
			
			System.out.println("How much will you start your accnt with");
			double amount = Double.parseDouble(scan.nextLine());
			boolean exitAmount=true;
			while(exitAmount) {
			if (amount <=0) {
				System.out.println("Please enter anoter amount ");
				System.out.println("How much will you start your accnt with");
				amount = Double.parseDouble(scan.nextLine());
				
			} else exitAmount=false;
		}
			
			int accntNumber = 6;
			accntNumber+=accntNumber;
					
			 
			Person customer = new Person(name, lastName, new Account(accntNumber,amount ), userName, passWord);
			
			
			
			try {
				personDao.save(customer);
				} catch (NumberFormatException e) {
				System.out.println("Invalid Input, try again");
				}


			System.out.println("new user added : "+ customer);
			
			
			
			
			return this;
		}
	
}

