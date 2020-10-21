package service;

import model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerService  {
    Iterable<Customer> findAll();

    Customer findOne(Integer id);

    void save(Customer customer);

    void remove(Integer id);

}
