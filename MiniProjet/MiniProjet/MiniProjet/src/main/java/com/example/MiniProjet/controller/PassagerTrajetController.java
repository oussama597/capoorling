package com.example.MiniProjet.controller;


import com.example.MiniProjet.model.Trajet;
import com.example.MiniProjet.service.PassagerTrajetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passagers")
@CrossOrigin(origins = "*")
public class PassagerTrajetController {

    @Autowired
    private PassagerTrajetService passagerTrajetService;

    @PostMapping("/{passagerId}/trajets/{trajetId}")
    public Trajet reserverTrajet(@PathVariable Long passagerId, @PathVariable Long trajetId) {
        return passagerTrajetService.reserverTrajet(passagerId, trajetId);
    }

    @GetMapping("/{passagerId}/trajets")
    public List<Trajet> getTrajetsByPassager(@PathVariable Long passagerId) {
        return passagerTrajetService.getTrajetsByPassager(passagerId);
    }
}
