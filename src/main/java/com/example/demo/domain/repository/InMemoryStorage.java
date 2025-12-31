
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
        applications.put(app.getApplicationId(), app);
    }

    public List<CreditApplication> getAllApplications() {
        return new ArrayList<>(applications.values());
    }
}
