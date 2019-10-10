package com.reservation.controller;

import com.reservation.entity.Reservation;
import com.reservation.service.ReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(value="Reservation Microservices",description="Operations related to Reservations")
@RequestMapping("/reservation")
@RestController
public class ReservationController {

    @Autowired
    ReservationService resService;

    @ApiOperation(value="Store a reservation",response = Reservation.class)
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Reservation saveReservation(
            @ApiParam(value = "Reservation object to store", required = true)@RequestBody Reservation reservation){
        return resService.save(reservation);
    }

    @ApiOperation(value="Get all reservations",response = List.class)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Reservation> getAllReservations(){
        return resService.getAll();
    }

    @ApiOperation(value="Get all reservations from a specific provider",response = List.class)
    @RequestMapping(value = "/provider/{providerId}", method = RequestMethod.GET)
    public List<Reservation> getProviderReservations(
            @ApiParam(value = "Provider Id for filtering", required = true)@PathVariable("providerId") Long providerId){
        return resService.getAllByProviderId(providerId);
    }


    @ApiOperation(value="Get all reservations from a specific post",response = List.class)
    @GetMapping(value = "/post/{postId}")
    public List<Reservation> getPostReservations(
            @ApiParam(value = "Post Id for filtering (String)", required = true)@PathVariable("postId") String postId){
        return resService.getAllByPostId(postId);
    }

    @ApiOperation(value="Answer a reservation. Not defined",response = Reservation.class)
    @RequestMapping(value = "/{reservationId}",method = RequestMethod.PUT)
    public Reservation answerReservation(
            @ApiParam(value = "Id of reservation", required = true)@PathVariable("reservationId") Long reservationId){
        return resService.markReservationAsAnswered(reservationId);
    }

    @ApiOperation(value="Get all reservations from a specific client",response = List.class)
    @RequestMapping(value = "/client/{clientId}", method = RequestMethod.GET)
    public List<Reservation> getClientReservations(
            @ApiParam(value = "Client Id for filtering", required = true)@PathVariable("clientId") Long clientId){
        return resService.getAllByClientId(clientId);
    }

    @ApiOperation(value="Delete a reservation",response = Reservation.class)
    @RequestMapping(value="/{reservationId}",method = RequestMethod.DELETE)
    public Reservation rejectReservation(
            @ApiParam(value = "Reservation Id", required = true)@PathVariable("reservationId") Long reservationId){
        Optional<Reservation> found = resService.getReservationById(reservationId);
        resService.rejectReservation(reservationId);
        if(found.isPresent()){
            return found.get();
        }else{
            return null;
        }
    }

}
