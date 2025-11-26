package com.example.MiniProjet.controller;


import com.example.MiniProjet.model.Trajet;
import com.example.MiniProjet.service.TrajetService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trajets")
@CrossOrigin(origins = "*")
public class TrajetController {


    @Autowired
    private TrajetService trajetService;

    // ➕ Créer un trajet
    @PostMapping("/create")
    public Trajet createTrajet(@RequestBody Trajet trajet) {
        return trajetService.createTrajet(trajet);
    }

    // 🔍 Obtenir tous les trajets
    @GetMapping("/all")
    public List<Trajet> getAllTrajets() {
        return trajetService.getAllTrajets();
    }

    // 🔎 Obtenir un trajet par ID
    @GetMapping("/{id}")
    public Trajet getTrajetById(@PathVariable Long id) {
        return trajetService.getTrajetById(id);
    }

    // 🔄 Mettre à jour un trajet
    @PutMapping("/update/{id}")
    public Trajet updateTrajet(@PathVariable Long id, @RequestBody Trajet trajet) {
        return trajetService.updateTrajet(id, trajet);
    }

    // ❌ Supprimer un trajet
    @DeleteMapping("/delete/{id}")
    public String deleteTrajet(@PathVariable Long id) {
        trajetService.deleteTrajet(id);
        return "Trajet supprimé avec succès ✅";
    }

    // 🔍 Rechercher des trajets
    @GetMapping("/search")
    public List<Trajet> searchTrajets(@RequestParam String keyword) {
        return trajetService.searchTrajets(keyword);
    }


}

