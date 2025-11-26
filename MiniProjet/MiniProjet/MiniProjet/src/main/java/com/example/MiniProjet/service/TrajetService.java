package com.example.MiniProjet.service;


import com.example.MiniProjet.model.Trajet;
import com.example.MiniProjet.repository.TrajetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrajetService {

    @Autowired
    private TrajetRepository trajetRepository;



    // ➕ 1. Créer un trajet
    public Trajet createTrajet(Trajet trajet) {
        if (trajet.getLieuDepart() == null || trajet.getLieuFinal() == null) {
            throw new RuntimeException("Les lieux de départ et d’arrivée sont obligatoires.");
        }
        return trajetRepository.save(trajet);
    }

    // 🔍 2. Obtenir tous les trajets
    public List<Trajet> getAllTrajets() {
        List<Trajet> trajets = trajetRepository.findAll();
        if (trajets.isEmpty()) {
            throw new RuntimeException("Aucun trajet trouvé.");
        }
        return trajets;
    }

    // 🔎 3. Obtenir un trajet par ID
    public Trajet getTrajetById(Long id) {
        return trajetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trajet introuvable avec ID : " + id));
    }

    // ❌ 4. Supprimer un trajet
    public void deleteTrajet(Long id) {
        Trajet t = getTrajetById(id);
        trajetRepository.delete(t);
    }

    // 🔄 5. Mettre à jour un trajet
    public Trajet updateTrajet(Long id, Trajet newTrajet) {
        Trajet existing = getTrajetById(id);
        existing.setLieuDepart(newTrajet.getLieuDepart());
        existing.setLieuFinal(newTrajet.getLieuFinal());
        existing.setHeure(newTrajet.getHeure());
        existing.setPlacesDisponible(newTrajet.getPlacesDisponible());
        return trajetRepository.save(existing);
    }

    // 🔍 6. Recherche de trajets (par lieu de départ ou d’arrivée)
    public List<Trajet> searchTrajets(String keyword) {
        List<Trajet> byDepart = trajetRepository.findByLieuDepartContainingIgnoreCase(keyword);
        List<Trajet> byFinal = trajetRepository.findByLieuFinalContainingIgnoreCase(keyword);

        List<Trajet> result = new ArrayList<>();
        result.addAll(byDepart);

        // Éviter les doublons
        for (Trajet t : byFinal) {
            if (!result.contains(t)) {
                result.add(t);
            }
        }

        if (result.isEmpty()) {
            throw new RuntimeException("Aucun trajet trouvé pour : " + keyword);
        }

        return result;
    }

}
