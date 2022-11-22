package com.nexai.service.impl;

import com.nexai.model.Atm;
import com.nexai.model.Card;
import com.nexai.service.AtmService;

import java.util.Scanner;

public class AtmServiceImpl implements AtmService {

    public Atm atm = Atm.getInstance();
    Scanner input = new Scanner(System.in);

    public void menu(Card card)  {
        boolean result = true;
        while (result) {
            System.out.println("Choose an operation:\n" +
                    "1) Card balance\n" +
                    "2) Balance replenishment\n" +
                    "3) Cash withdrawal\n" +
                    "4) Exit");
            int number = input.nextInt();
            switch (number) {
                case 1:
                    System.out.println("You balance:" + card.getBalance());
                    break;
                case 2:
                    System.out.println("Enter the amount to replenish the balance:");
                    int addMoneyForCard = input.nextInt();
                    card.setBalance(card.getBalance() + addMoneyForCard);
                    atm.setAvailableCash(atm.getAvailableCash() + addMoneyForCard);
                    break;
                case 3:
                    System.out.println("Enter cash withdrawal amount:");
                    int cashAdvance = input.nextInt();
                    if (card.getBalance() >= cashAdvance) {
                        if (atm.getAvailableCash() >= cashAdvance) {
                            card.setBalance(card.getBalance() - cashAdvance);
                            atm.setAvailableCash(atm.getAvailableCash() - cashAdvance);
                            break;
                        } else {
                            System.out.println("Not enough cash in the ATM!");
                        }
                    } else {
                        System.out.println("Not enough balance on the card!");
                    }
                    break;
                case 4:
                    result = false;
                    System.out.println("Take your card, please. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid operation number. Choose from the list!");
                    break;
            }
        }
    }
}


