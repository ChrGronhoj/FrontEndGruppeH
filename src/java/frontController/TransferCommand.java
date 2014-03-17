package frontController;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountDetail;
import dk.cphbusiness.bank.contract.dto.AccountIdentifier;
import dk.cphbusiness.bank.contract.dto.TransferSummary;
import dk.cphbusiness.bank.contract.eto.InsufficientFundsException;
import dk.cphbusiness.bank.contract.eto.NoSuchAccountException;
import dk.cphbusiness.bank.contract.eto.TransferNotAcceptedException;
import factory.Factory;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;


public class TransferCommand extends TargetCommand{

    public TransferCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {

        String accountNumber = request.getParameter("accountNumber");

        BankManager manager = Factory.getInstance().getManager();
        BigDecimal money = new BigDecimal(request.getParameter("money"));
        String toAccount = request.getParameter("toAccount");
        AccountIdentifier fAcc = AccountIdentifier.fromString(accountNumber);
        AccountIdentifier tAcc = AccountIdentifier.fromString(toAccount);

        try {
            manager.transferAmount(money, fAcc, tAcc);
        } catch (NoSuchAccountException | TransferNotAcceptedException | InsufficientFundsException ex) {
            Logger.getLogger(PrepareTransferCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        AccountIdentifier accountIdentifier = new AccountIdentifier(accountNumber);
        AccountDetail accountDetail = manager.showAccountHistory(accountIdentifier);
        Collection<TransferSummary> ts = accountDetail.getTransfers();

        request.setAttribute("transferSummary", ts);

        return super.execute(request);
    }
}
