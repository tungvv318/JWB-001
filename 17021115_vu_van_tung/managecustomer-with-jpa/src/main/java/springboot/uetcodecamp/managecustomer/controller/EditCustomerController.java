package springboot.uetcodecamp.managecustomer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springboot.uetcodecamp.managecustomer.model.Customer;
import springboot.uetcodecamp.managecustomer.service.CustomerService;

@Controller
public class EditCustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/handle-edit")
    public String setEditCustomer(ModelMap modelMap,
                                  @RequestParam("idCustomerEdit") int idCustomerEdit){
        Customer customerEdit = customerService.findByID(idCustomerEdit);
        modelMap.addAttribute("editCustomer", customerEdit);
        return "formedit";
    }

    @PostMapping("/handle-edit-customer")
    public String handleEdit(@ModelAttribute("editCustomer") Customer customer) {
        customerService.updateCustomer(customer);
        return "redirect:/";
    }
}
