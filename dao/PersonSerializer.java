package com.revature.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
 
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Person;

public class PersonSerializer implements PersonDao  {

	@Override
	public boolean save(Person b) {
		// TODO Auto-generated method stub
		List<Person> activeCustomers = findAll();
		if (activeCustomers == null) { // initialize a new list if none was given to us
			activeCustomers = new ArrayList<>();
		}
		
		// add the new book to the list
				activeCustomers.add(b);
			
			try(ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("Person.txt"))) {
				
				outStream.writeObject(activeCustomers); // serialize the list to the file
				return true;
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		
		 
		
		return false;
	}

	@Override
	public List<Person> findAll()  {
		
		 
		try (ObjectInputStream  inStream= new ObjectInputStream(new FileInputStream("Person.txt"))){
			try {
				return (List<Person>) inStream.readObject();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		return null;
}

	public Person FindByAccntNumber(int accntNumber) {
		
		List<Person> results = findAll();
		for (Person l: results) {
			if (l.getAccnt().getAccntNumber()== accntNumber) {
				return l ;
				
			}
		
		
	}
		return null;
	
}
	
	
	public boolean FindByUserAndPass(String userName , String Password) {
		
		List<Person> results = findAll();
		for (Person l: results) {
			if (l.getPassWord().equals(Password) && l.getUserName().equals(userName) ) {
				return true ;
				
			}
		
		
	}
		return false;
	
}
	
	public Person getByUserAndPass(String userName , String Password) {
		
		List<Person> results = findAll();
		for (Person l: results) {
			if (l.getPassWord().equals(Password) && l.getUserName().equals(userName)) {
				return l ;
				
			}
		
		
	}
		return null;
		
				
	}
	
public boolean userNameExist(String userName ) {
		
		List<Person> results = findAll();
		for (Person l: results) {
			if ( l.getUserName().equals(userName)) {
				return true ;
				
			}
		
		
	}
		return false;
		
				
	}




	
	/*
	 *  
	 *  sets with person its currently logged
	 */
	
	
	public boolean setCurrentlyLogged(Person p) {
		
		 
		try (ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("CurrentlyLogged.txt"))){
			outStream.writeObject(p); // serialize the list to the file
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return false;
		
	}
	
	/*
	 *  
	 *  sets which person its currently logged
	 */
	
	public Person  getCurrentlyLogged() {
		
		try (ObjectInputStream  inStream= new ObjectInputStream(new FileInputStream("CurrentlyLogged.txt"))) {
			try {
				return  (Person) inStream.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
		return null;
		
					
	}
	
	public void clearLoggedFile() {
		
		 
		try (ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("CurrentlyLogged.txt"))){
			outStream.writeObject(""); // serialize the list to the file
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		
	}
	
	
	
	 
	
		
}// end person dao
	
	
	
	
	
	
	
	
	
	
	
