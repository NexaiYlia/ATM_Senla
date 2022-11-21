package com.nexai.service.impl;

import com.nexai.model.Bank;
import com.nexai.model.Card;
import com.nexai.service.CardService;
import com.nexai.validator.CardValidator;

import java.util.Scanner;

public class CardServiceImpl implements CardService {
    Bank bank = Bank.getInstance();
    Scanner input = new Scanner(System.in);

    public Card inputCard() {
        Card card = null;
        boolean flag = false;
        while (!flag) {
            System.out.println("Please, enter your bank card in the format:XXXX-XXXX-XXXX-XXXX");
            String inputCard = input.nextLine();
            if (CardValidator.validateCardNumber(inputCard)&& inputCard != null) {
                card = bank.getCards()
                        .stream()
                        .filter(o -> inputCard.toString().equals(o.getCardNumber()))
                        .findAny()
                        .orElse(null);
                if (card != null) {
                    flag = true;
                }
            }
        }
        System.out.println(card);
        if (!card.isBlock()) {
            if (tryInputCard(card)) {
                System.out.println("Successful login");
                return card;
            }
        } else {
            System.out.println("Data entered incorrectly! The card is blocked!");
        }
        return null;
    }

    private boolean tryInputCard(Card card) {
        String password;
        System.out.println("Please, enter your pin code:");
        for (int i = 3; i >= 0; i--) {
            if (i != 0) {
                password = input.next();
                while (!CardValidator.validPassword(password)) {
                    System.out.println("Invalid number entered!");
                    password = input.next();
                }
                if (card.getPinCode().equals(password.toString())) {
                    break;
                } else {
                    System.out.println("Wrong password was entered!\nRemaining tries:" + (i - 1));
                }
            } else {
                card.setBlock(true);
                System.out.println("Data entered incorrectly! The card is blocked!");
                return false;
            }
        }
        return true;
    }
}
