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


    @NotNull private String postId;
    @NotNull private String clientId;
    @NotNull private String providerId;
    @FutureOrPresent(message = "The reservation shouldn't have started already.")
    @NotNull private ZonedDateTime startTime;
    @Future(message = "The reservation cannot end someday in the past.")
    @NotNull private ZonedDateTime endTime;
    @NotNull @Positive private BigDecimal prizePerHead;
    @NotNull @Positive private Integer amount;
}
