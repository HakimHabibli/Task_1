package com.example.demo.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreditApplication {
    private String applicationId;
    private Customer customer;
    private BigDecimal requestedAmount;
    private Integer term;
    private CreditProgress status;
    private Double calculatedDti;
    private Integer creditScore;

}
