package com.restcruddemo.controller;

import com.restcruddemo.exception.InvalidProductIDException;
import com.restcruddemo.model.Product;
import com.restcruddemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping("/listall")
    public List<Product> list(){
        return service.listAll();
    }

    @GetMapping("/getproduct/{id}")
    public Product get(@PathVariable("id") int i) {
        System.out.println(i);
        Product product=null;

        try {
            product = service.get(i);
        }
        catch(InvalidProductIDException e)
        {
            System.out.println(e);
        }
        return product;

    }

    @GetMapping("/searchbyname/{name}")
    public Product searchByName(@PathVariable("name") String s){
        return service.searchByName(s);
    }

    @GetMapping("/substringsearch/{substring}")
    public List<Product> searchBySubString(@PathVariable("substring") String str){
        return service.searchBySubString(str);
    }


    @RequestMapping(value = "/addproduct", method = RequestMethod.POST)
    public String add(@RequestBody Product product)  {
        service.add(product);
        System.out.println(product);
        return "product added successfully";
    }

    @RequestMapping(value = "/addproducts",method = RequestMethod.POST)
    public String addProductList(@RequestBody List<Product> products){
        service.addProductList(products);
        System.out.println(products);
        return "Products added successfully";
    }

    @PutMapping("/updateproduct/{id}")
    public boolean update(@PathVariable("id") int id) {

        if (service.update(id)) {
            return true;
        } else {
            return false;
        }
    }

    @DeleteMapping("/deleteproduct/{id}")
    public boolean delete(@PathVariable("id") int id) {
        if (service.delete(id)) {
            return true;
        } else {
            return false;
        }
    }



}
