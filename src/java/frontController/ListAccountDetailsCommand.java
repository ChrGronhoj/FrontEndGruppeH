/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontController;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountDetail;
import dk.cphbusiness.bank.contract.dto.AccountIdentifier;
import dk.cphbusiness.bank.contract.dto.TransferSummary;
import factory.Factory;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author christian-if
 */
public class ListAccountDetailsCommand extends TargetCommand {

    public ListAccountDetailsCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {

        String accountNumber = request.getParameter("accountNumber");
        BankManager manager = Factory.getInstance().getManager();
        AccountIdentifier accountIdentifier = new AccountIdentifier(accountNumber);
        AccountDetail accountDetail = manager.showAccountHistory(accountIdentifier);
        Collection<TransferSummary> ts = accountDetail.getTransfers();

        request.setAttribute("transferSummary", ts);

        return super.execute(request);
    }
}
