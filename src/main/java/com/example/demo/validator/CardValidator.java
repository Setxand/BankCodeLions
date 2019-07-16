package com.example.demo.validator;

import com.example.demo.model.Card;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CardValidator {

	public void validateAmount(Card card, BigDecimal amount) {
		if (card.getAmount().compareTo(amount) < 0)
			throw new IllegalArgumentException("Invalid amount");
	}
}
