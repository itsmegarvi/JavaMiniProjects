package com.service;

import com.VO.Department;
import com.VO.ResponseTemplateVO;
import com.entity.Users;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Users add(Users u){
        return userRepository.save(u);
    }

    @Autowired
    RestTemplate restTemplate;

    public ResponseTemplateVO getUserByDepartment(Long userid){
        ResponseTemplateVO obj = new ResponseTemplateVO();
        Users user = userRepository.findByUserId(userid);
        System.out.println("hi"+user);
        Department department = restTemplate.getForObject("http://department-service/departments/getbyid/"+user.getDepartmentId(), Department.class);
        System.out.println("hello"+department);
        obj.setUser(user);
        obj.setDepartment(department);
        return obj;
    }

    public String getDepartmentName(String email){
        Users user = userRepository.findByEmailId(email);
        System.out.println(user);
        Department department = restTemplate.getForObject("http://department-service/departments/getbyid/"+user.getDepartmentId(), Department.class);
        System.out.println(department);
        return department.getDepartmentName();
    }


    //First doing it without exceptions
    //Then try with taking care of exceptions
    public Department modifyDepartment(Long id, String depName){
        Users user = userRepository.findByUserId(id);
        System.out.println(user);
        Department department = restTemplate.getForObject("http://department-service/departments/getbyid/"+user.getDepartmentId(),Department.class);
        System.out.println(department);
        assert department != null;
        department.setDepartmentName(depName);
        restTemplate.put("http://department-service/departments/update/"+department.getDepartmentId()+"/" + department.getDepartmentName(),Department.class);
        return department;
    }

    public List<Users> getDepartmentUsers(Long departmentId){
        return userRepository.findAllByDepartmentId(departmentId);
    }
}
