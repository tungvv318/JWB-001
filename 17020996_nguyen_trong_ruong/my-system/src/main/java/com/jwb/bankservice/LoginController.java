package com.jwb.bankservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @PostMapping(value="/login")
    public String addCustomer(@RequestParam(name="id") Integer id, @RequestParam(name="pw") String password) {
        System.out.println(id);
        if (CustomerList.customerList.get(id).getPassword().equals(password)){
            CustomerList.customerList.get(id).setLogin(1);
        }
        return "redirect:/customer-list";
    }
}