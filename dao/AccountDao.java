package com.revature.dao;

import java.util.List;

import com.revature.beans.Account;
 
import com.revature.beans.Person;

public interface AccountDao {
	
 
	
	
	public boolean saveLog (String l, int accnt);
	public List<String> findAllLogs (int accnt);

}
