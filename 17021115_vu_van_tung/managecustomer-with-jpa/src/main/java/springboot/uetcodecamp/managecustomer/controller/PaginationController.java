package springboot.uetcodecamp.managecustomer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import springboot.uetcodecamp.managecustomer.model.Customer;
import springboot.uetcodecamp.managecustomer.service.CustomerService;

import java.util.List;

@Controller
public class PaginationController {

    @Autowired
    private CustomerService customerService;

//    public int amountPage(int sizeOfPage){
//        List<Customer> customers = customerService.findAll();
//        int amountCustomer = customers.size();
//        int amountPage = 0;
//        if(amountCustomer % sizeOfPage == 0){
//            amountPage = amountCustomer/sizeOfPage;
//        }
//        else{
//            amountPage = amountCustomer/sizeOfPage + 1;
//        }
//        return amountPage;
//    }
}
