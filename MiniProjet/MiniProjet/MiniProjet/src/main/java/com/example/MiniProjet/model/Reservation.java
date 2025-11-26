package com.example.MiniProjet.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;



@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime reservation;
    private String status;

    @ManyToOne
    @JoinColumn(name = "passager_id")
    private Passager passager;

    // 🔗 Relation avec Trajet
    @ManyToOne
    @JoinColumn(name = "trajet_id")
    private Trajet trajet;

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getReservation() {
        return reservation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setReservation(LocalDateTime reservation) {
        this.reservation = reservation;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Passager getPassager() { return passager; }
    public void setPassager(Passager passager) { this.passager = passager; }

    public Trajet getTrajet() { return trajet; }
    public void setTrajet(Trajet trajet) { this.trajet = trajet; }
}


