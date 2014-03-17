package frontController;

import javax.servlet.http.HttpServletRequest;


public class PrepareTransferCommand extends TargetCommand {

    public PrepareTransferCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {

        String accountNumber = request.getParameter("accountNumber");
        request.setAttribute("accountNumber", accountNumber);

        return super.execute(request);
    }
}
