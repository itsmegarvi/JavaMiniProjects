package com.mis.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class PhoneNumbers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(nullable = false,unique = true)
    private String phoneNumber;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="personId")
//    private Contact contact;

}
