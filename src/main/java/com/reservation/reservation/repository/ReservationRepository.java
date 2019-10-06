package com.reservation.reservation.repository;

import com.reservation.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    public List<Reservation> getAllByProviderId(Long providerId);
    public List<Reservation> getAllByClientId(Long clientId);
    public List<Reservation> getAllByPostId(String postId);
}
