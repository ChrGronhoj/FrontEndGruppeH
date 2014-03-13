package frontController;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import dk.cphbusiness.bank.contract.dto.CustomerSummary;
import javax.servlet.http.HttpSession;

public class ListCustomersCommand extends TargetCommand {

  public ListCustomersCommand(String target) {
    super(target);
  }

  @Override
  public String execute(HttpServletRequest request) {
    Collection<CustomerSummary> customers = factory.Factory.getInstance().getManager().listCustomers();
    
    
    request.setAttribute("customers", customers);

    return super.execute(request); 
  }
}