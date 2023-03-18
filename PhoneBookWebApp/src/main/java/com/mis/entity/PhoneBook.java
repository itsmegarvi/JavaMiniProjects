package com.mis.entity;

import com.mis.model.Email;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
public class PhoneBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long personId;
    private String name;
    private String emails;
    private String dob;

    @OneToMany(targetEntity = PhoneNumbers.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pid",referencedColumnName = "personId")
    private List<PhoneNumbers> phoneNums;
}
