package com.nexai;

import com.nexai.model.Atm;
import com.nexai.model.Card;
import com.nexai.reader.DataReader;
import com.nexai.service.impl.AtmServiceImpl;
import com.nexai.service.impl.CardServiceImpl;
import com.nexai.writer.DataWriter;

import java.util.Set;

public class App {
    public static void main(String[] args)  {
        Set<Card> cards = DataReader.getCards();
        DataWriter writer = new DataWriter();
        System.out.println(cards);
        CardServiceImpl cardService = new CardServiceImpl();
        AtmServiceImpl service = new AtmServiceImpl();
        Card card = cardService.checkCardNumber();
        if (card != null) {
            service.menu(card);
            cards.add(card);
        }
        writer.writeCardsInFile(cards);
    }
}
