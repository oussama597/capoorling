package com.example.MiniProjet.service;

import com.example.MiniProjet.model.Conducteur;
import com.example.MiniProjet.repository.ConducteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConducteurService {

    @Autowired
    private ConducteurRepository conducteurRepository;

    // 🟢 1. Inscription (ajout)
    public Conducteur createConducteur(Conducteur conducteur) {
        if (conducteur.getNom() == null || conducteur.getEmail() == null) {
            throw new RuntimeException("Les informations du conducteur sont incomplètes.");
        }
        return conducteurRepository.save(conducteur);
    }

    // 🟢 2. Modification du compte
    public Conducteur updateConducteur(Long id, Conducteur newConducteur) {
        Conducteur existing = conducteurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conducteur introuvable avec ID : " + id));

        existing.setNom(newConducteur.getNom());
        existing.setEmail(newConducteur.getEmail());
        existing.setTel(newConducteur.getTel());

        return conducteurRepository.save(existing);
    }

    // 🟢 3. Suppression du compte
    public void deleteConducteur(Long id) {
        Conducteur conducteur = conducteurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conducteur introuvable avec ID : " + id));
        conducteurRepository.delete(conducteur);
    }
}
