package com.reservation.service;

import com.reservation.entity.Payment;
import com.reservation.entity.Reservation;
import com.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;
    private PaymentService paymentService;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, PaymentService paymentService) {
        this.reservationRepository = reservationRepository;
        this.paymentService = paymentService;
    }

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

        Optional<Reservation> r = reservationRepository.findById(resId);


        if(r.isPresent()){
            Reservation reservation = r.get();

            reservation.setApproved(true);
            reservationRepository.save(reservation);
            return reservation;

        }else{
            return null;
        }

    }
    public void rejectReservation(Long resId){
        reservationRepository.deleteById(resId);
    }
    public Optional<Reservation> payReservation(Long resId) {

        Optional<Reservation> r = getReservationById(resId);

        if( r.isPresent() ) {
            Reservation reservation = r.get();

            if(reservation.getApproved()){
                if(!reservation.getPaid())
                {
                    Payment payment = new Payment(reservation);
                    payment = this.paymentService.savePayment(payment);
                    reservation.setPaid(true);
                    reservation.setPayment(payment);
                    reservationRepository.save(reservation);
                }
            }
        }

        return r;


    }


}
