package springboot.uetcodecamp.managecustomer.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import springboot.uetcodecamp.managecustomer.model.Customer;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findById(int id);

    Customer findByEmail(String email);

    List<Customer> findByNameContaining(String name);

    @Modifying
    @Transactional
    @Query("update Customer c set c.name = ?1, c.email = ?2, c.phone = ?3, c.balance = ?4 where c.id = ?5")
    void updateCustomer(String name, String email, String phone, int balance, int id);

    @Query("SELECT e FROM Customer e")
    Page<Customer> findCustomers(Pageable pageable);
}
