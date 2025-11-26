package com.example.MiniProjet.service;

import com.example.MiniProjet.model.Reservation;
import com.example.MiniProjet.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    // 🟢 1. Créer une réservation (simple)
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // 🟢 2. Modifier une réservation
    public Reservation updateReservation(Long id, Reservation newReservation) {
        Reservation existing = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation introuvable avec ID : " + id));

        existing.setReservation(newReservation.getReservation());
        existing.setStatus(newReservation.getStatus());
        return reservationRepository.save(existing);
    }

    // 🟢 3. Supprimer une réservation
    public void deleteReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation introuvable avec ID : " + id));
        reservationRepository.delete(reservation);
    }

    // 🟢 4. Obtenir toutes les réservations
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    // 🟢 5. Obtenir une réservation par ID
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation introuvable avec ID : " + id));
    }
}