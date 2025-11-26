package com.example.MiniProjet.repository;

import com.example.MiniProjet.model.Passager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PassagerRepository extends JpaRepository<Passager, Long> {

}