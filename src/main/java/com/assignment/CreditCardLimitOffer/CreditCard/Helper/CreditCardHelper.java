package com.assignment.CreditCardLimitOffer.CreditCard.Helper;

import com.assignment.CreditCardLimitOffer.CreditCard.Enum.LimitType;
import com.assignment.CreditCardLimitOffer.CreditCard.Model.CreditCardDetails;
import com.assignment.CreditCardLimitOffer.CreditCard.Model.LimitOffer;
import com.assignment.CreditCardLimitOffer.CreditCard.Service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CreditCardHelper {

    @Autowired
    private CreditCardService creditCardService;

    public List<CreditCardDetails> helper(List<CreditCardDetails> creditCardDetailsList, LimitOffer limitOffer) {
        creditCardDetailsList.stream().map(creditCardDetail -> {
            if (limitOffer.getLimitType() == LimitType.ACCOUNT_LIMIT) {
                Long current_account_limit = creditCardDetail.getAccountLimit();
                creditCardDetail.setLastAccountLimit(current_account_limit);
                try {
                    creditCardDetail.setAccountLimitUpdateTime(new SimpleDateFormat("yyyy-MM-dd").parse(LocalDate.now().toString()));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            } else if (limitOffer.getLimitType() == LimitType.PER_TRANSACTION_LIMIT) {
                Long current_per_transaction_limit = creditCardDetail.getPerTransactionLimit();
                creditCardDetail.setLastPerTransactionLimit(current_per_transaction_limit);
                try {
                    creditCardDetail.setPerTransactionLimitUpdateTime(new SimpleDateFormat("yyyy-MM-dd").parse(LocalDate.now().toString()));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
            creditCardDetail.setAccountLimit(limitOffer.getLimitValue());
            return creditCardService.saveCreditCardDetails(creditCardDetail);
        }).collect(Collectors.toList());
        return creditCardDetailsList;
    }

}
