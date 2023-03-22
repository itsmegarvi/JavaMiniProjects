package com.mis.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrencyConversion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long conversionId;
    private String currencyFrom;
    private String currencyTo;
}
