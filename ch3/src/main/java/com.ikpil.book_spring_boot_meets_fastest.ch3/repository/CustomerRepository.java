package com.ikpil.book_spring_boot_meets_fastest.ch3.repository;

import com.ikpil.book_spring_boot_meets_fastest.ch3.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

