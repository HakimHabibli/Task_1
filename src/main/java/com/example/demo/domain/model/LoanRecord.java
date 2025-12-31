package com.example.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class LoanRecord { 
    private String bankName;
    private BigDecimal monthlyPayment;
    private boolean isActive;
}
