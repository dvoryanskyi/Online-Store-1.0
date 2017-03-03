package com.store.controller;

import com.store.service.ProductService;
import com.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {



    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @RequestMapping("/pip")
    public  String test(){
        Long num = new Long(1);

        System.out.println(userService.getAll());
        System.out.println(productService.getAll());
        System.out.println(userService.getById(num));
        System.out.println(productService.getById(num));
        return "index";
    }
}
