package com.example.demo.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Data
@Setter
@Getter
public class CreditApplication {
    private String applicationId;
    private Customer customer;
    private BigDecimal requestedAmount;
    private Integer term;

    private BigDecimal monthlyPayment;

    private CreditProgress status;
    private Double calculatedDti;
    private Integer creditScore;

}
