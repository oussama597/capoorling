package com.example.MiniProjet.repository;

import com.example.MiniProjet.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}