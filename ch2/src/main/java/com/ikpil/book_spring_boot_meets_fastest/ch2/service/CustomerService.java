package com.ikpil.book_spring_boot_meets_fastest.ch2.service;

import com.ikpil.book_spring_boot_meets_fastest.ch2.domain.Customer;
import com.ikpil.book_spring_boot_meets_fastest.ch2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
