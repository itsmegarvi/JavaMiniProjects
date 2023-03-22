package com.mis.vo;

import com.mis.entity.CurrencyConversion;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseTemplate {
    CurrencyConversion cc;
    ExchangeValue ev;
}
