package springboot.uetcodecamp.managecustomer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springboot.uetcodecamp.managecustomer.service.CustomerService;

@RestController
public class DeleteCustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/handle-delete-customer")
    public void deleCustomer(@RequestBody String delId){
        delId =delId.substring(3,delId.length());
        int id = Integer.parseInt(delId);
        customerService.deleteCustomerById(id);
    }
}
