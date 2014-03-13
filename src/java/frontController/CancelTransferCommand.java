/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontController;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountSummary;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import factory.Factory;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Po
 */
public class CancelTransferCommand extends TargetCommand {

    public CancelTransferCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {

        String customerID = request.getParameter("customerID");
        BankManager manager = Factory.getInstance().getManager();
        CustomerIdentifier customer = CustomerIdentifier.fromString(customerID);
        Collection<AccountSummary> accounts = manager.listCustomerAccounts(customer);

        request.setAttribute("accounts", accounts);

        return super.execute(request);
    }
}
