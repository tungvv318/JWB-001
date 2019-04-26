package com.jwb.bankservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TransferingController {
    @PostMapping(value="/transfer")
    public String transfer(@RequestParam(name = "sentId") Integer sId, @RequestParam(name="receivedId") Integer rId, @RequestParam(name="amount") Integer amount){
        if (rId >= CustomerList.customerList.size() || rId == sId) return "Error";
         else{
            CustomerList.customerList.get(sId).transferMoney(amount);
            CustomerList.customerList.get(rId).receiveMoney(amount);
         }
        return "redirect:/customer-list";
    }
}