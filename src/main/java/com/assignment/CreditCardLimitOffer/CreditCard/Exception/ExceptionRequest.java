package com.assignment.CreditCardLimitOffer.CreditCard.Exception;

import lombok.Data;

@Data
public class ExceptionRequest extends Throwable {

    private String message;

}
