package springboot.uetcodecamp.managecustomer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import springboot.uetcodecamp.managecustomer.model.Customer;
import springboot.uetcodecamp.managecustomer.service.CustomerService;

@Controller
public class AddCustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/handle-add")
    public String setAddCustomer(ModelMap modelMap){
        modelMap.addAttribute("customerAdd", new Customer());
        return "formadd";
    }

    @PostMapping("/handle-add-customer")
    public String handleAdd(@ModelAttribute("customerAdd") Customer customer) {
        customerService.insertCustomer(customer);
        return "redirect:/";
    }
}
