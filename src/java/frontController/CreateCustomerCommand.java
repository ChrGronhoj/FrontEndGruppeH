package frontController;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.CustomerDetail;
import dk.cphbusiness.bank.contract.dto.CustomerSummary;
import factory.Factory;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;


public class CreateCustomerCommand extends TargetCommand {

    public CreateCustomerCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {

        String cpr = request.getParameter("cpr");
        String title = request.getParameter("title");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String street = request.getParameter("street");
        String postalCode = request.getParameter("postalCode");
        String postalDistrict = request.getParameter("postalDistrict");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        CustomerDetail customerDetail = new CustomerDetail(cpr, title, firstName,
                lastName, street, postalCode, postalDistrict, phone, email);

        BankManager manager = Factory.getInstance().getManager();
        manager.saveCustomer(customerDetail);
        
        Collection<CustomerSummary> customers = manager.listCustomers();

        request.setAttribute("customers", customers);

        return super.execute(request);
    }

}
