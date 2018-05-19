package com.revature.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import com.revature.beans.Person;

public class PersonSerializer implements PersonDao {

	@Override
	public boolean save(Person b) {
		// TODO Auto-generated method stub
		List<Person> activeCustomers = findAll();
		if (activeCustomers == null) { // initialize a new list if none was given to us
			activeCustomers = new ArrayList<>();
		}
		// add the new book to the list
		activeCustomers.add(b);
		
		try (ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("Person.txt"))) {
			
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
		try (ObjectInputStream inStream = new ObjectInputStream(new FileInputStream("Person.txt"))){
			
			return (List<Person>) inStream.readObject();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
