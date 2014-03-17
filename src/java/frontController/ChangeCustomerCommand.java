package frontController;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.CustomerDetail;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import dk.cphbusiness.bank.contract.eto.NoSuchCustomerException;
import factory.Factory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;


public class ChangeCustomerCommand extends TargetCommand {

    public ChangeCustomerCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {

        String customerID = request.getParameter("customerID");
        BankManager manager = Factory.getInstance().getManager();
        CustomerIdentifier customer = CustomerIdentifier.fromString(customerID);

        try {
            CustomerDetail customerDetail = manager.showCustomer(customer);
            request.setAttribute("customerDetail", customerDetail);
        } catch (NoSuchCustomerException ex) {
            Logger.getLogger(ChangeCustomerCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

        return super.execute(request);
    }

}
