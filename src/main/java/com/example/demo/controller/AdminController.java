package com.example.demo.controller;

import com.example.demo.domain.model.CreditApplication;
import com.example.demo.domain.model.CreditProgress;
import com.example.demo.domain.repository.InMemoryStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController
{
    private final InMemoryStorage storage;

    @GetMapping("/applications")
    public List<CreditApplication> getAll() {
        return storage.getAll();
    }

    @PatchMapping("/decide/{id}")
    public String makeDecision(@PathVariable String id, @RequestParam CreditProgress decision) {
        CreditApplication app = storage.getById(id);
        if (app != null && app.getStatus() == CreditProgress.MANUAL_WAITING) {
            app.setStatus(decision);
            storage.save(app);
            return "Müraciət statusu yeniləndi: " + decision;
        }
        return "Müraciət tapılmadı və ya manual gözləmədə deyil.";
    }
}
