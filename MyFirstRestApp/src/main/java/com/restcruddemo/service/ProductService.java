package com.restcruddemo.service;

import com.restcruddemo.exception.InvalidProductIDException;
import com.restcruddemo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private static ProductService instance;

    private static List<Product> data = new ArrayList<>();

    static{
        data.add(new Product(1,"PS5",85000.87f));
        data.add(new Product(2,"XBOX360",45000.52f));
    }

    public ProductService(){

    }

    public List<Product>listAll(){
        return new ArrayList<Product>(data);
    }

    public boolean add(Product product){
        data.add(product);
        return true;
    }

    public Product get(int id) throws InvalidProductIDException {
        boolean flag=false;
        for(Product p1:data)
        {
            if(p1.getId()==id)
            { flag=true;
                return p1;

            }
        }
        if(flag==false)
        {
            throw new InvalidProductIDException("product Id doesn't exist");
            //return false;
        }

        return null;

    }

    public boolean delete(int id) {

        List<Product> list=new ArrayList();
        boolean flag=false;
        for(Product l:data)
        {
            if(l.getId()==id)
            {
                list.add(l);

            }

        }

        flag=data.removeAll(list);
        System.out.println(flag);
        return flag;

    }

    public boolean update(int  productid) {
        boolean flag=false;
        for(Product l:data)
        {
            if(l.getId()==productid)
            {
                l.setName("AAA");
                flag=true;
            }

        }
        return flag;
    }

    public boolean addProductList(List<Product> p){
        data.addAll(p);
        return true;
    }

    public Product searchByName(String name){
         return data.stream().filter(x->x.getName().equals(name)).findFirst().orElse(null);
    }

    public List<Product> searchBySubString(String str){
        return data.stream().filter(x->x.getName().contains(str)).collect(Collectors.toList());
    }

}

