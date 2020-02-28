package com.ikpil.book_spring_boot_meets_fastest.ch2.repository;

import com.ikpil.book_spring_boot_meets_fastest.ch2.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;

@Repository
@Transactional // 각 메서드를 다른 클래스에서 호출하면 DB 트랜잭션이 자동으로 이루어짐
public class CustomerRepository {
    private static final RowMapper<Customer> customerRowMapper = (rs, num) -> new Customer(
            rs.getInt("id"),
            rs.getString("first_name"),
            rs.getString("last_name")
    );
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    SimpleJdbcInsert insert;

    @PostConstruct
    public void init() {
        insert = new SimpleJdbcInsert((JdbcTemplate) jdbcTemplate.getJdbcOperations())
                .withTableName("customers")
                .usingGeneratedKeyColumns("id");
    }

    public List<Customer> findAll() {
        return jdbcTemplate.query("SELECT * FROM `customers` ORDER BY `id`", customerRowMapper);
    }

    public Customer findOne(Integer id) {
        var param = new MapSqlParameterSource().addValue("id", id);
        return jdbcTemplate.queryForObject("SELECT * FROM `customers` WHERE `id` = :id", param, customerRowMapper);
    }

    public Customer save(Customer customer) {
        var param = new BeanPropertySqlParameterSource(customer);
        if (Objects.isNull(customer.getId())) {
            Number key = insert.executeAndReturnKey(param);
            customer.setId(key.intValue());
        } else {
            jdbcTemplate.update("UPDATE `customers` SET `first_name` = :firstName, `last_name` = :lastName WHERE `id` = :id", param);
        }

        return customer;
    }

    public void delete(Integer customerId) {
        var param = new MapSqlParameterSource().addValue("id", customerId);
        jdbcTemplate.update("DELETE FROM `customers` WHERE `id` = :id", param);
    }
}
