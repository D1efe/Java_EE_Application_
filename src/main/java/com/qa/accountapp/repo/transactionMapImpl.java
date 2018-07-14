package com.qa.accountapp.repo;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import database.Account;
import utility.JSONutil;

public class transactionMapImpl implements ITransaction {

	private long ACCNO = 1;
	private HashMap<String, Account> accounts;

	@Inject
	private JSONutil util;

	transactionMapImpl() {
		accounts = new HashMap<>();
	}

	@Override
	public Account createAnAccount(Account account) {
		ACCNO = Collections.max(accounts.entrySet());
		String accNo = ACCNO++;
		accounts.put(AccNo, account);
		return null;
	}

	@Override
	public String updateAnAccount(String accNo, String updateInfo) {
		String message = "";
		if (accounts.containsKey(accNo)) {
			Account updatedAccount = util.getObjectForJSON(updateInfo, Account.class);
			accounts.put(accNo, updatedAccount);
			message = updateInfo;
		} else
			message = "account not found";
		return message;
	}

	@Override
	public void deleteAccount(String accNo) {
		accounts.remove(accNo);

	}

	@Override
	public Account findAnAccount(String accNo) {
		Account foundAcc = null;
		if (accounts.containsKey(accNo)) {
			foundAcc = accounts.get(accNo);
		} else
			System.out.println("Account not found");
		return foundAcc;
	}

	@Override
	public List<Account> getAllAccounts() {
		return (List<Account>) accounts.values();
	}

}
