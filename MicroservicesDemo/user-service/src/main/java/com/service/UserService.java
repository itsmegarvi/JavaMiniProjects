package com.service;

import com.VO.Department;
import com.VO.ResponseTemplateVO;
import com.entity.Users;
import com.exception.DepartmentIdDoesNotExistException;
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

    private static final String URL = "http://department-service/departments/getbyid/";

    public ResponseTemplateVO getUserByDepartment(Long userid){
        ResponseTemplateVO obj = new ResponseTemplateVO();
        Users user = userRepository.findByUserId(userid);
        System.out.println("hi"+user);
        Department department = restTemplate.getForObject(URL+user.getDepartmentId(), Department.class);
        System.out.println("hello"+department);
        obj.setUser(user);
        obj.setDepartment(department);
        return obj;
    }

    public String getDepartmentName(String email) throws DepartmentIdDoesNotExistException{
        Users user = userRepository.findByEmailId(email);
        System.out.println(user);
        Department department = restTemplate.getForObject(URL+user.getDepartmentId(), Department.class);
        if(department!=null) {
            System.out.println(department);
            return department.getDepartmentName();
        }
        else {
            throw new DepartmentIdDoesNotExistException("Department ID for the individual does not seem correct");
        }
    }


    //First doing it without exceptions
    //Then try with taking care of exceptions
    public Department modifyDepartment(Long id, String depName) throws DepartmentIdDoesNotExistException {
        Users user = userRepository.findByUserId(id);
        System.out.println(user);
        Department department = restTemplate.getForObject(URL+user.getDepartmentId(),Department.class);
        if(department!=null) {
            System.out.println(department);
            department.setDepartmentName(depName);
            restTemplate.put("http://department-service/departments/update/" + department.getDepartmentId() + "/" + department.getDepartmentName(), Department.class);
            return department;
        }
        else {
            throw new DepartmentIdDoesNotExistException("Department ID for the individual does not seem correct");
        }
    }

    public List<Users> getDepartmentUsers(Long departmentId){
        return userRepository.findAllByDepartmentId(departmentId);
    }
}
