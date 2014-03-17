package frontController;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountSummary;
import dk.cphbusiness.bank.contract.dto.CheckingAccountDetail;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import dk.cphbusiness.bank.contract.eto.CustomerBannedException;
import dk.cphbusiness.bank.contract.eto.NoSuchCustomerException;
import factory.Factory;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

public class CreateAccountCommand extends TargetCommand {

    public CreateAccountCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {

        BigDecimal interest = new BigDecimal(request.getParameter("interest"));
        CheckingAccountDetail checkingAccountDetail = new CheckingAccountDetail(null, interest, null);

        String customerID = (String) request.getSession().getAttribute("customerID");
        CustomerIdentifier customer = CustomerIdentifier.fromString(customerID);
        BankManager manager = Factory.getInstance().getManager();
        try {
            manager.createAccount(customer, checkingAccountDetail);
        } catch (NoSuchCustomerException ex) {
            Logger.getLogger(CreateAccountCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CustomerBannedException ex) {
            Logger.getLogger(CreateAccountCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

        Collection<AccountSummary> accounts = manager.listCustomerAccounts(customer);
        request.setAttribute("accounts", accounts);

        return super.execute(request);
    }

}
