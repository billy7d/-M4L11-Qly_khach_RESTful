package controller;


import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import service.CustomerService;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/list")
    public String getList(Model model){
        model.addAttribute("customers",customerService.findAll());
        return "index";
    }

    @GetMapping( "/customers/")
    public ResponseEntity<Iterable<Customer>> listAllCustomers() {
        Iterable<Customer> customers = customerService.findAll();
        if (customers == null) {
            return new ResponseEntity<Iterable<Customer>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Iterable<Customer>>(customers, HttpStatus.OK);
    }


    @GetMapping( value = "/customers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Integer id) {
        System.out.println("Fetching Customer with id " + id);
        Customer customer = customerService.findOne(id);
        if (customer == null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }



    @PostMapping( "/customers/")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        System.out.println("Creating Customer " + customer.getLastName());
        customerService.save(customer);
        return new ResponseEntity<Customer>(customer,HttpStatus.OK);
    }



//    @PutMapping("/customers/{id}")
//    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Integer id, @RequestBody Customer customer) {
//        System.out.println("Updating Customer " + id);
//
//        Customer currentCustomer = customerService.findOne(id);
//
//        if (currentCustomer == null) {
//            System.out.println("Customer with id " + id + " not found");
//            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
//        }
//
//        currentCustomer.setFirstName(customer.getFirstName());
//        currentCustomer.setLastName(customer.getLastName());
//
//
//        customerService.save(currentCustomer);
//        return new ResponseEntity<Customer>(currentCustomer, HttpStatus.OK);
//    }


    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Integer id) {
        System.out.println("Fetching & Deleting Customer with id " + id);

        Customer customer = customerService.findOne(id);
        if (customer == null) {
            System.out.println("Unable to delete. Customer with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        customerService.remove(id);
        return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
    }




}
