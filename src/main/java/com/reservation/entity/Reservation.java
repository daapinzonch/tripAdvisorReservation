package com.reservation.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZonedDateTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Details about Reservation")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated Reservation ID")
    private Long id;

    @NotNull
    @ApiModelProperty(notes = "The associated Client ID")
    private Long clientId;
    @NotNull
    @ApiModelProperty(notes = "The associated Provider ID")
    private Long providerId;

    @NotNull
    @ApiModelProperty(notes = "The associated Post ID")
    private String postId;

    @NotNull
    @ApiModelProperty(notes = "Reservation starting time (Date and Time)")
    private ZonedDateTime startTime;

    @ApiModelProperty(notes = "Reservation ending time (Date and Time)")
    private ZonedDateTime endTime;

    @ApiModelProperty(notes = "Amount of people who will use the reserved service")
    private Integer amount;

    @Positive(message = "Prize should not be negative or zero.")
    @ApiModelProperty(notes = "Reservation's unit cost.")
    private BigDecimal prizePerHead;

    @ApiModelProperty(notes = "Creation timestamp.")
    private Timestamp timeStamp;

    @ApiModelProperty(notes = "Payment status.")
    private Boolean paid;
    @ApiModelProperty(notes = "Approbation status.")
    private Boolean approved;

    @OneToOne
    @OrderBy("id")
    @ApiModelProperty(notes = "Payment associated with the reservation.")
    private Payment payment;

    public Reservation(ReservationRequest reservationRequest){

        this.postId = reservationRequest.getPostId();
        this.clientId = reservationRequest.getClientId();
        this.providerId = reservationRequest.getProviderId();
        this.startTime = reservationRequest.getStartTime();
        this.endTime = reservationRequest.getEndTime();
        this.amount = reservationRequest.getAmount();
        this.prizePerHead = reservationRequest.getPrizePerHead();
        this.timeStamp  = Timestamp.from(Instant.now());
        this.paid = false;
        this.approved = false;


    }

}
