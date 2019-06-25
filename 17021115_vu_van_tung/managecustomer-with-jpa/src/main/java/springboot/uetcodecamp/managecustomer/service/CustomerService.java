package springboot.uetcodecamp.managecustomer.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import springboot.uetcodecamp.managecustomer.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findByID(int id);

    Customer findByEmail(String email);

    void insertCustomer(Customer customer);

    void deleteCustomerById(int id);

    void deleteCustomer(Customer customer);

    void updateCustomer(Customer customer);

    List<Customer> findByNameContaining(String name);

    Page<Customer> findCustomers(Pageable pageable);
}
