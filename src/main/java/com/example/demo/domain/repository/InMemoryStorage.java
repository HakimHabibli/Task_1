
package com.example.demo.domain.repository;

import com.example.demo.domain.model.CreditApplication;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryStorage {

    private final Map<String, CreditApplication> applications = new ConcurrentHashMap<>();

    // Yeni müraciəti yaddaşa yazmaq və ya olanı yeniləmək üçün
    public void save(CreditApplication app) {
        if (app.getApplicationId() != null) {
            applications.put(app.getApplicationId(), app);
        }
    }

    // ID-yə görə tək bir müraciəti tapmaq üçün (Controller bunu tələb edir)
    public CreditApplication getById(String id) {
        return applications.get(id);
    }

    // Bütün müraciətləri siyahı şəklində qaytarmaq üçün
    public List<CreditApplication> getAll() {
        return new ArrayList<>(applications.values());
    }

    // Əgər getAllApplications adından istifadə etmək istəsən, getAll-u ona yönləndirə bilərsən
    public List<CreditApplication> getAllApplications() {
        return getAll();
    }
}
