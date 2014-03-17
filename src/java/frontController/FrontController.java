package frontController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FrontController", urlPatterns = {"/Controller"})
public class FrontController extends HttpServlet {

    private final Map<String, Command> commands = new HashMap<>();

    public FrontController() {
        commands.put("change-customer", new ChangeCustomerCommand("customer-edit.jsp"));
        commands.put("create-customer", new TargetCommand("customer-edit.jsp"));
        commands.put("save-customer", new CreateCustomerCommand("customer-list.jsp"));
        commands.put("list-customers", new ListCustomersCommand("customer-list.jsp"));
        
        commands.put("list-customer-accounts", new ListAccountsCommand("account-list.jsp"));
        commands.put("create-account", new TargetCommand("account-edit.jsp"));
        commands.put("save-account", new CreateAccountCommand("account-list.jsp"));
        commands.put("cancel-create-account", new CancelCreateAccountCommand("account-list.jsp"));
        commands.put("cancel-transfer", new CancelTransferCommand("account-list.jsp"));
        commands.put("show-account-details", new ListAccountDetailsCommand("account-detail.jsp"));
        commands.put("transfer-amount", new TransferCommand("account-detail.jsp"));
        
        commands.put("prepare-transfer", new PrepareTransferCommand("transfer-edit.jsp"));
        commands.put("main", new TargetCommand("main.jsp"));
        
    }

    @Override
    protected void service(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String key = request.getParameter("command");
        if (key == null) {
            key = "main";
        }
        Command command = commands.get(key);
        System.out.println("key:");
        System.out.println(key);
        String target = command.execute(request);
        RequestDispatcher dispatcher = request.getRequestDispatcher(target);
        dispatcher.forward(request, response);
    }
}
