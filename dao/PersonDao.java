package com.revature.dao;

import java.util.List;

 
import com.revature.beans.Person;

public interface PersonDao {
	
	boolean save(Person b);
	Person FindByAccntNumber(int accntNumber);
	boolean FindByUserAndPass(String userName , String Password);
	Person getByUserAndPass(String userName , String Password);
	List<Person> findAll();
	boolean setCurrentlyLogged(Person p);
	Person  getCurrentlyLogged();
	void clearLoggedFile();
	boolean userNameExist(String userName );
	

}
