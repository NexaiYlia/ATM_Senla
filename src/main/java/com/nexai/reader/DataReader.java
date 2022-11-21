package com.nexai.reader;

import com.nexai.model.Card;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    public static final String filePath = "src/main/resources/cards.txt";

    public static List<Card> getCards() {
        List<Card> cards = new ArrayList<>();
        String line = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            while ((line = bufferedReader.readLine()) != null) {
                cards.add(createCard(line));
            }
        } catch (IOException e) {
            System.out.println("File read error. Try again,please.");
        }
        return cards;
    }

    private static Card createCard(String line) {
        Card card = new Card();
        card.setCardNumber(line.substring(17, 36));
        card.setPinCode(line.substring(47, 51));
        card.setBalance(Integer.parseInt(line.substring(line.indexOf("balance=") + 8, line.indexOf(",", line.indexOf("balance=")))));
        card.setBlock(Boolean.parseBoolean(line.substring(line.indexOf("block=") + 6, line.indexOf("}", line.indexOf("block=")))));
        return card;
    }
}
