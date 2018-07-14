package com.qa.accountapp.repo;

import java.util.List;

import database.Account;

public interface ITransaction {

	public Account createAnAccount(Account account);

	public String updateAnAccount(String accNo, String updateInfo);

	public void deleteAccount(String accNo);

	public Account findAnAccount(String accountNumber);

	public List<Account> getAllAccounts();

}
