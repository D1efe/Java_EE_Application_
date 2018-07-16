package services;

import java.util.List;

import javax.inject.Inject;

import com.qa.accountapp.repo.ITransaction;

import database.Account;

public class AccountServiceImpl implements IAccountService {

	@Inject
	private ITransaction repoTransactions;

	@Override
	public Account createAnAccount(Account account) {
		return repoTransactions.createAnAccount(account);

	}

	@Override
	public String updateAnAccount(Long id, String updateInfo) {
		return repoTransactions.updateAnAccount(id, updateInfo);
	}

	@Override
	public void deleteAccount(Long id) {
		repoTransactions.deleteAccount(id);
	}

	@Override
	public Account findAnAccount(Long id) {
		return repoTransactions.findAnAccount(id);
	}

	@Override
	public List<Account> getAllAccounts() {
		return repoTransactions.getAllAccounts();
	}

}
