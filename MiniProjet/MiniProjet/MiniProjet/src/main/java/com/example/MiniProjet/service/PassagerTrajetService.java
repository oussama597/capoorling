package com.example.MiniProjet.service;

import com.example.MiniProjet.model.Passager;
import com.example.MiniProjet.model.Trajet;
import com.example.MiniProjet.repository.PassagerRepository;
import com.example.MiniProjet.repository.TrajetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassagerTrajetService {

    @Autowired
    private PassagerRepository passagerRepository;

    @Autowired
    private TrajetRepository trajetRepository;

    // 🚗 Réserver un trajet
    public Trajet reserverTrajet(Long passagerId, Long trajetId) {
        Passager passager = passagerRepository.findById(passagerId)
                .orElseThrow(() -> new RuntimeException("Passager non trouvé"));
        Trajet trajet = trajetRepository.findById(trajetId)
                .orElseThrow(() -> new RuntimeException("Trajet non trouvé"));

        passager.getTrajets().add(trajet);
        trajet.getPassagers().add(passager);

        passagerRepository.save(passager);
        return trajet;
    }

    // 🔍 Lister les trajets réservés par un passager
    public List<Trajet> getTrajetsByPassager(Long passagerId) {
        Passager passager = passagerRepository.findById(passagerId)
                .orElseThrow(() -> new RuntimeException("Passager non trouvé"));
        return passager.getTrajets();
    }
}