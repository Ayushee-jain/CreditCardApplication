package com.assignment.CreditCardLimitOffer.CreditCard.Helper;

import com.assignment.CreditCardLimitOffer.CreditCard.Enum.LimitOfferStatus;
import com.assignment.CreditCardLimitOffer.CreditCard.Enum.LimitType;
import com.assignment.CreditCardLimitOffer.CreditCard.Model.CreditCardDetails;
import com.assignment.CreditCardLimitOffer.CreditCard.Model.LimitOffer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LimitOfferHelper {

    public LimitOffer helper(List<CreditCardDetails> creditCardDetailsList, LimitOffer limitOffer) {
        for(CreditCardDetails creditCardDetails : creditCardDetailsList) {
            if(limitOffer.getLimitType() == LimitType.ACCOUNT_LIMIT && limitOffer.getLimitValue() > creditCardDetails.getAccountLimit()) {
                limitOffer.setStatus(LimitOfferStatus.PENDING);
                return limitOffer;
            }
            else if(limitOffer.getLimitType() == LimitType.PER_TRANSACTION_LIMIT && limitOffer.getLimitValue() > creditCardDetails.getPerTransactionLimit()) {
                limitOffer.setStatus(LimitOfferStatus.PENDING);
                return limitOffer;
            }
        }
        return limitOffer;
    }
}
