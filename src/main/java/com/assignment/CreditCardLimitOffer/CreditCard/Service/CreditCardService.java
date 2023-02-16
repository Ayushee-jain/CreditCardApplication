package com.assignment.CreditCardLimitOffer.CreditCard.Service;

import com.assignment.CreditCardLimitOffer.CreditCard.Model.CreditCardDetails;
import com.assignment.CreditCardLimitOffer.CreditCard.Repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {

    @Autowired
    CreditCardRepository creditCardRepository;

    public List<CreditCardDetails> findByAccountId(Long account_id) {
        return creditCardRepository.findByAccountId(account_id);
    }

    public CreditCardDetails saveCreditCardDetails(CreditCardDetails creditCardDetail) {
        return creditCardRepository.save(creditCardDetail);
    }
}
