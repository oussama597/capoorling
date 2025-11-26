package com.example.MiniProjet.controller;


import com.example.MiniProjet.model.Passager;
import com.example.MiniProjet.service.PassagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passagers")
@CrossOrigin(origins = "*")
public class PassagerController {

    @Autowired
    private PassagerService passagerService;

    // 🟢 1. Inscription d’un passager
    @PostMapping
    public ResponseEntity<?> createPassager(@RequestBody Passager passager) {
        try {
            Passager newPassager = passagerService.createPassager(passager);
            return ResponseEntity.status(HttpStatus.CREATED).body(newPassager);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // 🟢 2. Modifier un compte passager
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePassager(@PathVariable Long id, @RequestBody Passager passager) {
        try {
            Passager updated = passagerService.updatePassager(id, passager);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // 🟢 3. Supprimer un compte passager
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePassager(@PathVariable Long id) {
        try {
            passagerService.deletePassager(id);
            return ResponseEntity.ok("Passager supprimé avec succès.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // 🟢 4. Obtenir tous les passagers
    @GetMapping
    public ResponseEntity<?> getAllPassagers() {
        try {
            List<Passager> passagers = passagerService.getAllPassagers();
            return ResponseEntity.ok(passagers);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}