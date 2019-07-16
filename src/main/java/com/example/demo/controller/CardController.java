package com.example.demo.controller;

import com.example.demo.dto.Transfer;
import com.example.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class CardController {

	@Autowired CardService cardService;

	@PatchMapping("/v1/cards/{cardId}")
	public void chargeCard(@RequestParam BigDecimal amount, @PathVariable String cardId) {
		cardService.charge(amount, cardId);
	}

	@PatchMapping("/v1/cards/{cardId}")
	public void withdraw(@PathVariable String cardId, @RequestParam BigDecimal amount) {
		cardService.withdraw(cardId, amount);
	}

	@PutMapping("/v1/replenish/cards/")
	public void sendMoney(@RequestBody Transfer transfer) {
		cardService.sendMoney(transfer);
	}
}
