package com.example.MiniProjet.controller;


import com.example.MiniProjet.model.Trajet;
import com.example.MiniProjet.service.ConducteurTrajetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conducteurs")
@CrossOrigin(origins = "*")
public class ConducteurTrajetController {

    @Autowired
    private ConducteurTrajetService conducteurTrajetService;

    @PostMapping("/{conducteurId}/trajets")
    public Trajet ajouterTrajet(@PathVariable Long conducteurId, @RequestBody Trajet trajet) {
        return conducteurTrajetService.ajouterTrajet(conducteurId, trajet);
    }

    @GetMapping("/{conducteurId}/trajets")
    public List<Trajet> getTrajetsByConducteur(@PathVariable Long conducteurId) {
        return conducteurTrajetService.getTrajetsByConducteur(conducteurId);
    }
}
