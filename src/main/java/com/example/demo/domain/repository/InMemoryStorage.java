
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


    public void save(CreditApplication app) {
        if (app.getApplicationId() != null) {
            applications.put(app.getApplicationId(), app);
        }
    }


    public CreditApplication getById(String id) {
        return applications.get(id);
    }


    public List<CreditApplication> getAll() {
        return new ArrayList<>(applications.values());
    }


    public List<CreditApplication> getAllApplications() {
        return getAll();
    }
}
