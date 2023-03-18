package com.mis.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class PhoneNumbers {
    private long pid;

    @Id
    private Long phoneNumber;

}
