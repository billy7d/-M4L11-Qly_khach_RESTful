package service;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import repository.Repository;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private Repository customerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return (Customer) customerRepository.findOne(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Integer id) {
        customerRepository.delete(id);
    }
}
