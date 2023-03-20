package com.mis.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long emailId;

    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personId")
    @JsonBackReference
    private Contact contact;
}
