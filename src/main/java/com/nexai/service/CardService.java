package com.nexai.service;

import com.nexai.model.Card;

public interface CardService {
    Card checkCardNumber();

    boolean checkPinCode(Card card);
}
