package com.reservation.repository;

import com.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    List<Reservation> getAllByProviderId(String providerId);
    List<Reservation> getAllByClientId(String clientId);
    List<Reservation> getAllByPostId(@NotBlank String postId);
    Optional<Reservation> getById(Long id);
}
