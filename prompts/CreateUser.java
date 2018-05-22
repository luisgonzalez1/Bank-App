package com.revature.prompts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Person;
import com.revature.dao.AccountDao;
import com.revature.dao.AccountSerializer;
import com.revature.dao.PersonDao;
import com.revature.dao.PersonSerializer;

public class CreateUser implements Prompt   {
	
	
		@Override
		public Prompt run() {
//			setAccntNumberFile();
//			System.out.println("number saved on file");
			PersonDao personDao = new PersonSerializer();
			AccountDao accntDao =new AccountSerializer();
			
			

		List<Person> list = personDao.findAll();
			double amount=0;
			String userName="";
			
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
			
			
			
			/*
			 * verifies if the user name is already on file 
			 */
			
			boolean exitUsername=true;
			while(exitUsername) {
			System.out.println("Please enter your Username");
			 userName = scan.nextLine();
			
			if(personDao.userNameExist(userName))
			{
				System.out.println("Sorry that user name has already been taken");
				System.out.println("Please try a different user");
			}else exitUsername=false;
			}
			System.out.println("Please enter your password");
			String passWord = scan.nextLine();
			
			/*
			 * Input validation
			 */
			
			boolean exitAmount=true;
			while(exitAmount) {
			System.out.println("How much will you start your accnt with");


			
			try {
				 amount = Double.parseDouble(scan.nextLine());
			 }
			 
			 catch(NumberFormatException e) {
				 
				 System.out.println("This is not a number");
		         System.out.println(e.getMessage());
			 }  
			
			
			if (amount <=0) {
				System.out.println("amount not valid ");
				System.out.println("Please try a different amount");
				 
			} else exitAmount=false;
				
				
				
			 
		}
			
			/*
			 * Reads number from file and asing as accnt number
			 */
			 
			int accntNumber = getAccntNumberFromFile();
			accntNumber+=1;
			setAccntNumberFile(accntNumber);
			 
			
			amount=(Math.round(amount)*100.0/100.0);
					
			Account accnt = new Account(accntNumber,amount );
			Person customer = new Person(name, lastName, accnt, userName, passWord);
			
			
			
			 
				personDao.save(customer);
				accntDao.saveBalance(amount ,customer.getAccnt().getAccntNumber() );

          ///////new user has been added  ////// 
			System.out.println("new user added : "+ customer);
			
			 
			
			
			boolean continueOrExit = true;
			while(continueOrExit) {
				
				System.out.println("Your accnt has been created");
				System.out.println("What would you like to do");
				System.out.println("1: Manage accnt");
				System.out.println("2: exit accnt");
				String input=  scan.nextLine();
				switch (input){
					
				case "1":
					
					personDao.setCurrentlyLogged(customer);
					
					return new mainMenu();
					
					//break;
				case "2":
					System.out.println("Thanks for using our bank");
					continueOrExit=false;
					System.exit(0);
					break;
				
				default:
				System.out.println("Invalid option");
				
				break;
				
				}
			}// end while
			
			
			
			
			return this;
	}// end run 
		
		public void setAccntNumberFile (int number) {
			
			
			try(ObjectOutputStream outStream  = new ObjectOutputStream(new FileOutputStream("number.txt"))) {
				 
				 
				outStream.writeInt(number); 
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			
			 
		}
		
		
		public int getAccntNumberFromFile() {
			
			try(ObjectInputStream  inStream= new ObjectInputStream(new FileInputStream("number.txt"))) {
				
				return inStream.readInt() ;
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
			return 0;
			//return null;
		}
	
}// end

