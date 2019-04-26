package com.jwb.bankservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddingController {
    @PostMapping(value="/add-customer")
    public String addCustomer(@ModelAttribute("customerInfo") Customer customer) {
        int id = CustomerList.customerList.size();
        customer.setId(id);
        CustomerList.customerList.add(customer);
        return "redirect:/customer-list";
    }
}