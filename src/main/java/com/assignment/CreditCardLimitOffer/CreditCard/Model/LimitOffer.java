package com.assignment.CreditCardLimitOffer.CreditCard.Model;

import com.assignment.CreditCardLimitOffer.CreditCard.Enum.LimitOfferStatus;
import com.assignment.CreditCardLimitOffer.CreditCard.Enum.LimitType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "limit_offer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LimitOffer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long limitOfferId;
    public Long limitValue;
    private Long accountId;


    public LimitOfferStatus status;
    public LimitType limitType;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    public Date offerActivationTime;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    public Date offerExpiryTime;

}
