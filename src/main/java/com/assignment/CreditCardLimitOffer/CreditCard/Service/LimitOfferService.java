package com.assignment.CreditCardLimitOffer.CreditCard.Service;

import com.assignment.CreditCardLimitOffer.CreditCard.Enum.LimitOfferStatus;
import com.assignment.CreditCardLimitOffer.CreditCard.Model.LimitOffer;
import com.assignment.CreditCardLimitOffer.CreditCard.Repository.LimitOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LimitOfferService {

    @Autowired
    private LimitOfferRepository limitOfferRepository;

    public LimitOffer saveLimitOffer(LimitOffer limitOffer) {
        return limitOfferRepository.save(limitOffer);
    }

    public List<LimitOffer> findAllByAccountIdAndStatus(Long accountId, Date date) throws Exception {
        List<LimitOffer> limitOfferList = limitOfferRepository.findAllByAccountIdAndStatus(accountId, LimitOfferStatus.PENDING);
        List<LimitOffer> limitOffers = new ArrayList<>();
        for(LimitOffer limitOffer: limitOfferList) {
            if(date.after(limitOffer.getOfferActivationTime()) && date.before(limitOffer.getOfferExpiryTime())) {
                limitOffers.add(limitOffer);
            }
        }
        return limitOffers;
    }

    public LimitOffer findByLimitOfferId(Long limitOfferId) {
        return limitOfferRepository.findByLimitOfferId(limitOfferId);
    }
}
