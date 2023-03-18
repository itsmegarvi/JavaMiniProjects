package com.mis.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class PhoneNumbers {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pid;

    @Id
    private Long phoneNumber;

}
