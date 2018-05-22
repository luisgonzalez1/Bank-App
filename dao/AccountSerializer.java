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

public class AccountSerializer implements AccountDao {

	 
	 
	@Override
	public boolean saveLog(String l, int accnt ) {
		 
		List<String> logs = findAllLogs(accnt);
		if (logs == null) { // initialize a new list if none was given to us
			logs = new ArrayList<>();
		}
		
		// add the new book to the list
				logs.add(l);
			
			try(ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(String.valueOf(accnt)+"Logs.txt"))) {
				
				outStream.writeObject(logs); // serialize the list to the file
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
	public List<String> findAllLogs(int accnt) {
		
		try (ObjectInputStream  inStream= new ObjectInputStream(new FileInputStream(String.valueOf(accnt)+"Logs.txt"))){
			try {
				return (List<String>) inStream.readObject();
			
			
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

 
}
