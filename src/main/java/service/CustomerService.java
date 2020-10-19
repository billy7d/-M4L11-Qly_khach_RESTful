package service;

import model.Customer;

public interface CustomerService {
    Iterable<Customer> findAll();

    Customer findById(Integer id);

    void save(Customer customer);

    void remove(Integer id);

}
