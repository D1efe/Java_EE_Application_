package com.qa.accountapp.repo;

import database.Account;

public interface ITransaction {

	public String createAnAccount(String account);

	public String updateAnAccount(Long id, String updateInfo);

	public String deleteAccount(Long id);

	public Account findAnAccount(Long id);

	public String getAllAccounts();

}
