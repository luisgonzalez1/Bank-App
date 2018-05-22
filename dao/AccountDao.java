package com.revature.dao;

import java.util.List;

import com.revature.beans.Account;
 
import com.revature.beans.Person;

public interface AccountDao {
	
	boolean save(Account b);
	List<Account> findAll();
	Account FindByAccntNumber(int accntNumber);
	
	public boolean saveLog (String l, int accnt);
	public List<String> findAllLogs (int accnt);
	public Account FindByAccntByUser(Person p);
	public void saveBalance(double balance ,int accntnumber );
	public double getBlance ( int accntnumber);
}
