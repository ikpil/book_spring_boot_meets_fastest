package com.ikpil.book_spring_boot_meets_fastest.ch3.web;

import com.ikpil.book_spring_boot_meets_fastest.ch3.domain.Customer;
import com.ikpil.book_spring_boot_meets_fastest.ch3.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller // RestController 와 달리 Controller 로 지정한다
@RequestMapping("customers") // RequestMapping 지정한다
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    String list(Model model) { // Spring MVC 에서는 화면에 값을 넘겨주는데 모델 객체를 사용한다
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers); // 주입

        return "customers/list"; // template/+'뷰 이름' + .html 이 화면 경로가 된다
    }
}
