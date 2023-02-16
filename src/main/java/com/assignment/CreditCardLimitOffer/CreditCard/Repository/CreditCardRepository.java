package com.assignment.CreditCardLimitOffer.CreditCard.Repository;

import com.assignment.CreditCardLimitOffer.CreditCard.Model.CreditCardDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCardDetails, Long> {

    List<CreditCardDetails> findByAccountId(Long account_id);

}
