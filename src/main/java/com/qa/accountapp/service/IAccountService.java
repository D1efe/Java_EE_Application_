package com.qa.accountapp.service;

import database.Account;

public interface IAccountService {

	public String createAnAccount(String account);

	public String updateAnAccount(Long id, String updateInfo);

	public String deleteAccount(Long id);

	public Account findAnAccount(Long id);

	public String getAllAccounts();
}
	