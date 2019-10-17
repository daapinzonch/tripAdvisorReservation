package com.reservation.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Details about Payment entity")
public class Payment {

    @Id
    @GeneratedValue
    @ApiModelProperty(notes = "The database generated Payment ID")
    Long id;
    @NotNull
    @ApiModelProperty(notes = "The associated reservation ID")
    Long reservationId;
    @Positive
    @ApiModelProperty(notes = "Total price.")
    BigDecimal totalPrice;
    @NotNull
    @ApiModelProperty(notes = "Creation timestamp.")
    LocalDateTime creationDateTime;

    public Payment(Reservation reservation){
        this.reservationId      =  reservation.getId();
        this.totalPrice         =  reservation.getPrizePerHead().multiply(BigDecimal.valueOf(reservation.getAmount()));
        this.creationDateTime   =  LocalDateTime.now();

    }


}
