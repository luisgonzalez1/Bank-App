package com.revature.dao;

import java.util.List;

 
import com.revature.beans.Person;

public interface PersonDao {
	
	boolean save(Person b);
	Person FindByAccntNumber(int accntNumber);
	List<Person> findAll();
	
	
	
	

}
