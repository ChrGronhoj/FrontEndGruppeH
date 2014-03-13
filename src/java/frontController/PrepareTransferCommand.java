/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontController;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountIdentifier;
import dk.cphbusiness.bank.contract.eto.InsufficientFundsException;
import dk.cphbusiness.bank.contract.eto.NoSuchAccountException;
import dk.cphbusiness.bank.contract.eto.TransferNotAcceptedException;
import factory.Factory;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Po
 */
public class PrepareTransferCommand extends TargetCommand {

    public PrepareTransferCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {

        String accountNumber = request.getParameter("accountNumber");
//        String fromAccount = request.getParameter("fromAccount");
//        AccountIdentifier fAcc = AccountIdentifier.fromString(fromAccount);
//        
//        request.setAttribute("fromAccount", fAcc);
        request.setAttribute("accountNumber", accountNumber);

        return super.execute(request);
    }
}
