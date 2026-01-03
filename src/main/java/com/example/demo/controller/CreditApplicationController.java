package com.example.demo.controller;


import com.example.demo.domain.model.CreditApplication;
import com.example.demo.domain.model.Customer;
import com.example.demo.domain.repository.InMemoryStorage;
import com.example.demo.domain.service.LoanProcessingService;
import com.example.demo.domain.service.MockDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/credit")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class CreditApplicationController
{
        private final LoanProcessingService loanService;
        private final InMemoryStorage storage;
        private final MockDataService mockDataService;

        @PostMapping("/apply")
        public CreditApplication apply(@RequestBody Customer customer,
                                       @RequestParam BigDecimal amount,
                                       @RequestParam int term) {


            mockDataService.fillCustomerDetails(customer);


            CreditApplication application = loanService.calculateLoan(customer, amount, term);

            application.setApplicationId(UUID.randomUUID().toString().substring(0, 8));
            storage.save(application);

            return application;
        }

        @GetMapping("/{id}")
        public CreditApplication getStatus(@PathVariable String id) {
            return storage.getById(id);
        }

}
