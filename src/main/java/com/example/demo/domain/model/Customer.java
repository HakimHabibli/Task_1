package com.example.demo.domain.model;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Customer extends BaseEntity
{
   public String firstName;
   public String lastName;
   public String fatherName;
   public String email;
   public String phoneNumber;
   public String finCode;
   public String cifCode;
    public String identitySeries;
    public String address;
    public String workplace;
    public BigDecimal officialIncome;
    public BigDecimal unofficialIncome;
    public boolean hasBankStatement;
    public String familyStatus;
    public String socialStatus;
}

