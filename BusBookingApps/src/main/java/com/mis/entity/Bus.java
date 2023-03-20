package com.mis.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Bus {
    @Id
    private String busName;

    private int seatCount;
    private int occupancy;

    private String source;
    private String destination;
    private int distance;
    private List<Roles.DAYS> travelDays;
    private String duration;

}
