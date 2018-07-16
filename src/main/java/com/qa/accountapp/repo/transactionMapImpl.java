package com.qa.accountapp.repo;

import java.util.Collections;
import java.util.HashMap;

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
	public String createAnAccount(String account) {
		id = Collections.max(accounts.keySet());
		id++;
		Account newAccount = util.getObjectForJSON(account, Account.class);
		accounts.put(id, newAccount);
		return account;
	}

	@Override
	public String updateAnAccount(Long id, String updateInfo) {
		if (accounts.containsKey(id)) {
			Account updatedAccount = util.getObjectForJSON(updateInfo, Account.class);
			accounts.put(id, updatedAccount);
		} else
			return "Account not found";
		return updateInfo;
	}

	@Override
	public String deleteAccount(Long id) {
		accounts.remove(id);
		return "Account has been deleted";

	}

	@Override
	public Account findAnAccount(Long id) {
		Account foundAcc = null;
		if (accounts.containsKey(id)) {
			foundAcc = accounts.get(id);
		} else
			System.out.println("Account does not exist");
		return foundAcc;
	}

	@Override
	public String getAllAccounts() {
		return util.getJSONForObject(accounts.values());
	}

}
