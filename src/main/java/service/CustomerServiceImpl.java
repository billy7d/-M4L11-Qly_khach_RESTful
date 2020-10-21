package service;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import repository.CustomerRepository;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findOne(Integer id) {
        return customerRepository.findOne(id);
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
