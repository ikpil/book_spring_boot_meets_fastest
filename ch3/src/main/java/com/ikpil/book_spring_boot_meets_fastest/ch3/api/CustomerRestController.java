package com.ikpil.book_spring_boot_meets_fastest.ch3.api;

import com.ikpil.book_spring_boot_meets_fastest.ch3.domain.Customer;
import com.ikpil.book_spring_boot_meets_fastest.ch3.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomerRestController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    List<Customer> getCustomers() {
        return customerService.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    Customer getCustomer(@PathVariable Integer id) {
        return customerService.findOne(id).orElse(null);
    }
}
