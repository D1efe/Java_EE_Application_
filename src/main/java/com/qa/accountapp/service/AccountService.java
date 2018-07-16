package com.qa.accountapp.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.accountapp.repo.ITransaction;

import database.Account;

public class AccountService implements IAccountService {

	private static final Logger LOGGER = Logger.getLogger(AccountService.class);
	
	@Inject
	private ITransaction repoTransaction;
	
	@Override
	public String createAnAccount(String account) {
		LOGGER.info("logger for creation method");
		return repoTransaction.createAnAccount(account);
	}

	@Override
	public String updateAnAccount(Long id, String updateInfo) {
		LOGGER.info("logger for update method");
		return repoTransaction.updateAnAccount(id, updateInfo);
	}

	@Override
	public String deleteAccount(Long id) {
		LOGGER.info("");
		return repoTransaction.deleteAccount(id);
	}

	@Override
	public Account findAnAccount(Long id) {
		LOGGER.info("");
		return repoTransaction.findAnAccount(id);
	}

	@Override
	public String getAllAccounts() {
		LOGGER.info("");
		return repoTransaction.getAllAccounts();
	}
	
	

}
