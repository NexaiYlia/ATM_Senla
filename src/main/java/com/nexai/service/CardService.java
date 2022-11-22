package com.nexai.service;

import com.nexai.model.Card;
import com.nexai.validator.CardValidator;

public interface CardService {
    Card inputCard();

    boolean tryInputCard(Card card);
}
