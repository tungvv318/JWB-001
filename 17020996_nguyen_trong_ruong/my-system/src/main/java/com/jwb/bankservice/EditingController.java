package com.jwb.bankservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditingController {
    @PostMapping(value="/edit-customer")
    public String addCustomer(@ModelAttribute("customerInfo") Customer customer) {
        int id = CustomerList.customerList.size()-1;
        CustomerList.customerList.get(id).setName(customer.getName());
        CustomerList.customerList.get(id).setEmail(customer.getEmail());
        CustomerList.customerList.get(id).setPhoneNumber(customer.getPhoneNumber());
        CustomerList.customerList.get(id).setPassword(customer.getPassword());
        return "redirect:/customer-list";
    }
}