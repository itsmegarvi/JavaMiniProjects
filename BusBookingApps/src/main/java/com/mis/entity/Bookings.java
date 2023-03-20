package com.mis.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter @Getter @NoArgsConstructor @AllArgsConstructor @ToString
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long bookingId;

    private int seatNum;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "busName",referencedColumnName = "busName")
    @JsonBackReference
    private Bus bus;
}
