package com.qa.accountapp.repo;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

	@Transactional(TxType.REQUIRED)
	public String createAnAccount(String account) {
		em.persist(account);
		return "Account has been created";
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
	public String deleteAccount(Long id) {
		em.remove(em.getReference(Account.class, id));
		return "account has been deleted";
	}

	public Account findAnAccount(Long id) {
		return em.find(Account.class, id);
	}

	public String getAllAccounts() {

		Query query = em.createQuery("SELECT m FROM ACCOUNT m ORDER BY m.id DESC");
		Collection<Account> allAccounts = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(allAccounts);
	}
}
