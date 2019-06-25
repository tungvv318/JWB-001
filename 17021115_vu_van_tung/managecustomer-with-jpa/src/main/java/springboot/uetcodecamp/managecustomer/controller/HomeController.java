package springboot.uetcodecamp.managecustomer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springboot.uetcodecamp.managecustomer.model.Customer;
import springboot.uetcodecamp.managecustomer.service.CustomerService;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private CustomerService customerService;

//    @GetMapping("/")
//    public String home(ModelMap modelMap){
//        List<Customer> lstAllCustomer = customerService.findAll();
//        modelMap.addAttribute("lstCustomer",lstAllCustomer);
//        return "home";
//    }

    @GetMapping("/")
    public String listCustomer(ModelMap model,
                               @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                               @RequestParam(name = "size", required = false, defaultValue = "1") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        model.addAttribute("lstCustomer", customerService.findCustomers(pageable));
        model.addAttribute("amoutPage", amountPage(size));
        return "home";
    }

    public int amountPage(int sizeOfPage){
        List<Customer> customers = customerService.findAll();
        int amountCustomer = customers.size();
        int amountPage = 0;
        if(amountCustomer % sizeOfPage == 0){
            amountPage = amountCustomer/sizeOfPage;
        }
        else{
            amountPage = amountCustomer/sizeOfPage + 1;
        }
        return amountPage;
    }
}
