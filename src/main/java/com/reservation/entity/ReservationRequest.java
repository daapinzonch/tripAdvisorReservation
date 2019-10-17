package com.reservation.entity;

import lombok.Data;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
public class ReservationRequest {


    @NotNull
    String postId;
    @NotNull
    private Long clientId;
    @NotNull
    private Long providerId;
    @NotNull
    @FutureOrPresent(message = "The reservation shouldn't have started already.")
    private ZonedDateTime startTime;
    @NotNull
    @Future(message = "The reservation cannot end someday in the past.")
    private ZonedDateTime endTime;
    @Positive
    private BigDecimal prizePerHead;
    @Positive
    private Integer amount;

}
