package com.ikpil.book_spring_boot_meets_fastest.ch3.api;

import com.ikpil.book_spring_boot_meets_fastest.ch3.domain.Customer;
import com.ikpil.book_spring_boot_meets_fastest.ch3.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // REST 웹 서비스의 엔드 포인트 컨트롤러 클래스에 지정하는 애너테이션
@RequestMapping("api/customers")  // REST 웹 서비스의 URL과 매핑 애너테이션
public class CustomerRestController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
        // REST API 중 GET 과 매핑
    List<Customer> getCustomers() {
        return customerService.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
        // REST API 중 ../{id} 로 매핑
    Customer getCustomer(@PathVariable Integer id) {
        return customerService.findOne(id).orElse(null);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Customer postCustomers(@RequestBody Customer customer) {
        return customerService.create(customer);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    Customer postCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        customer.setId(id);
        return customerService.update(customer);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void postCustomer(@PathVariable Integer id) {
        customerService.delete(id);
    }
}
