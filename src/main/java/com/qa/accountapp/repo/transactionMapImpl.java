package com.qa.accountapp.repo;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import database.Account;
import utility.JSONutil;


@Alternative
public class transactionMapImpl implements ITransaction {

	private long id = 1;
	private HashMap<Long, Account> accounts;

	@Inject
	private JSONutil util;

	public transactionMapImpl() {
		accounts = new HashMap<>();
	}
	
	@Override
	public Account createAnAccount(Account account) {
		id = Collections.max(accounts.keySet());
		id++;
		accounts.put(id, account);
		return account;
	}

	@Override
	public String updateAnAccount(Long id, String updateInfo) {
		String message = "";
		if (accounts.containsKey(id)) {
			Account updatedAccount = util.getObjectForJSON(updateInfo, Account.class);
			accounts.put(id, updatedAccount);
			message = updateInfo;
		} else
			message = "account not found";
		return message;
	}

	@Override
	public void deleteAccount(Long id) {
		accounts.remove(id);

	}

	@Override
	public Account findAnAccount(Long id) {
		Account foundAcc = null;
		if (accounts.containsKey(id)) {
			foundAcc = accounts.get(id);
		} else
			System.out.println("Account not found");
		return foundAcc;
	}

	@Override
	public List<Account> getAllAccounts() {
		return (List<Account>) accounts.values();
	}

}
