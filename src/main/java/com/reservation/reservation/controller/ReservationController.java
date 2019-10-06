package com.reservation.reservation.controller;

import com.reservation.reservation.entity.Reservation;
import com.reservation.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    ReservationService resService;

    @RequestMapping(value = "/reservation", method = RequestMethod.POST)
    public Reservation getProviderReservations(@RequestBody Reservation reservation){
        return resService.save(reservation);
    }

    @RequestMapping(value = "/reservation/provider", method = RequestMethod.GET)
    public List<Reservation> getProviderReservation(@RequestBody Long providerId){
        return resService.getAllByProviderId(providerId);
    }

    @RequestMapping(value = "/reservation",method = RequestMethod.PUT)
    public Reservation answerReservation(@RequestBody Long reservationId){
        return resService.markReservationAsAnswered(reservationId);
    }

    @RequestMapping(value = "/reservation/client", method = RequestMethod.GET)
    public List<Reservation> getClientReservations(@RequestBody Long clientId){
        return resService.getAllByClientId(clientId);
    }


}
