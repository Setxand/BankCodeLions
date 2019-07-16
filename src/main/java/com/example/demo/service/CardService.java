package com.example.demo.service;

import com.example.demo.dto.Transfer;
import com.example.demo.model.Card;
import com.example.demo.repository.CardRepository;
import com.example.demo.validator.CardValidator;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
public class CardService {

	private final CardValidator validator;
	private final CardRepository cardRepo;

	public CardService(CardValidator validator, CardRepository cardRepo) {
		this.validator = validator;
		this.cardRepo = cardRepo;
	}

	@Transactional
	public void charge(BigDecimal amount, String cardId) {
		Card card = getCard(cardId);
		card.setAmount(amount);
	}

	@Transactional
	public void withdraw(String cardId, BigDecimal amount) {
		Card card = getCard(cardId);
		validator.validateAmount(card, amount);
		card.setAmount(card.getAmount().subtract(amount));
	}

	@Transactional
	public void sendMoney(Transfer transfer) {

		Card fromCard = getCard(transfer.fromCard);
		Card toCard = getCard(transfer.toCard);

		validator.validateAmount(fromCard, transfer.amount);

		fromCard.setAmount(fromCard.getAmount().subtract(transfer.amount));
		toCard.setAmount(toCard.getAmount().add(transfer.amount));
	}

	private Card getCard(String cardId) {
		return cardRepo.findById(cardId).orElseThrow(() -> new IllegalArgumentException("Invalid card ID"));
	}

}
