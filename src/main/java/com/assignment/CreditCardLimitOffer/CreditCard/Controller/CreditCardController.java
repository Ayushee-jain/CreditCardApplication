package com.assignment.CreditCardLimitOffer.CreditCard.Controller;

import com.assignment.CreditCardLimitOffer.CreditCard.Model.CreditCardDetails;
import com.assignment.CreditCardLimitOffer.CreditCard.Service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @PostMapping("/create_account")
    public CreditCardDetails createCreditCardAccount(@RequestBody CreditCardDetails creditCardDetails) {
        return creditCardService.saveCreditCardDetails(creditCardDetails);
    }

    @GetMapping("/get_account/{account_id}")
    public CreditCardDetails getCreditCardAccounts(@PathVariable("account_id") Long accountId) {
        return creditCardService.findByAccountId(accountId).get(0);
    }
}
