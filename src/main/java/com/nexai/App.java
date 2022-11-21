package com.nexai;

import com.nexai.model.Atm;
import com.nexai.model.Card;
import com.nexai.reader.DataReader;
import com.nexai.service.impl.AtmServiceImpl;
import com.nexai.service.impl.CardServiceImpl;

import java.util.List;
import java.util.Scanner;

public class App {
    public static Atm atm = Atm.getInstance();
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        List<Card> cards = DataReader.getCards();
        System.out.println(cards);
        CardServiceImpl cardService = new CardServiceImpl();
        AtmServiceImpl service = new AtmServiceImpl();
        System.out.println(cardService.inputCard());
        service.menu(cardService.inputCard());
    }
}
