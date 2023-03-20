package com.mis.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Item {

    @Id
    private Long id;

    private String itemName;
    private String itemCode;

}
