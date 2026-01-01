package com.example.demo.domain.model;


import lombok.Getter;
import lombok.Setter;

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
}

