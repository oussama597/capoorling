package com.example.MiniProjet.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Trajet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lieuDepart;
    private String lieuFinal;
    private int placesDisponible;
    private LocalDateTime heure;

    // 🔗 Relation avec Conducteur
    @ManyToOne
    @JoinColumn(name = "conducteur_id")
    private Conducteur conducteur;

    // 🔗 Relation avec Passager (plusieurs passagers peuvent réserver un trajet)
    @ManyToMany(mappedBy = "trajets")
    @JsonIgnore
    private List<Passager> passagers = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getLieuDepart() {
        return lieuDepart;
    }

    public String getLieuFinal() {
        return lieuFinal;
    }

    public int getPlacesDisponible() {
        return placesDisponible;
    }

    public LocalDateTime getHeure() {
        return heure;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLieuDepart(String lieuDepart) {
        this.lieuDepart = lieuDepart;
    }

    public void setLieuFinal(String lieuFinal) {
        this.lieuFinal = lieuFinal;
    }

    public void setPlacesDisponible(int placesDisponible) {
        this.placesDisponible = placesDisponible;
    }

    public void setHeure(LocalDateTime heure) {
        this.heure = heure;
    }

    public Conducteur getConducteur() { return conducteur; }
    public void setConducteur(Conducteur conducteur) { this.conducteur = conducteur; }

    public List<Passager> getPassagers() { return passagers; }
    public void setPassagers(List<Passager> passagers) { this.passagers = passagers; }
}
