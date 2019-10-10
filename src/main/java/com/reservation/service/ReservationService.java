package com.reservation.service;

import com.reservation.entity.Reservation;
import com.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Reservation> getAll(){
        return reservationRepository.findAll();
    }

    public List<Reservation> getAllByPostId(String postId){
        return reservationRepository.getAllByPostId(postId);
    }

    public Optional<Reservation> getReservationById(Long id){
        return reservationRepository.findById(id);
    }

    public Reservation markReservationAsAnswered(Long resId){
        return reservationRepository.getOne(resId);
    }


    public void rejectReservation(Long resId){
        reservationRepository.deleteById(resId);
    }
}
