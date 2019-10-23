package com.reservation.repository;

import com.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.validation.constraints.NotBlank;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    public List<Reservation> getAllByProviderId(String providerId);
    public List<Reservation> getAllByClientId(String clientId);
    public List<Reservation> getAllByPostId(@NotBlank String postId);
}
