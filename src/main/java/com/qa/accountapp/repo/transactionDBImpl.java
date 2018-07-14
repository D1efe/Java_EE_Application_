package com.qa.accountapp.repo;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import database.Account;
import utility.JSONutil;

@Transactional(TxType.SUPPORTS)
public class transactionDBImpl implements ITransaction {

	@Inject
	private JSONutil util;
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	public List<Account> getAllAccounts() {

		TypedQuery<Account> query = em.createQuery("SELECT m FROM ACCOUNT m ORDER BY m.accountNumber DESC",
				Account.class);
		return query.getResultList();

	}

	public Account findAnAccount(String accNo) {
		return em.find(Account.class, accNo);
	}

	@Transactional(TxType.REQUIRED)
	public Account createAnAccount(Account account) {
		em.persist(account);
		return account;
	}

	@Transactional(TxType.REQUIRED)
	public String updateAnAccount(String accNo, String updatedInfo) {
		Account tempUpdateInfo = util.getObjectForJSON(updatedInfo, Account.class);
		Account accountToUpdate = findAnAccount(accNo);
		if (accountToUpdate != null) {
			accountToUpdate = tempUpdateInfo;
			em.merge(accountToUpdate);
		}
		return "Account has been updated";
		
	}

	@Transactional(TxType.REQUIRED)
	public void deleteAccount(String accNo) {
		em.remove(em.getReference(Account.class, accNo));


	}
}
