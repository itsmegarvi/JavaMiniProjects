package com.mis.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long personId;
    @Column(name = "name",nullable = false)
    private String name;
    private String emails;
    private String dob;

    @OneToMany(targetEntity = PhoneNumbers.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pid",referencedColumnName = "personId")
    private List<PhoneNumbers> phoneNums;
}
