package com.mis.service;

import com.mis.entity.Address;
import com.mis.entity.Student;
import com.mis.exception.InvalidStudentIDException;
import com.mis.repository.AddressRepository;
import com.mis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AddressRepository addressRepository;

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }
    //Since we are using cascading we don't need to make addAddress as when
    // one row gets created in one the corresponding rows for other also gets created

    public List<Address> getAddresses(Long id){
        return addressRepository.findByStudentId(id);
    }

    public Student modifyAddress(long id,List<Address> addresses) throws InvalidStudentIDException{
        Student s = studentRepository.findById(id).orElseThrow(()->new InvalidStudentIDException("Student with given ID doesn't exists"));
            s.setAddress(addresses);
            return studentRepository.save(s);
    }
}
