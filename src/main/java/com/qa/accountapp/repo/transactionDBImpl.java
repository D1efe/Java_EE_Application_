package com.qa.accountapp.repo;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import database.Account;
import utility.JSONutil;

@Default
@Transactional(TxType.SUPPORTS)
public class transactionDBImpl implements ITransaction {

	@Inject
	private JSONutil util;
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	public List<Account> getAllAccounts() {

		TypedQuery<Account> query = em.createQuery("SELECT m FROM ACCOUNT m ORDER BY m.id DESC",
				Account.class);
		return query.getResultList();

	}

	public Account findAnAccount(Long id) {
		return em.find(Account.class, id);
	}

	@Transactional(TxType.REQUIRED)
	public Account createAnAccount(Account account) {
		em.persist(account);
		return account;
	}

	@Transactional(TxType.REQUIRED)
	public String updateAnAccount(Long id, String updatedInfo) {
		Account tempUpdateInfo = util.getObjectForJSON(updatedInfo, Account.class);
		Account accountToUpdate = findAnAccount(id);
		if (accountToUpdate != null) {
			accountToUpdate = tempUpdateInfo;
			em.merge(accountToUpdate);
		}
		return "Account has been updated";
		
	}

	@Transactional(TxType.REQUIRED)
	public void deleteAccount(Long id) {
		em.remove(em.getReference(Account.class, id));


	}
}
