package interoperability;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.accountapp.service.IAccountService;

import database.Account;

@Path("/accountEE")
public class AccountEnding {

	@Inject
	private IAccountService service;

	@Path("/json")
	@POST
	@Produces("application/json")
	public String createAnAccount(String account) {
		return service.createAnAccount(account);
	}

	@Path("/json/{id}")
	@PUT
	@Produces("application/json")
	public String updateAnAccount(@PathParam("id") Long id, String updateInfo) {
		return service.updateAnAccount(id, updateInfo);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces("application/json")
	public String deleteAnAccount(@PathParam("id") Long id) {
		return service.deleteAccount(id);
	}

	@Path("/json/{id}")
	@GET
	@Produces("application/json")
	public Account findAnAccount(@PathParam("id") Long id) {
		return service.findAnAccount(id);
	}

	@Path("/json")
	@GET
	@Produces("application/json")
	public String getAllAccounts() {
		return service.getAllAccounts();
	}

}
