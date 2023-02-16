package com.assignment.CreditCardLimitOffer.CreditCard.Repository;

import com.assignment.CreditCardLimitOffer.CreditCard.Enum.LimitOfferStatus;
import com.assignment.CreditCardLimitOffer.CreditCard.Model.LimitOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LimitOfferRepository extends JpaRepository<LimitOffer, Long> {
    List<LimitOffer> findAllByAccountIdAndStatus(Long accountId, LimitOfferStatus limitOfferStatus);

    LimitOffer findByLimitOfferId(Long limitOfferId);
}
