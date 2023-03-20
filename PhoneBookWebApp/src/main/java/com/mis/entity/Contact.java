package com.mis.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long personId;

    @Column(nullable = false)
    private String name;
    private String emails;
    private String dob;

    @OneToMany( cascade = CascadeType.ALL,orphanRemoval = true)

    private Set<PhoneNumbers> phoneNums = new HashSet<>();
}
