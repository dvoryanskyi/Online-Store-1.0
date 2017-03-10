package com.store.controller;

import com.store.entity.Product;
import com.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


@RequestMapping("/product")
@Controller
public class ProductController {

    @Autowired
    ProductService productService;




    @RequestMapping(value = "/find-all",method = RequestMethod.GET)
    public @ResponseBody List<Product> getAll(){
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

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@RequestBody Product product){
        productService.update(product);
        return "all-products";
    }
/*
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public @ResponseBody Product update(@RequestParam(value = "id")Long id,HttpServletResponse response) throws IOException {
        response.sendRedirect("/update");
        return productService.getById(id);
    }
*/
    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public String editProduct(Product editedProduct){
        return "update";
    }


    @RequestMapping(value = "/update/{id}.json")
    public @ResponseBody  Product productJson(@PathVariable Long id){
       return productService.getById(id);
    }

    @RequestMapping(value = "/product/{id}.json")
    public @ResponseBody Product show(@PathVariable Long id){return productService.getById(id);}

    @RequestMapping(value = "/product/{id}",method = RequestMethod.GET)
    public String show(Product editedProduct){
        return "product";
    }

    @RequestMapping(value = "/find-by-text",method = RequestMethod.POST)
        public @ResponseBody List<Product> find(@RequestBody   String searchtext){

        System.out.println(searchtext);
            return productService.find(searchtext);
    }
    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    public @ResponseBody String uploadFileHendler(@RequestParam("name")String name, @RequestParam("file")MultipartFile file){
            if(!file.isEmpty()){
                try{
                    byte[] bytes = file.getBytes();
                    File dir = new File("src/main/webapp/resources/img");
                    if(!dir.exists())
                        dir.mkdir();
                    File serverFile = new File(dir.getAbsolutePath()+File.separator+name);
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                    stream.write(bytes);
                    stream.close();
                    return "success"+name;}
                    catch (Exception e){
                    return e.getMessage();
                    }}
            else{
                return "faild empty";
                }
    }


}
