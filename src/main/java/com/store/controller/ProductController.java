package com.store.controller;

import com.store.entity.Product;
import com.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RequestMapping("/product")
@Controller
public class ProductController {

    @Autowired
    ProductService productService;




    @RequestMapping(value = "/find-all",method = RequestMethod.GET)
    public @ResponseBody List<Product> getAll(){

        System.out.print(productService.getAll());
        return productService.getAll();

    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@RequestBody Product product){
        productService.add(product);
        return "all-products";
    }


    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public String productList(){
        return "all-products";
    }


}
