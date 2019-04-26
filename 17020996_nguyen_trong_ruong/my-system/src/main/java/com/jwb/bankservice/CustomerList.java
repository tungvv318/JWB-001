package com.jwb.bankservice;

import java.util.ArrayList;

public class CustomerList {
    public static ArrayList<Customer> customerList = new ArrayList<Customer>();
    static{
        customerList.add(new Customer(0,"abc", "abc@mail.com", "12345", 123));
        customerList.add(new Customer(1,"abcabc", "abcabc@mail.com", "54321", 123));
    }
}