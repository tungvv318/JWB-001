package com.jwb.bankservice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ListCustomerController {

    @RequestMapping(value = {"/", "/customer-list" }, method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("customerList", CustomerList.customerList);
        return "CustomerList";
    }

    @RequestMapping(value = { "/adding-form" }, method = RequestMethod.GET)
    public String addForm(ModelMap modelmap) {
        modelmap.addAttribute("customerInfo", new Customer());
        return "Add";
    }
    @GetMapping(value="/editing-form")
    public String editForm(@RequestParam(name="customerId") Integer id, ModelMap modelMap) {
        modelMap.addAttribute("customerInfo", CustomerList.customerList.get(id));
        return "Edit";
    }
    @GetMapping(value="/login-form")
    public String loginForm(@RequestParam(name="customerId") Integer id, ModelMap modelMap){
        modelMap.addAttribute("customerInfo", CustomerList.customerList.get(id));
        return "Login";
    }
    @GetMapping(value="/transfering-form")
    public String transferingForm(@RequestParam(name="customerId") Integer id, ModelMap modelMap){
        modelMap.addAttribute("customerId", id);
        return "Transfer";
    }
}