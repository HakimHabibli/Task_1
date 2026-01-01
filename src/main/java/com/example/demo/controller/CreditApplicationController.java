package com.example.demo.controller;


import com.example.demo.domain.model.CreditApplication;
import com.example.demo.domain.model.Customer;
import com.example.demo.domain.repository.InMemoryStorage;
import com.example.demo.domain.service.LoanProcessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/credit")
@RequiredArgsConstructor
public class CreditApplicationController
{
        private final LoanProcessingService loanService;
        private final InMemoryStorage storage;

        @PostMapping("/apply")
        public CreditApplication apply(@RequestBody Customer customer,
                                       @RequestParam BigDecimal amount,
                                       @RequestParam int term) {

            // 1. Hesablama məntiqini çağırırıq
            CreditApplication application = loanService.calculateLoan(customer, amount, term);

            // 2. Unikal ID veririk (Baza olmadığı üçün UUID istifadə edirik)
            application.setApplicationId(UUID.randomUUID().toString().substring(0, 8));

            // 3. Yaddaşda saxlayırıq
            storage.save(application);

            return application;
        }

        @GetMapping("/{id}")
        public CreditApplication getStatus(@PathVariable String id) {
            return storage.getById(id);
        }

}
