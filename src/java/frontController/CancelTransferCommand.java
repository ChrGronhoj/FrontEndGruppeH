package frontController;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountSummary;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import factory.Factory;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;


public class CancelTransferCommand extends TargetCommand {

    public CancelTransferCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {

        String customerID = (String)request.getSession().getAttribute("customerID");
        BankManager manager = Factory.getInstance().getManager();
        CustomerIdentifier customer = CustomerIdentifier.fromString(customerID);
        Collection<AccountSummary> accounts = manager.listCustomerAccounts(customer);

        request.setAttribute("accounts", accounts);

        return super.execute(request);
    }
}
