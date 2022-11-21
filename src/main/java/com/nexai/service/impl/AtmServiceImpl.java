package com.nexai.service.impl;

import com.nexai.model.Atm;
import com.nexai.model.Bank;
import com.nexai.model.Card;
import com.nexai.service.AtmService;
import com.nexai.validator.CardValidator;

import java.util.Scanner;

public class AtmServiceImpl implements AtmService {

    Atm atm = Atm.getInstance();
    Bank bank = new Bank();
    Scanner input = new Scanner(System.in);


    public void run() throws InterruptedException {

    }

    public void menu(Card card) throws InterruptedException {
        boolean result = true;
        while (result) {
            System.out.println("Choose an operation:\n" +
                    "1)Card balance\n" +
                    "2) Balance replenishment\n" +
                    "3) Cash withdrawal\n" +
                    "4) Exit");
            int n = input.nextInt();
            switch (n) {
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
                    int minMoneyWithCard = input.nextInt();
                    if (card.getBalance() >= minMoneyWithCard) {
                        if (atm.getAvailableCash() >= minMoneyWithCard) {
                            card.setBalance(card.getBalance() - minMoneyWithCard);
                            atm.setAvailableCash(atm.getAvailableCash() - minMoneyWithCard);
                        } else {
                            System.out.println("Not enough cash in the ATM!");
                        }
                    } else {
                        System.out.println("Not enough balance on the card!");
                    }
                    break;
                case 4:
                    result = false;
                    break;
                default:
                    System.out.println("Invalid operation number. Choose from the list!");
                    break;
            }
        }
    }
}


