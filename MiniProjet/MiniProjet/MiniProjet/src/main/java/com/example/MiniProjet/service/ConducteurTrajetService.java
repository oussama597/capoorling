package com.example.MiniProjet.service;


import com.example.MiniProjet.model.Conducteur;
import com.example.MiniProjet.model.Trajet;
import com.example.MiniProjet.repository.ConducteurRepository;
import com.example.MiniProjet.repository.TrajetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConducteurTrajetService {

    @Autowired
    private ConducteurRepository conducteurRepository;

    @Autowired
    private TrajetRepository trajetRepository;

    // ➕ Ajouter un trajet à un conducteur
    public Trajet ajouterTrajet(Long conducteurId, Trajet trajet) {
        Conducteur conducteur = conducteurRepository.findById(conducteurId)
                .orElseThrow(() -> new RuntimeException("Conducteur non trouvé"));
        trajet.setConducteur(conducteur); // association
        return trajetRepository.save(trajet);
    }

    // 🔍 Obtenir tous les trajets d’un conducteur
    public List<Trajet> getTrajetsByConducteur(Long conducteurId) {
        Conducteur conducteur = conducteurRepository.findById(conducteurId)
                .orElseThrow(() -> new RuntimeException("Conducteur non trouvé"));
        return conducteur.getTrajets();
    }
}
