package frontController;

import dk.cphbusiness.bank.contract.BankManager;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import dk.cphbusiness.bank.contract.dto.CustomerSummary;
import factory.Factory;

public class ListCustomersCommand extends TargetCommand {

    public ListCustomersCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        BankManager manager = Factory.getInstance().getManager();
        Collection<CustomerSummary> customers = manager.listCustomers();

        request.setAttribute("customers", customers);

        return super.execute(request);
    }
}
