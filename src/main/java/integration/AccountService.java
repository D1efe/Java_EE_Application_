package integration;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import database.Account;
import services.IAccountService;

@Path("/account")
public class AccountService {

	@Inject
	private IAccountService service;

	@Path("/json/")
	@POST
	@Produces({ "application/json" })
	public Account createAnAccount(Account account) {
		return service.createAnAccount(account);

	}

	@Path("/json/")
	@Produces
	@PUT
	String updateAnAccount(@PathParam("id") Long id, String updateInfo) {
		return service.updateAnAccount(id, updateInfo);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public void deleteAccount(@PathParam("id") Long id) {
		service.deleteAccount(id);
	}

	@Path("/json/{id}")
	@GET
	@Produces({ "application/json" })
	public Account findAnAccount(@PathParam("id") Long id) {
		return service.findAnAccount(id);
	}

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public List<Account> getAllAccounts(Long id) {
		return service.getAllAccounts();

	}
}
