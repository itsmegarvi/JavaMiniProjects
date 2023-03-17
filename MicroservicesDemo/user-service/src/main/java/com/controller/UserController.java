package com.controller;

import com.VO.Department;
import com.VO.ResponseTemplateVO;
import com.entity.Users;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping("/add")
    public Users addUser(@RequestBody Users u){
        System.out.println(u);
        return service.add(u);
    }

    @GetMapping("/getbydep/{id}")
    public ResponseTemplateVO getUser(@PathVariable("id") Long id){
        return service.getUserByDepartment(id);
    }

    @GetMapping("/getbydepartment/{id}")
    public List<Users> getAllOfDepartment(@PathVariable("id") Long id){
        return service.getDepartmentUsers(id);
    }


    @GetMapping("/getdepname/{email}")
    public String getDepName(@PathVariable("email") String email){
        return service.getDepartmentName(email);
    }

    @PutMapping("/modifydep/{id}/{name}")
    public Department modifyDepartment(@PathVariable("id") Long id, @PathVariable("name") String name) {
        return service.modifyDepartment(id,name);
    }
}
