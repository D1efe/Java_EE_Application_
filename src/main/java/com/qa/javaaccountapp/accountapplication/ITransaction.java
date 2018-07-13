package com.qa.javaaccountapp.accountapplication;

import java.util.List;

public interface ITransaction {

	public Account createAnAccount(Account account);

	public Account updateAnAccount(Account account, String fname, String lname);

	public void deleteAccount(Account account);

	public Account findAnAccount(String accountNumber);

	public List<Account> getAllAccounts();

}
