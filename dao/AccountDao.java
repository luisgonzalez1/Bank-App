package com.revature.dao;

import java.util.List;

import com.revature.beans.Account;
 
import com.revature.beans.Person;

public interface AccountDao {
	
	boolean save(Account b);
	
	
	public boolean saveLog (String l);
	public List<String> findAllLogs ();

}
