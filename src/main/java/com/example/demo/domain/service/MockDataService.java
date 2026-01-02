package com.example.demo.domain.service;

import com.example.demo.domain.model.IncomeRecord;
import com.example.demo.domain.model.LoanRecord;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MockDataService {


    public List<IncomeRecord> getIncomes(String fin)
    {
        return switch (fin) {
            case "GOOD001" -> List.of(
                    new IncomeRecord("PASHA Bank", new BigDecimal("3500")),
                    new IncomeRecord("Freelance", new BigDecimal("500"))
            );
            case "BAD002" -> List.of(
                    new IncomeRecord("Kiçik Market", new BigDecimal("550"))
            );
            default -> List.of( // Orta müştəri ssenarisi üçün
                    new IncomeRecord("Dövlət İdarəsi", new BigDecimal("1200"))
            );
        };
    }


    public List<LoanRecord> getLoans(String fin) {
        return switch (fin) {
            case "GOOD001" -> List.of(
                    new LoanRecord("Kapital Bank", new BigDecimal("200"), true),
                    new LoanRecord("Unibank", new BigDecimal("150"), false)
            );
            case "BAD002" -> List.of(
                    new LoanRecord("Bank X", new BigDecimal("300"), true),
                    new LoanRecord("Bank Y", new BigDecimal("150"), true),
                    new LoanRecord("BOKT Z", new BigDecimal("100"), true)
            );
            default -> List.of(
                    new LoanRecord("Kapital Bank", new BigDecimal("400"), true)
            );
        };
    }

    public int getScore(String fin) {
        return switch (fin) {
            case "GOOD001" -> 850;
            case "BAD002" -> 350;
            default -> 600;
        };
    }
}
