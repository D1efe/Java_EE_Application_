package services;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.accountapp.repo.ITransaction;

import database.Account;

public class AccountServiceImpl implements IAccountService {
	
	private static final Logger LOGGER = Logger.getLogger(IAccountService.class);

	@Inject
	private ITransaction repoTransactions;

	@Override
	public Account createAnAccount(Account account) {
		LOGGER.info("createAnAccount method log");
		return repoTransactions.createAnAccount(account);

	}

	@Override
	public String updateAnAccount(Long id, String updateInfo) {
		LOGGER.info("updateAnAccount method log");
		return repoTransactions.updateAnAccount(id, updateInfo);
	}

	@Override
	public void deleteAccount(Long id) {
		LOGGER.info("deleteAccount method log");
		repoTransactions.deleteAccount(id);
	}

	@Override
	public Account findAnAccount(Long id) {
		LOGGER.info("findAnAccount method log");
		return repoTransactions.findAnAccount(id);
	}

	@Override
	public List<Account> getAllAccounts() {
		LOGGER.info("getAllAccounts method log");
		return repoTransactions.getAllAccounts();
	}

}
