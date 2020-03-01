package com.ikpil.book_spring_boot_meets_fastest.ch3.service;

import com.ikpil.book_spring_boot_meets_fastest.ch3.domain.Customer;
import com.ikpil.book_spring_boot_meets_fastest.ch3.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class CustomerService {
    @Autowired
    CustomerRepository repository;

    public List<Customer> findAll() {
        return repository.findAllOrderByName();
    }

    public Optional<Customer> findOne(Integer id) {
        return repository.findById(id);
    }

    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    public Customer update(Customer customer) {
        return repository.save(customer);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
