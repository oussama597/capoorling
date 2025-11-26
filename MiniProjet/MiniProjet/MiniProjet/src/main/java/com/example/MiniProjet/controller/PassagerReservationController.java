package com.example.MiniProjet.controller;

import com.example.MiniProjet.model.Reservation;
import com.example.MiniProjet.service.PassagerReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@CrossOrigin(origins = "*")
public class PassagerReservationController {

    @Autowired
    private PassagerReservationService passagerReservationService;

    // 🟢 1. Créer une réservation pour un passager sur un trajet
    @PostMapping("/create/{passagerId}/{trajetId}")
    public ResponseEntity<?> creerReservation(
            @PathVariable Long passagerId,
            @PathVariable Long trajetId,
            @RequestBody Reservation reservation) {

        try {
            Reservation nouvelleReservation = passagerReservationService.creerReservation(passagerId, trajetId, reservation);
            return ResponseEntity.status(HttpStatus.CREATED).body(nouvelleReservation);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/passager/{passagerId}")
    public List<Reservation> getReservationsByPassager(@PathVariable Long passagerId) {
        return passagerReservationService.getReservationsByPassager(passagerId);
    }

    @DeleteMapping("/{reservationId}")
    public void supprimerReservation(@PathVariable Long reservationId) {
        passagerReservationService.supprimerReservation(reservationId);
    }
}