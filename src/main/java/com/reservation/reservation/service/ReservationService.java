package com.reservation.reservation.service;

import com.reservation.reservation.entity.Reservation;
import com.reservation.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    public Reservation save(Reservation reservation){
        return reservationRepository.saveAndFlush(reservation);
    }

    public List<Reservation> getAllByProviderId(Long providerId){
        return reservationRepository.getAllByProviderId(providerId);
    }

    public List<Reservation> getAllByClientId(Long clientId){
        return reservationRepository.getAllByClientId(clientId);
    }

    public Reservation markReservationAsAnswered(Long resId){
        return reservationRepository.getOne(resId); //TEMPORAL
    }
}
