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
		
		Account accnt = new Account(0001,100.00);
		Person customer = new Person("Carlos","Acevedo",102225445,accnt);
		boolean exit=true;
		while(exit) {
		System.out.println("1: Make a deposit");
		System.out.println("2: Make a withdraw");
		System.out.println("3: View Balance ");
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
			System.out.println("Thanks for visiting Wold Bank  ");
			exit=false;
			break;
		default:
			System.out.println("Invalid option");
			break;
		}
				
		}//end of while 
		return null;
	}
}	
//		PersonDao personDao = new PersonSerializer();
//		mainMenu main =new mainMenu();
//		
//		Account accnt1 = new Account(0001,100.00);
//		Account accnt2 = new Account(0002,10000.00);
//		Account accnt3 = new Account(0003,565284.00);
//		Account accnt4 = new Account(0004,50.00);
//		Account accnt5 = new Account(0005,9000.00);
//		Account accnt6 = new Account(0006,500000000.00);
//		 
//		
//		Person customer1 = new Person("Luis","Gonzalez",599441525,accnt1);
//		Person customer2 = new Person("Carlos","Acevedo",102225445,accnt2);
//		Person customer3 = new Person("Lois","Vuton",854859988,accnt3);
//		Person customer4 = new Person("Naruto","Uzumaki",141554848,accnt4);
//		Person customer5 = new Person("Sasuke","Uchiha",686558855,accnt5);
//		Person customer6 = new Person("Ligh","Yagami",225588485,accnt6);
//		
//		 
//		try {
//		personDao.save(customer1);
//		} catch (NumberFormatException e) {
//		System.out.println("Invalid Input, try again");
//		}
//		
//		List<Person> testFind = new ArrayList<>();  
//		System.out.println("primera lista ");
//		 for (Person l :testFind) {
//			 
//			 System.out.println(l);
//		 }
//		 testFind=personDao.findAll();
//		 System.out.println("segunda lista ");
//		 for (Person l :testFind) {
//			 
//			 System.out.println(l);
//		 }
//         
//		Person p = personDao.FindByAccntNumber(2);
//		System.out.println("the onject is "+p);
//
//		 
//		 
//		//main.Login(customer);
//			
			
			
		
		
		

		
		
		
		
		
		
		
		
		
	
//	public void Login(Person g) {
//		// TODO Auto-generated method stub
//		System.out.println("Please enter name");
//		Scanner scan = new Scanner(System.in);
//		String input = scan.nextLine();
//		if (input.equals(g.getName())) {
//			System.out.println("correct name");
//		}else {
//			
//			System.out.println("invalid name ");
//		}
//		
//		System.out.println("please enter social");
//		input = scan.nextLine();
//		if (input.equals(String.valueOf(g.getSsn()))) {
//			System.out.println("correct ssn");
//		}else {
//			
//			System.out.println("invalid ssn ");
//		}
//		
//		
	
	
	
	

