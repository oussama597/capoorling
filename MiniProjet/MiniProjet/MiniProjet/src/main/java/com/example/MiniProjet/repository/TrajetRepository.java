package com.example.MiniProjet.repository;

import com.example.MiniProjet.model.Trajet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TrajetRepository extends JpaRepository<Trajet, Long> {
    Optional<Trajet> findByLieuDepart(String lieuDépart);
    List<Trajet> findByLieuDepartContainingIgnoreCase(String keyword);
    List<Trajet> findByLieuFinalContainingIgnoreCase(String keyword);

}