package springboot.uetcodecamp.managecustomer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springboot.uetcodecamp.managecustomer.model.Customer;
import springboot.uetcodecamp.managecustomer.service.CustomerService;

import java.util.List;

@Controller
public class SearchCustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/handle-search")
    public String handleSearch(ModelMap modelMap,
                               @RequestParam(name = "search") String name){
        List<Customer> lstCustomerSearchByText = customerService.findByNameContaining(name);
        modelMap.addAttribute("lstCustomer",lstCustomerSearchByText);
        return "home";
    }
}
