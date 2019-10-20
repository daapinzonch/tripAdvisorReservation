package com.reservation.controller;

import com.reservation.entity.Payment;
import com.reservation.service.PaymentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Reservation Microservices", description = "Operations related to Payments")
@RequestMapping("/payment/")
@CrossOrigin(origins = "*")
public class PaymentController {
    @Autowired
    PaymentService paymentService;


    @ApiOperation(value = "Get all payment records", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "List retrieved successfully"),
            @ApiResponse(code = 403, message = "Error")
    })
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Payment>> getAllPayments() {
        try {
            return new ResponseEntity<>(paymentService.getAllPayments(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }



}
