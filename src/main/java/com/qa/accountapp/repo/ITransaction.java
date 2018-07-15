package com.qa.accountapp.repo;

import java.util.List;

import database.Account;

public interface ITransaction {

	public Account createAnAccount(Account account);

	public String updateAnAccount(Long id, String updateInfo);

	public void deleteAccount(Long id);

	public Account findAnAccount(Long id);

	public List<Account> getAllAccounts();

}
