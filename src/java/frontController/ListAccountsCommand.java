package frontController;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountSummary;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import factory.Factory;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ListAccountsCommand extends TargetCommand {

  public ListAccountsCommand(String target) {
    super(target);
    }

  @Override
  public String execute(HttpServletRequest request) {
    String customerID = request.getParameter("customerID");
    BankManager manager = Factory.getInstance().getManager();
    CustomerIdentifier customer = CustomerIdentifier.fromString(customerID);
    Collection<AccountSummary> accounts = manager.listCustomerAccounts(customer);

    request.setAttribute("accounts", accounts);
    HttpSession session = null;
    session.setAttribute("customerID", customerID);
    
    return super.execute(request);
    }
  
  
  
  }
