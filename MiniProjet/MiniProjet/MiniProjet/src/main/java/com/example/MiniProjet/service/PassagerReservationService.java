package com.example.MiniProjet.service;


import com.example.MiniProjet.model.Passager;
import com.example.MiniProjet.model.Reservation;
import com.example.MiniProjet.model.Trajet;
import com.example.MiniProjet.repository.PassagerRepository;
import com.example.MiniProjet.repository.ReservationRepository;
import com.example.MiniProjet.repository.TrajetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.time.LocalDateTime;

@Service
public class PassagerReservationService {

    @Autowired
    private PassagerRepository passagerRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private TrajetRepository trajetRepository;

    // 🟢 Créer une réservation avec vérification des places
    public Reservation creerReservation(Long passagerId, Long trajetId, Reservation reservation) {
        Passager passager = passagerRepository.findById(passagerId)
                .orElseThrow(() -> new RuntimeException("Passager introuvable avec ID : " + passagerId));

        Trajet trajet = trajetRepository.findById(trajetId)
                .orElseThrow(() -> new RuntimeException("Trajet introuvable avec ID : " + trajetId));

        // 🚨 Vérification des places disponibles
        if (trajet.getPlacesDisponible() <= 0) {
            throw new RuntimeException("Aucune place disponible pour ce trajet !");
        }

        // 🔽 Réduire le nombre de places disponibles
        trajet.setPlacesDisponible(trajet.getPlacesDisponible() - 1);
        trajetRepository.save(trajet);

        // 🔗 Lier passager et trajet à la réservation
        reservation.setPassager(passager);
        reservation.setTrajet(trajet);
        reservation.setStatus("CONFIRMÉE");
        reservation.setReservation(LocalDateTime.now());

        return reservationRepository.save(reservation);
    }

    // 🔍 Lister les réservations d’un passager
    public List<Reservation> getReservationsByPassager(Long passagerId) {
        Passager passager = passagerRepository.findById(passagerId)
                .orElseThrow(() -> new RuntimeException("Passager non trouvé"));
        return passager.getReservations();
    }

    // ❌ Supprimer une réservation
    public void supprimerReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }
}
