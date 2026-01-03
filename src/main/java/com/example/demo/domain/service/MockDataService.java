package com.example.demo.domain.service;

import com.example.demo.domain.model.Customer;
import com.example.demo.domain.model.IncomeRecord;
import com.example.demo.domain.model.LoanRecord;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MockDataService {

        public void fillCustomerDetails(Customer customer) {
            String fin = customer.getFinCode() != null ? customer.getFinCode().toUpperCase() : "";

            switch (fin) {
                case "GOOD001" -> {

                    customer.setFirstName("Əli");
                    customer.setLastName("Məmmədov");
                    customer.setFatherName("Vaqif");
                    customer.setIdentitySeries("AZE12345678");


                    customer.setAddress("Bakı ş., Nərimanov r., Təbriz küç. 45");
                    customer.setWorkplace("TechBehemoths LLC");


                    customer.setOfficialIncome(new BigDecimal("3500"));
                    customer.setUnofficialIncome(new BigDecimal("500"));
                    customer.setHasBankStatement(true);


                    customer.setFamilyStatus("Evli");
                    customer.setSocialStatus("Özəl Sektor İşçisi");
                    customer.setCifCode("CIF100001");
                }
                case "BAD002" -> {
                    customer.setFirstName("Leyla");
                    customer.setLastName("Həsənova");
                    customer.setFatherName("Anar");
                    customer.setIdentitySeries("AZE99887766");

                    customer.setAddress("Sumqayıt ş., 10-cu mikrorayon");
                    customer.setWorkplace("Kiçik Market");

                    customer.setOfficialIncome(new BigDecimal("550"));
                    customer.setUnofficialIncome(BigDecimal.ZERO);
                    customer.setHasBankStatement(false);

                    customer.setFamilyStatus("Subay");
                    customer.setSocialStatus("Tələbə");
                    customer.setCifCode("CIF200002");
                }
                default -> {
                    customer.setFirstName("Kamran");
                    customer.setLastName("Əliyev");
                    customer.setFatherName("Murad");
                    customer.setIdentitySeries("AZE55443322");

                    customer.setAddress("Gəncə ş., Atatürk prospekti");
                    customer.setWorkplace("Dövlət Agentliyi");

                    customer.setOfficialIncome(new BigDecimal("1200"));
                    customer.setUnofficialIncome(new BigDecimal("300"));
                    customer.setHasBankStatement(true);

                    customer.setFamilyStatus("Evli");
                    customer.setSocialStatus("Dövlət Qulluqçusu");
                    customer.setCifCode("CIF000000");
                }
            }
        }

        public List<IncomeRecord> getIncomes(String finCode) {
            if (finCode == null) return List.of();
            return switch (finCode.toUpperCase()) {
                case "GOOD001" -> List.of(
                        new IncomeRecord("ABB", new BigDecimal("3500")),
                        new IncomeRecord("Freelance", new BigDecimal("500"))
                );
                case "BAD002" -> List.of(new IncomeRecord("Kiçik Market", new BigDecimal("550")));
                default -> List.of(new IncomeRecord("Dövlət İdarəsi", new BigDecimal("1200")));
            };
        }

        public List<LoanRecord> getLoans(String finCode) {
            if (finCode == null) return List.of();
            return switch (finCode.toUpperCase()) {
                case "GOOD001" -> List.of(
                        new LoanRecord("Kapital Bank", new BigDecimal("200"), true),
                        new LoanRecord("Unibank", new BigDecimal("150"), false)
                );
                case "BAD002" -> List.of(
                        new LoanRecord("Bank X", new BigDecimal("300"), true),
                        new LoanRecord("Bank Y", new BigDecimal("150"), true)
                );
                default -> List.of(new LoanRecord("Kapital Bank", new BigDecimal("400"), true));
            };
        }

        public int getScore(String finCode) {
            if (finCode == null) return 0;
            return switch (finCode.toUpperCase()) {
                case "GOOD001" -> 850;
                case "BAD002" -> 350;
                default -> 600;
            };
        }
}
