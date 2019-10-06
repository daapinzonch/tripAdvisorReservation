package com.reservation.reservation.controller;

import com.reservation.reservation.entity.Reservation;
import com.reservation.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/reservation")
@RestController
public class ReservationController {

    @Autowired
    ReservationService resService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Reservation saveReservation(@RequestBody Reservation reservation){
        return resService.save(reservation);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Reservation> getAllReservations(){
        return resService.getAll();
    }

    @RequestMapping(value = "/provider/{providerId}", method = RequestMethod.GET)
    public List<Reservation> getProviderReservations(@PathVariable("providerId") Long providerId){
        return resService.getAllByProviderId(providerId);
    }

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public List<Reservation> getPostReservations(@RequestBody String postId){
        return resService.getAllByPostId(postId);
    }

    @RequestMapping(value = "/{reservationId}",method = RequestMethod.PUT)
    public Reservation answerReservation(@PathVariable("reservationId") Long reservationId){
        return resService.markReservationAsAnswered(reservationId);
    }

    @RequestMapping(value = "/client/{clientId}", method = RequestMethod.GET)
    public List<Reservation> getClientReservations(@PathVariable("clientId") Long clientId){
        return resService.getAllByClientId(clientId);
    }

    @RequestMapping(value="/{reservationId}",method = RequestMethod.DELETE)
    public Reservation rejectReservation(@PathVariable("reservationId") Long reservationId){
        Optional<Reservation> found = resService.getReservationById(reservationId);
        resService.rejectReservation(reservationId);
        if(found.isPresent()){
            return found.get();
        }else{
            return null;
        }
    }

}
