package com.reservation.reservation.controller;

import com.reservation.reservation.entity.Reservation;
import com.reservation.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    ReservationService resService;

    @RequestMapping(value = "/reservation", method = RequestMethod.POST)
    public Reservation getProviderReservations(@RequestBody Reservation reservation){
        return resService.save(reservation);
    }

    @RequestMapping(value = "/reservation/provider/{providerId}", method = RequestMethod.GET)
    public List<Reservation> getProviderReservation(@PathVariable("providerId") Long providerId){
        return resService.getAllByProviderId(providerId);
    }

    @RequestMapping(value = "/reservation",method = RequestMethod.PUT)
    public Reservation answerReservation(@RequestBody Long reservationId){
        return resService.markReservationAsAnswered(reservationId);
    }

    @RequestMapping(value = "/reservation/client/{clientId}", method = RequestMethod.GET)
    public List<Reservation> getClientReservations(@PathVariable("clientId") Long clientId){
        return resService.getAllByClientId(clientId);
    }

}
