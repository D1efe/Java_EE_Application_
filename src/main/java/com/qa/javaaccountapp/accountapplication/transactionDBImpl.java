package com.qa.javaaccountapp.accountapplication;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import antlr.collections.List;

@Transactional(TxType.SUPPORTS)
public class transactionDBImpl {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Transactional(TxType.REQUIRED)
	public List<Account> getAllAccounts() {
		
		TypedQuery<Account> query = em.createQuery("SELECT m FROM ACCOUNT m ORDER BY m.accountNumber DESC", Account.class);
		return query.getResultList();
	
	}
	
	@Transactional(TxType.REQUIRED)
	public Account findAnAccount(String accountNumber) {
		return em.find(Account.class, accountNumber);
	}
	
	@Transactional(TxType.REQUIRED)
	public Account createAnAccount(Account account) {
		em.persist(account);
		return account;
	}
	
	@Transactional(TxType.REQUIRED)
	public Account updateAnAccount(Account account, String fname, String lname) {
		em.getTransaction().begin();
		account.setFirstName(fname);
		account.setLastName(lname);
		em.getTransaction().commit();
		em.refresh(account);
		return account;
		
	}
	
	@Transactional(TxType.REQUIRED)
	public void deleteAccount(Account account) {
		
		em.getTransaction().begin();
		em.remove(account);
		em.getTransaction().commit();
			
		
	}
} 
