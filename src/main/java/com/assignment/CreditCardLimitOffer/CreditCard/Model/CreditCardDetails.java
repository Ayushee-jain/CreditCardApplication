package com.assignment.CreditCardLimitOffer.CreditCard.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "credit_card_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    @NotNull
    private Long customerId;
    private Long accountLimit;
    private Long perTransactionLimit;
    private Long lastAccountLimit;
    private Long lastPerTransactionLimit;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date accountLimitUpdateTime;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date perTransactionLimitUpdateTime;
}
