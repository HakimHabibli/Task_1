package com.example.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class IncomeRecord 
{ 
    private String source;
    private BigDecimal amount;
}
