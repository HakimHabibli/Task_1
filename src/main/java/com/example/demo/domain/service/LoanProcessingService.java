package com.example.demo.domain.service;


import com.example.demo.domain.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanProcessingService
{
    private final MockDataService mockDataService;

    public CreditApplication calculateLoan(Customer customer, BigDecimal amount, int term) {
        // 1. Mock dataları FIN-ə görə yığırıq
        String fin = customer.getFinCode();
        List<IncomeRecord> incomes = mockDataService.getIncomes(fin);
        List<LoanRecord> loans = mockDataService.getLoans(fin);
        int score = mockDataService.getScore(fin);

        // 2. Hesablamalar
        BigDecimal totalIncome = incomes.stream()
                .map(IncomeRecord::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal currentDebts = loans.stream()
                .filter(LoanRecord::isActive)
                .map(LoanRecord::getMonthlyPayment)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // Yeni kreditin aylıq ödənişi (Məbləğ / Müddət)
        BigDecimal newPayment = amount.divide(BigDecimal.valueOf(term), 2, RoundingMode.HALF_UP);

        // DTI Hesablanması
        double dti = (currentDebts.add(newPayment)).doubleValue() / totalIncome.doubleValue();

        // 3. Application obyektini hazırlayırıq
        CreditApplication app = new CreditApplication();
        app.setCustomer(customer);
        app.setRequestedAmount(amount);
        app.setTerm(term);
        app.setCalculatedDti(dti);
        app.setCreditScore(score);
        app.setMonthlyPayment(newPayment);

        // 4. Sənin Enum statuslarına uyğun qərar (Logic Gate)
        if (dti <= 0.40 && score >= 700) {
            app.setStatus(CreditProgress.APPROVED);
        } else if (dti > 0.65 || score < 400) {
            app.setStatus(CreditProgress.REJECT);
        } else {
            // Əgər ortadadırsa və ya gəlir ucu-ucunadırsa
            app.setStatus(CreditProgress.MANUAL_WAITING);
        }

        return app;
    }
}
