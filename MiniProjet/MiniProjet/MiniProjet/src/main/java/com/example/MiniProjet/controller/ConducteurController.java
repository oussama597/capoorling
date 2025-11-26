package com.example.MiniProjet.controller;


import com.example.MiniProjet.model.Conducteur;
import com.example.MiniProjet.service.ConducteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/conducteurs")
public class ConducteurController {


    @Autowired
    private ConducteurService conducteurService;

    // ➕ Ajouter un conducteur
    @PostMapping("/create")
    public Conducteur createConducteur(@RequestBody Conducteur conducteur) {
        return conducteurService.createConducteur(conducteur);
    }

    // 🔄 Modifier un conducteur
    @PutMapping("/update/{id}")
    public Conducteur updateConducteur(@PathVariable Long id, @RequestBody Conducteur conducteur) {
        return conducteurService.updateConducteur(id, conducteur);
    }

    // ❌ Supprimer un conducteur
    @DeleteMapping("/delete/{id}")
    public String deleteConducteur(@PathVariable Long id) {
        conducteurService.deleteConducteur(id);
        return "Conducteur supprimé avec succès ✅";
    }
}