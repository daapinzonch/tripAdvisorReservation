package com.reservation.reservation.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
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
    Long id;

    @NotNull
    @ApiModelProperty(notes = "The associated Client ID")
    Long clientId;
    @NotNull
    @ApiModelProperty(notes = "The associated Provider ID")
    Long providerId;

    @NotNull
    @ApiModelProperty(notes = "The associated Post ID")
    String postId;

    @NotNull
    @ApiModelProperty(notes = "Reservation starting time (Date and Time)")
    ZonedDateTime startTime;

    @ApiModelProperty(notes = "Reservation ending time (Date and Time)")
    ZonedDateTime endTime;

    @ApiModelProperty(notes = "Ammount of people who will use the reservated service")
    int ammount;

}
