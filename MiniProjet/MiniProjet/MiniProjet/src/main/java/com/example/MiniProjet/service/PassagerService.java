package com.example.MiniProjet.service;


import com.example.MiniProjet.model.Passager;
import com.example.MiniProjet.repository.PassagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassagerService {

    @Autowired
    private PassagerRepository passagerRepository;

    // 🟢 1. Inscription d’un passager
    public Passager createPassager(Passager passager) {
        if (passager.getNom() == null || passager.getEmail() == null) {
            throw new RuntimeException("Le nom et l'email sont obligatoires.");
        }
        return passagerRepository.save(passager);
    }

    // 🟢 2. Modifier un passager
    public Passager updatePassager(Long id, Passager newPassager) {
        Passager existing = passagerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passager introuvable avec ID : " + id));

        existing.setNom(newPassager.getNom());
        existing.setEmail(newPassager.getEmail());
        existing.setTel(newPassager.getTel());
        return passagerRepository.save(existing);
    }

    // 🟢 3. Supprimer un passager
    public void deletePassager(Long id) {
        Passager passager = passagerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passager introuvable avec ID : " + id));
        passagerRepository.delete(passager);
    }

    // 🟢 4. Obtenir tous les passagers
    public List<Passager> getAllPassagers() {
        List<Passager> passagers = passagerRepository.findAll();
        if (passagers.isEmpty()) {
            throw new RuntimeException("Aucun passager trouvé.");
        }
        return passagers;
    }
}