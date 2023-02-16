package com.assignment.CreditCardLimitOffer.CreditCard.Controller;

import com.assignment.CreditCardLimitOffer.CreditCard.Enum.LimitOfferStatus;
import com.assignment.CreditCardLimitOffer.CreditCard.Exception.ExceptionRequest;
import com.assignment.CreditCardLimitOffer.CreditCard.Helper.CreditCardHelper;
import com.assignment.CreditCardLimitOffer.CreditCard.Helper.LimitOfferHelper;
import com.assignment.CreditCardLimitOffer.CreditCard.Model.CreditCardDetails;
import com.assignment.CreditCardLimitOffer.CreditCard.Model.LimitOffer;
import com.assignment.CreditCardLimitOffer.CreditCard.Service.CreditCardService;
import com.assignment.CreditCardLimitOffer.CreditCard.Service.LimitOfferService;
import com.assignment.CreditCardLimitOffer.CreditCard.Utils.UtilsHelper;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.NonNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class LimitOfferController {

    @Autowired
    private LimitOfferService limitOfferService;

    @Autowired
    private CreditCardService creditCardService;

    @Autowired
    private LimitOfferHelper limitOfferHelper;

    @Autowired
    private CreditCardHelper creditCardHelper;

    @PostMapping("/create_limit_offer")
    public ResponseEntity<?> createLimitOffer(@RequestBody LimitOffer limitOffer) {
        List<CreditCardDetails> creditCardDetailsList = creditCardService.findByAccountId(limitOffer.getAccountId());
        LimitOffer newLimitOffer = limitOfferHelper.helper(creditCardDetailsList, limitOffer);
        if(newLimitOffer.getStatus() == LimitOfferStatus.PENDING) {
            return new ResponseEntity<>(limitOfferService.saveLimitOffer(newLimitOffer), HttpStatus.OK);
        }
        ExceptionRequest errorResponse = new ExceptionRequest();
        errorResponse.setMessage(UtilsHelper.accountNotFound);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/active_limit_offers")
    public List<LimitOffer> AllActiveLimitOffer(@NonNull Long accountId, String activeDate) throws Exception {
        Date date=new SimpleDateFormat("dd-MM-yyyy").parse(activeDate);
        return limitOfferService.findAllByAccountIdAndStatus(accountId, date);
    }

    @PutMapping("/update_limit_offer_status")
    public ResponseEntity<?> UpdateLimitOfferStatus(@NotNull Long limitOfferId, @NotNull String status) {
        status = status.toUpperCase();
        if(status.equals("ACCEPTED")) {
            LimitOffer limitOffer = limitOfferService.findByLimitOfferId(limitOfferId);
            Long account_id = limitOffer.getAccountId();
            List<CreditCardDetails> creditCardDetailsList = creditCardService.findByAccountId(account_id);
            List<CreditCardDetails> creditCardDetails = creditCardHelper.helper(creditCardDetailsList, limitOffer);
            return new ResponseEntity<>(creditCardDetails, HttpStatus.OK);
        }
        else if(status.equals("REJECTED")) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
        }
        ExceptionRequest errorResponse = new ExceptionRequest();
        errorResponse.setMessage(UtilsHelper.badRequest);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
