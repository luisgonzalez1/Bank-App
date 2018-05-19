package com.revature.prompts;

import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Person;

public class mainMenu {

	public static void main(String[] args) {
		
		
		mainMenu main =new mainMenu();
		
		Account accnt = new Account(1111,100.00);
		
		Person customer = new Person("Luis","Gonzalez",599441525,accnt);
		
		 
		main.Login(customer);
			
			
			
		
		
		
		
		boolean exit=true;
		while(exit) {
		System.out.println("Enter 1 to checkout a book");
		System.out.println("Enter 2 to return a book");
		System.out.println("Enter 3 to see a list of all books");
		System.out.println("Enter 4 to search for books by title");
		System.out.println("Enter 5 to exit");

		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		switch (input) {
		case "1":
			 System.out.println("this is the first case ");
			break;
		case "2":
			System.out.println("this is the second case ");
			break;
		case "3":
			System.out.println("this is the third case ");
			break;
		case "4":
			System.out.println("this is the fouth case ");
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

		
		
		
		
		
		
		
		
		
	}
	public void Login(Person g) {
		// TODO Auto-generated method stub
		System.out.println("Please enter name");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		if (input.equals(g.getName())) {
			System.out.println("correct name");
		}else {
			
			System.out.println("invalid name ");
		}
		
		System.out.println("please enter social");
		input = scan.nextLine();
		if (input.equals(String.valueOf(g.getSsn()))) {
			System.out.println("correct ssn");
		}else {
			
			System.out.println("invalid name ");
		}
		
		
	}
	
	
}
