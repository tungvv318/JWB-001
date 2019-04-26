package com.jwb.bankservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LogoutController {
    @GetMapping(value="/logout")
    public String logout(@RequestParam(name="customerId") Integer id){
        CustomerList.customerList.get(id).setLogin(0);
        return "redirect:/customer-list";
    }
}