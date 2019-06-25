package springboot.uetcodecamp.managecustomer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springboot.uetcodecamp.managecustomer.model.Customer;
import springboot.uetcodecamp.managecustomer.service.CustomerService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TransfersController {
    @Autowired
    private CustomerService customerService;

    public List<Integer> listIdCustomersCanRecevie(int idCustomerTransfers){
        List<Customer> customersCanRecevie = customerService.findAll();
        for (int i = 0; i < customersCanRecevie.size(); i++){
            if (customersCanRecevie.get(i).getId() == idCustomerTransfers){
                customersCanRecevie.remove(i);
            }
        }
        List<Integer> listIdCustomersCanRecevie = new ArrayList<>();
        for (int i = 0; i < customersCanRecevie.size(); i++){
            listIdCustomersCanRecevie.add(customersCanRecevie.get(i).getId());
        }
        return listIdCustomersCanRecevie;
    }
    @PostMapping("/transfers")
    public String handleFormBank(ModelMap modelMap,
                                 @RequestParam(name = "idCustomerTransfers") Integer idCustomerTransfers,
                                 HttpSession session) {
        session.setAttribute("idCustomerTransfers", idCustomerTransfers);
        // thêm số tiền mà customer đang chuyển hiện có là bao nhiêu để kiểm tra nếu chuyển hơn tiền
        modelMap.addAttribute("maxMoney", customerService.findByID(idCustomerTransfers).getBalance());
        modelMap.addAttribute("listIdCustomersCanRecevie", listIdCustomersCanRecevie(idCustomerTransfers));
        return "chuyentien";
    }

    @PostMapping("/handle-transfers")
    public String handleChuyenChuyen(ModelMap modelMap,
                                     @RequestParam(name = "idCustmerReceive") Integer idCustmerReceive,
                                     @RequestParam(name = "moneyCustomerReceive") Integer moneyCustomerReceive,
                                     HttpSession session){
        // lấy id của customer đang  thực hiện chuyển tiền
        int idCustomerTransfers = (int)session.getAttribute("idCustomerTransfers");
        // thực hiện xóa session
        session.removeAttribute("idCustomerTransfers");
        // lấy customer có id = idCustomerTransfers ra
        Customer customerTransfers = customerService.findByID(idCustomerTransfers);
        // nếu số tiền mà customerTransfers hiện có chuyển >= số tiền định chuyển thì chuyển thành công
        if(customerService.findByID(idCustmerReceive) != null){
            if(customerTransfers.getBalance() >= moneyCustomerReceive){
                // lấy customer có id = idCustmerReceive
                Customer customerReceive = customerService.findByID(idCustmerReceive);
                // tăng tiền cho custmerReceive
                customerReceive.setBalance(customerReceive.getBalance() + moneyCustomerReceive);
                // giản tiền của customerTransfers
                customerTransfers.setBalance(customerTransfers.getBalance() - moneyCustomerReceive);
                // update lại
                customerService.updateCustomer(customerReceive);
                customerService.updateCustomer(customerTransfers);
                modelMap.addAttribute("customer", customerTransfers);
                return "formbank";
            }
            else {
                modelMap.addAttribute("customer", customerTransfers);
                return "formbank";
            }
        }
        else {
            modelMap.addAttribute("customer", customerTransfers);
            return "formbank";
        }
    }
}
