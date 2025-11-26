package com.example.MiniProjet.repository;

import com.example.MiniProjet.model.Conducteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ConducteurRepository extends JpaRepository<Conducteur, Long> {

}