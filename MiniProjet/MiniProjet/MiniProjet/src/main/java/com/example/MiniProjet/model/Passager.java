package com.example.MiniProjet.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data

public class Passager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private String tel;

    @ManyToMany
    @JoinTable(
            name = "passager_trajet",
            joinColumns = @JoinColumn(name = "passager_id"),
            inverseJoinColumns = @JoinColumn(name = "trajet_id")
    )
    @JsonIgnore
    private List<Trajet> trajets = new ArrayList<>();

    // 🔗 Relation avec Reservation
    @OneToMany(mappedBy = "passager", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Reservation> reservations = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public List<Trajet> getTrajets() { return trajets; }
    public void setTrajets(List<Trajet> trajets) { this.trajets = trajets; }

    public List<Reservation> getReservations() { return reservations; }
    public void setReservations(List<Reservation> reservations) { this.reservations = reservations; }
}